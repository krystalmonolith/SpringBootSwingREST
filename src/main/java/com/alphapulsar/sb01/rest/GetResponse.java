package com.alphapulsar.sb01.rest;

public class GetResponse extends RESTResponse {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
