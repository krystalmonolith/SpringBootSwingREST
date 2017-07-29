package com.alphapulsar.sb01.rest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PutResponse {
    private String oldText;
    private LocalDateTime localDateTime;

    public PutResponse() {
        localDateTime = LocalDateTime.now();
    }

    public String getOldText() {
        return oldText;
    }

    public void setOldText(String oldText) {
        this.oldText = oldText;
    }

    public String getLocalDateTime() {
        return localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
    }
}
