package com.omersolutions.httpclient.interceptor;

import io.micrometer.common.lang.NonNull;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.Logger;

@Component
public class MyInterceptor implements ClientHttpRequestInterceptor {
    private final Logger logger = Logger.getLogger(MyInterceptor.class.getName());

    @Override
    public ClientHttpResponse intercept(HttpRequest request,
                                        @NonNull byte[] body,
                                        ClientHttpRequestExecution execution) throws IOException {
        logger.info("Request: " + request.getURI());
        request.getHeaders().add("x-request-id", "12345");
        return execution.execute(request, body);
    }
}
