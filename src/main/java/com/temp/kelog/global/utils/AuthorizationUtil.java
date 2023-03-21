package com.temp.kelog.global.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Slf4j
@Component
public class AuthorizationUtil {

    public static String AUTHORIZATION = "Authorization";

    public static String extract(HttpServletRequest request, String type) {
        Enumeration<String> headers = request.getHeaders(AUTHORIZATION);

        while (headers.hasMoreElements()) {
            String value = headers.nextElement();
            if (value.toLowerCase().startsWith(type.toLowerCase())) {
                log.info(value.substring(type.length()).trim());
                return value.substring(type.length()).trim();
            }
        }

        return Strings.EMPTY;
    }
}
