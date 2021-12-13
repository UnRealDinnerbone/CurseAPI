package com.unrealdinnerbone.curseapi.lib;

public class EnvUtil {

    public static int getInt(String key, int defaultValue) {
        return Integer.parseInt(System.getenv().getOrDefault(key, String.valueOf(defaultValue)));
    }

    public static String getString(String key, String defaultValue) {
        return System.getenv().getOrDefault(key, String.valueOf(defaultValue));
    }
}
