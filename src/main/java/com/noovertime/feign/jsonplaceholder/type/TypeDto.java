package com.noovertime.feign.jsonplaceholder.type;

public interface TypeDto {
    int MAX_LENGTH =10;

    default String truncateWithEllipsis(String value) {
        if(value == null) {
            return "";
        }

        if(value.length() < MAX_LENGTH) {
            return value;
        }

        return value.substring(0, MAX_LENGTH) + "...";
    }
}
