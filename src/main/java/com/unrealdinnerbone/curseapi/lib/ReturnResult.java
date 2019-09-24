package com.unrealdinnerbone.curseapi.lib;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ReturnResult<T>
{
    private final static JsonParser PARSER = new JsonParser();
    private final String value;
    private Class<T> tClass;

    public ReturnResult(String value, Class<T> tClass) {
        this.value = value;
        this.tClass = tClass;
    }

    public String getRawValue() {
        return value;
    }

    public T get() {
        return JsonUtil.getBasicGson().fromJson(value, tClass);
    }

    public String getReformtedJson() {
        return JsonUtil.getBasicGson().toJson(get());
    }

    public String getFormattedJson() {
        JsonElement jsonElement = PARSER.parse(value);
        JsonElement theRealJson = null;
        if(jsonElement.isJsonArray()) {
            theRealJson = jsonElement.getAsJsonArray();
        }else if (jsonElement.isJsonObject()) {
            theRealJson = jsonElement.getAsJsonObject();
        }
        return JsonUtil.getBasicGson().toJson(theRealJson);
    }
}
