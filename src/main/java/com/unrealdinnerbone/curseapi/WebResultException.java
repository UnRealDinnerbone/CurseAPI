package com.unrealdinnerbone.curseapi;

import com.unrealdinnerbone.unreallib.StringUtils;

public class WebResultException extends Exception {

    public WebResultException(String url, int code) {
        super(StringUtils.replace("{0} returned an {1}", url, code));
    }

}
