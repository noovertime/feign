package com.noovertime.feign.jsonplaceholder.type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post implements TypeDto {
    private Long userId;
    private Long id;
    private String title;
    private String body;

    @Override
    public String toString() {
        StringBuilder postBuilder = new StringBuilder();
        postBuilder.append("[ ")
                .append(this.id).append(" : ")
                .append(this.userId == null ? "" : this.userId).append(" : ")
                .append(this.truncateWithEllipsis( this.title)).append(" : ")
                .append(this.truncateWithEllipsis( this.body))
                .append("] ").append(System.getProperty("line.separator"));
        return postBuilder.toString();
    }
}
