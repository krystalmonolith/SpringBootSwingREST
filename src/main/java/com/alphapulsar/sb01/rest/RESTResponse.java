package com.alphapulsar.sb01.rest;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class RESTResponse {
    private LocalDateTime localDateTime;
    private String error;

    RESTResponse() {
        localDateTime = LocalDateTime.now();
    }

    @SuppressWarnings("unused")
    String getLocalDateTime() {
        return localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
    }

    @SuppressWarnings("unused")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String getError() {
        return error;
    }

    @SuppressWarnings("unused")
    void setError(String error) {
        this.error = error;
    }
}
