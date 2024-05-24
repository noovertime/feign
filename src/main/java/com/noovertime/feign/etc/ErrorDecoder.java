package com.noovertime.feign.etc;

import feign.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ErrorDecoder implements feign.codec.ErrorDecoder {
    private static final String NEW_LINE = System.getProperty("line.separator");

    @Override
    public Exception decode(String s, Response response) {
        StringBuilder errorBuilder = new StringBuilder(NEW_LINE);
        errorBuilder.append("실패응답 핸들링 ").append(NEW_LINE)
                .append("- client : ").append(s).append(NEW_LINE)
                .append("- status : ").append(response.status())
                .append(" / ").append(response.reason()).append(NEW_LINE);

        log.error("{}", errorBuilder);

        return new Exception("실패응답수신");
    }
}
