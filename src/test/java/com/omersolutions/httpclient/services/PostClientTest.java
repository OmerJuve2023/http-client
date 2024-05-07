package com.omersolutions.httpclient.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.omersolutions.httpclient.post.Post;
import com.omersolutions.httpclient.post.PostClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RestClientTest(PostClient.class)
class PostClientTest {
    @Autowired
    MockRestServiceServer server;
    @Autowired
    PostClient postClient;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void findAll() throws JsonProcessingException {
        List<Post> data = List.of(
                new Post(1,
                        1,
                        "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                        "quia et suscipit\nsudita et cum\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto"),
                new Post(2,
                        1,
                        "qui est esse",
                        "est rerum temnsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla")
        );
        this.server
                .expect(requestTo("https://jsonplaceholder.typicode.com/posts"))
                .andRespond(withSuccess(
                        objectMapper.writeValueAsString(data), MediaType.APPLICATION_JSON));
        List<Post> posts = postClient.findAll();
        assertThat(posts.size()).isEqualTo(2);
    }
}