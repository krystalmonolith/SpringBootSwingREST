package com.alphapulsar.sb01.rest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GetResponse {
    private String text;
    private LocalDateTime localDateTime;

    public GetResponse() {
        localDateTime = LocalDateTime.now();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLocalDateTime() {
        return localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
    }
}
