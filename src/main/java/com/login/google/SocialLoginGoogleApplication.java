package com.login.google;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocialLoginGoogleApplication {
    public static void main(String[] args) {

        // .env 파일 읽기
        Dotenv dotenv = Dotenv.load();

        // 환경변수로 등록
        System.setProperty("GOOGLE_CLIENT_ID", dotenv.get("GOOGLE_CLIENT_ID"));
        System.setProperty("GOOGLE_CLIENT_SECRET", dotenv.get("GOOGLE_CLIENT_SECRET"));

        SpringApplication.run(SocialLoginGoogleApplication.class, args);
    }
}
