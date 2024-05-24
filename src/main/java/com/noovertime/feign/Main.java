package com.noovertime.feign;

import com.noovertime.feign.etc.ErrorDecoder;
import com.noovertime.feign.jsonplaceholder.JsonPlaceHolderClient;
import com.noovertime.feign.jsonplaceholder.type.Post;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final String SERVER_DOMAIN = "https://jsonplaceholder.typicode.com";

    public static void main(String[] args) {
        JsonPlaceHolderClient client = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .errorDecoder(new ErrorDecoder())
                .target(JsonPlaceHolderClient.class, SERVER_DOMAIN);


        List<Post> postList;

        // GET
        postList = client.list();
        log.debug("조회 : {} 개", postList == null ? 0 : postList.size());

        // GET + 파라미터
        postList = client.list(1L);
        log.debug("조회 : {} 개", postList == null ? 0 : postList.size());

        // DELETE + 파라미터
        client.delete(3L);

        // POST + json + header (contentType)
        Post post = new Post();
        post.setUserId(9999L);
        post.setTitle("제목");
        post.setBody("내용");
        post = client.write("application/json", post);
        log.debug("작성 : {}", post);

        // error
        try {
            client.test404();
        }
        catch(Exception ex) {
            log.error("실패 테스트", ex);
        }
    }
}