package com.omersolutions.httpclient;

import com.omersolutions.httpclient.services.PostService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HttpClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(HttpClientApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PostService postService) {
        return args -> {
            String post = postService.findAll();
            System.out.println(post);
        };
    }
}