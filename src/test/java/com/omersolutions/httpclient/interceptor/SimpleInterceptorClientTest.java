package com.omersolutions.httpclient.interceptor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SimpleInterceptorClientTest {
    @Autowired
    SimpleInterceptorClient simpleInterceptorClient;

    @Test
    void findAll() {
        String posts = simpleInterceptorClient.findAll();
        assertNotNull(posts);
        assertTrue(posts.contains("userId"));
        assertTrue(posts.contains("id"));
        assertTrue(posts.contains("title"));
        assertTrue(posts.contains("body"));
    }
}