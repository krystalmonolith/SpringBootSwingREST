package com.alphapulsar.sb01.rest;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RESTResponse {
    private LocalDateTime localDateTime;
    private String error;

    public RESTResponse() {
        localDateTime = LocalDateTime.now();
    }

    public String getLocalDateTime() {
        return localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
