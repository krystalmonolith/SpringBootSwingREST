package com.alphapulsar.sb01.rest;

public class PutResponse extends RESTResponse {
    private String oldText;

    public String getOldText() {
        return oldText;
    }

    public void setOldText(String oldText) {
        this.oldText = oldText;
    }
}
