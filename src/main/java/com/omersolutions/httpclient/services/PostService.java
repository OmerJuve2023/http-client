package com.omersolutions.httpclient.services;

import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class PostService {

    private final RestClient restClient;

    public String findAll() {
        return restClient
                .get()
                .uri("/posts")
                .retrieve()
                .body(String.class);
    }

    public PostService(RestClient.Builder restClient) {
        JdkClientHttpRequestFactory requestFactory = new JdkClientHttpRequestFactory();
        requestFactory.setReadTimeout(10000);
        this.restClient = restClient
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }
}