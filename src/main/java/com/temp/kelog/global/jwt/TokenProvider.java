package com.temp.kelog.global.jwt;

import com.temp.kelog.domain.user.entity.User;
import com.temp.kelog.domain.user.repository.UserRepository;
import com.temp.kelog.global.configuration.AppProperties;
import com.temp.kelog.global.enums.JwtAuth;
import com.temp.kelog.global.exception.BusinessException;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TokenProvider {
    private static final long JWT_ACCESS_EXPIRE = 1000 * 60 * 60 * 24;
    private static final long JWT_REFRESH_EXPIRE = 1000 * 60 * 60 * 24 * 7;
    private static final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;

    private final AppProperties appProperties;

    private final UserRepository userRepository;

    public String generateToken(String userId, JwtAuth jwtAuth) {
        Date expiredAt = new Date();
        expiredAt = (jwtAuth == JwtAuth.ACCESS_TOKEN)
                ? new Date(expiredAt.getTime() + JWT_ACCESS_EXPIRE)
                : new Date(expiredAt.getTime() + JWT_REFRESH_EXPIRE);
        String secretKey = (jwtAuth == JwtAuth.ACCESS_TOKEN)
                ? appProperties.getSecret()
                : appProperties.getRefreshSecret();

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(jwtAuth.toString())
                .setIssuedAt(new Date())
                .setExpiration(expiredAt)
                .signWith(SIGNATURE_ALGORITHM, secretKey)
                .compact();
    }

    private Claims parseToken(String token, JwtAuth jwtAuth) {
        try {
            return Jwts.parser()
                    .setSigningKey((jwtAuth == JwtAuth.ACCESS_TOKEN)
                            ? appProperties.getSecret()
                            : appProperties.getRefreshSecret())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw new BusinessException(HttpStatus.UNAUTHORIZED, "토큰이 만료되었습니다.");
        } catch (SignatureException | MalformedJwtException e) {
            throw new BusinessException(HttpStatus.UNAUTHORIZED, "위조된 토큰입니다.");
        } catch (IllegalArgumentException e) {
            throw new BusinessException(HttpStatus.BAD_REQUEST, "토큰이 존재하지 않습니다.");
        } catch (Exception e) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "토큰 서비스와의 오류가 발생하였습니다.");
        }
    }

    public User validateToken(String token) {
        return userRepository.findByEmail(
                        Long.valueOf(parseToken(token, JwtAuth.ACCESS_TOKEN)
                                .get("user_email")
                                .toString())
                )
                .orElseThrow(User.NotFoundException::new);
    }

    public String refreshToken(String refreshToken) {
        if (refreshToken == null || refreshToken.trim().isEmpty()) {
            throw new BusinessException(HttpStatus.BAD_REQUEST, "토큰이 존재하지 않습니다.");
        }

        Claims claims = parseToken(refreshToken, JwtAuth.REFRESH_TOKEN);

        User user = userRepository
                .findById(Long.parseLong(claims.get("userid").toString()))
                .orElseThrow(User.NotFoundException::new);
        return generateToken(user.getId().toString(), JwtAuth.ACCESS_TOKEN);
    }
}
