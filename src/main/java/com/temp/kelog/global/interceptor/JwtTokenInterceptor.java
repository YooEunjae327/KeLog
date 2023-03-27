package com.temp.kelog.global.interceptor;

import com.temp.kelog.domain.user.entity.User;
import com.temp.kelog.global.annotations.AuthToken;
import com.temp.kelog.global.jwt.TokenProvider;
import com.temp.kelog.global.utils.AuthorizationUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenInterceptor implements HandlerInterceptor {

    private final TokenProvider tokenProvider;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("[{}] request uri: {}", request.getMethod(), request.getRequestURI());
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if (!handlerMethod.getMethod().isAnnotationPresent(AuthToken.class)) {
            return true;
        }

        String token = AuthorizationUtil.extract(request, "Bearer");
        if(token.equals("")) {
            throw new User.NotFoundException();
        }
        log.info("testing");


        User user = tokenProvider.validateToken(token);
        log.info("validate next testing");
        request.setAttribute("user", user);

        return true;
    }
}
