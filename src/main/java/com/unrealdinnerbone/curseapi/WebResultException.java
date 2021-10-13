package com.unrealdinnerbone.curseapi;


public class WebResultException extends Exception {

    public WebResultException(String url, int code) {
        super(url + " returned an " + code);
    }

}
