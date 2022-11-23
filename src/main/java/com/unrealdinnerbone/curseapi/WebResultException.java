package com.unrealdinnerbone.curseapi;


public class WebResultException extends Exception {

    public WebResultException(String url, String body, int code) {
        super(url + " returned an " + code + " with body: " + body);
    }

}
