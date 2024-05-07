package com.omersolutions.httpclient.interceptor;

import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.logging.Logger;

@Service
public class SimpleInterceptorClient {
    private final RestClient restClient;
    private final Logger logger = Logger.getLogger(MyInterceptor.class.getName());

    public SimpleInterceptorClient(RestClient.Builder restClient) {
        this.restClient = restClient
                .baseUrl("https://jsonplaceholder.typicode.com")
                .requestFactory(new JdkClientHttpRequestFactory())
                .build();
    }

    public String findAll() {
        logger.info("Request: " + restClient.get().uri("/posts").toString());
        return restClient
                .get()
                .uri("/posts")
                .retrieve()
                .body(String.class);
    }
}
