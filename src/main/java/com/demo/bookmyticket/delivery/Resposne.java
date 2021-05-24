package com.demo.bookmyticket.delivery;

import com.google.gson.JsonElement;

public class Resposne {
    private int status;
    private String message;
    private JsonElement data;

    public Resposne(int status, String message, JsonElement data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Resposne(int status) {
        this.status = status;
    }

    public Resposne(int status, String message) {
        this.status = status;
        this.message = message;
    }
}

