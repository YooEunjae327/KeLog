//package com.temp.kelog.domain.token.utils;
//
//import com.temp.kelog.domain.user.entity.User;
//import io.jsonwebtoken.*;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import javax.crypto.spec.SecretKeySpec;
//import javax.xml.bind.DatatypeConverter;
//import java.security.Key;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.lang.String;
//
//@RequiredArgsConstructor
//@Service
//public class TokenUtils {
//
//    @Value("${jwt.secret_key}")
//    private final String SECRET_KEY;
//
//    @Value("${jwt.refresh_key}")
//    private final String REFRESH_KEY;
//
//    @Value("${jwt.data_key}")
//    private final String DATA_KEY;
//
//
//    public String generateJWtToken(User user) {
//        return Jwts.builder()
//                .setSubject(user.getUsername())
//                .setHeader(createHeader())
//                .setClaims(createClaims(user))
//                .setExpiration(createExpireDate(1000 * 60 * 5))
//                .compact();
//    }
//
//    public String saveRefreshToken(User user) {
//        return Jwts.builder()
//                .setSubject(user.getUsername())
//                .setHeader(createHeader())
//                .setClaims(createClaims(user))
//                .setExpiration(createExpireDate(1000 * 60 * 10))
//                .signWith(SignatureAlgorithm.HS256, createSigningKey(REFRESH_KEY))
//                .compact();
//    }
//
//    public boolean isValidToken(String token) {
//        System.out.println("isValidToken is : " +token);
//        try {
//            Claims accessClaims = getClaimsFormToken(token);
//            System.out.println("Access expireTime: " + accessClaims.getExpiration());
//            System.out.println("Access userId: " + accessClaims.get("userId"));
//            return true;
//        } catch (ExpiredJwtException exception) {
//            System.out.println("Token Expired UserID : " + exception.getClaims().getSubject());
//            return false;
//        } catch (JwtException exception) {
//            System.out.println("Token Tampered");
//            return false;
//        } catch (NullPointerException exception) {
//            System.out.println("Token is null");
//            return false;
//        }
//    }
//    public boolean isValidRefreshToken(String token) {
//        try {
//            Claims accessClaims = getClaimsToken(token);
//            System.out.println("Access expireTime: " + accessClaims.getExpiration());
//            System.out.println("Access userId: " + accessClaims.get("userId"));
//            return true;
//        } catch (ExpiredJwtException exception) {
//            System.out.println("Token Expired UserID : " + exception.getClaims().getSubject());
//            return false;
//        } catch (JwtException exception) {
//            System.out.println("Token Tampered");
//            return false;
//        } catch (NullPointerException exception) {
//            System.out.println("Token is null");
//            return false;
//        }
//    }
//
//
//    private Date createExpireDate(long expireDate) {
//        long curTime = System.currentTimeMillis();
//        return new Date(curTime + expireDate);
//    }
//
//    private Map<String, Object> createHeader() {
//        Map<String, Object> header = new HashMap<>();
//
//        header.put("typ", "ACCESS_TOKEN");
//        header.put("alg", "HS256");
//        header.put("regDate", System.currentTimeMillis());
//
//        return header;
//    }
//
//    private Map<String, Object> createClaims(User user) {
//        Map<String, Object> claims = new HashMap<>();
//        claims.put(DATA_KEY, user.getUsername());
//        return claims;
//    }
//
//    private Key createSigningKey(String key) {
//        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key);
//        return new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());
//    }
//
//    private Claims getClaimsFormToken(String token) {
//        return Jwts.parser()
//                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//    private Claims getClaimsToken(String token) {
//        return Jwts.parser()
//                .setSigningKey(DatatypeConverter.parseBase64Binary(REFRESH_KEY))
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//}
