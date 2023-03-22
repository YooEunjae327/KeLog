package com.temp.kelog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KelogApplication {

    /*
    * 서비스 실행 지연 방지
    * */
    static {
        System.setProperty("com.amazonaws.sdk.disableEc2Metadata", "true");
    }
    public static void main(String[] args) {
        SpringApplication.run(KelogApplication.class, args);
    }

}
