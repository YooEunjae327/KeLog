package com.temp.kelog.domain.token.utils;

import com.temp.kelog.domain.user.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.xml.bind.DatatypeConverter;

@RequiredArgsConstructor
@Service
public class TokenUtils {

    @Value("${jwt.secret_key}")
    private final String SECRET_KEY;

    @Value("${jwt.refresh_key}")
    private final String REFRESH_KEY;

    @Value("${jwt.data_key}")
    private final String DATA_KEY;

}
