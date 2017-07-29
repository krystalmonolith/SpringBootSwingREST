package com.alphapulsar.sb01.rest;

class GetResponse extends RESTResponse {
    private String text;

    @SuppressWarnings("unused")
    String getText() {
        return text;
    }

    @SuppressWarnings("unused")
    void setText(String text) {
        this.text = text;
    }
}
