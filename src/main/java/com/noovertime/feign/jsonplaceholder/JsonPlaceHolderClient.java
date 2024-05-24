package com.noovertime.feign.jsonplaceholder;

import com.noovertime.feign.jsonplaceholder.type.Post;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import java.util.List;

public interface JsonPlaceHolderClient {
    @RequestLine("GET /posts")
    List<Post> list();

    @RequestLine("GET /posts?userId={userId}")
    List<Post> list(@Param("userId") long userId);

    @RequestLine("DELETE /posts/{id}")
    void delete(@Param("id") long postId);

    @Headers("Content-type : {contentType}")
    @RequestLine("POST /posts")
    Post write(@Param("contentType") String contentType, Post post);

    @RequestLine("GET /error") // 없는 주소라서 404 응답 나옴
    void test404();
}
