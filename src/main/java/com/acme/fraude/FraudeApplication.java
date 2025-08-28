package com.acme.fraude;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class FraudeApplication {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SpringApplication.run(FraudeApplication.class, args);
    }
}
