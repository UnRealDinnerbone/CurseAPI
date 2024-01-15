package com.unrealdinnerbone.curseapi;

import com.unrealdinnerbone.curseapi.lib.json.JsonUtil;
import com.unrealdinnerbone.unreallib.apiutils.APIUtils;
import com.unrealdinnerbone.unreallib.apiutils.result.IResult;
import com.unrealdinnerbone.unreallib.apiutils.result.JsonResult;
import com.unrealdinnerbone.unreallib.web.ContentType;
import com.unrealdinnerbone.unreallib.web.HttpHelper;


public class CurseAPIUtils {
    private static final String USER_AGENT = System.getenv().getOrDefault("USER_AGENT", "Java-CurseAPI/v1");

    public static <T> IResult<T> post(Class<T> tClass, String urlData, String map, String apiKey) {
        return APIUtils.postResult(HttpHelper.DEFAULT, urlData, map, ContentType.JSON, builder -> builder
                .setHeader("User-Agent", USER_AGENT)
                .setHeader("Accept", ContentType.JSON.getType())
                .setHeader("x-api-key", apiKey))
                .mapSelf(httpResponseIResult -> new JsonResult<>(httpResponseIResult, tClass, JsonUtil.PARSER));
    }

    public static <T> IResult<T> get(Class<T> tClass, String urlData, String apiKey) {
        return APIUtils.getResult(HttpHelper.DEFAULT, urlData, builder -> builder
                .setHeader("User-Agent", USER_AGENT)
                .setHeader("x-api-key", apiKey))
                .mapSelf(httpResponseIResult -> new JsonResult<>(httpResponseIResult, tClass, JsonUtil.PARSER));
    }

}
