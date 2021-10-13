package com.unrealdinnerbone.curseapi.lib;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonDataException;
import com.unrealdinnerbone.curseapi.lib.json.JsonUtil;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class ReturnResult<T> {

    private final String value;
    private final Class<T> tClass;
    private T t;

    public ReturnResult(String value, Class<T> tClass) {
        this.value = value;
        this.tClass = tClass;
    }

    public String getRawValue() {
        return value;
    }

    @Nullable
    public T get() {
        if (t == null) {
            try {
                t = getExceptionally();
            } catch (JsonDataException | IOException e) {
                return null;
            }
        }
        return t;
    }


    public T getExceptionally() throws JsonDataException, IOException {
        if (t == null) {
            t = parse(value, tClass);
        }
        return t;
    }

    public Class<T> getClazz() {
        return tClass;
    }

    public static <T> T parse(String string, Class<T> tClass) throws JsonDataException, IOException {
        return JsonUtil.MOSHI.adapter(tClass).fromJson(string);
    }


}