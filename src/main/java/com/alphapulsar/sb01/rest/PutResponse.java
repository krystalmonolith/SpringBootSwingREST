package com.alphapulsar.sb01.rest;

class PutResponse extends RESTResponse {
    private String oldText;

    @SuppressWarnings("unused")
    String getOldText() {
        return oldText;
    }

    @SuppressWarnings("unused")
    void setOldText(String oldText) {
        this.oldText = oldText;
    }
}
