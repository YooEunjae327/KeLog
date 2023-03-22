package com.temp.kelog.global.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConfigurationProperties(prefix = "app")
@Data
public class AppProperties {

    @Value("{app.secret}")
    private String secret;

    @Value("{app.refresh-secret: dote}")
    private String refreshSecret;

    @Value("{app.client-Email}")
    private String clientEmail;

    @Value("{app.client-secret}")
    private String clientSecret;

}
