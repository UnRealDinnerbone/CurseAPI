package com.unrealdinnerbone.curseapi.lib;

import com.google.gson.*;
import lombok.Getter;

import java.lang.reflect.Type;
import java.math.BigDecimal;

public class JsonUtil
{
    @Getter private static final Gson basicGson = new GsonBuilder().disableHtmlEscaping()
                .setPrettyPrinting()
                .serializeNulls()
                .create();

}
