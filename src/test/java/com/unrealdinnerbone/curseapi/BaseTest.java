package com.unrealdinnerbone.curseapi;

import com.squareup.moshi.JsonDataException;
import com.unrealdinnerbone.curseapi.lib.ReturnResult;
import com.unrealdinnerbone.curseapi.lib.json.JsonUtil;
import org.junit.Assert;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public abstract class BaseTest {

    protected <T> void test(CompletableFuture<ReturnResult<T>> completableFuture) throws ExecutionException, InterruptedException {

        ReturnResult<?> returnResult = completableFuture.get();

        Assert.assertNotNull(returnResult);
        Assert.assertNotNull(returnResult.getRawValue());
        Assert.assertNotNull(returnResult.get());
        Assert.assertNotNull(getReformtedJson(returnResult));
        Assert.assertNotNull(returnResult.getRawValue());

//        Assert.assertArrayEquals(getA(returnResult).keySet().stream().sorted().toArray(), getB(returnResult).keySet().stream().sorted().toArray());
        Assert.assertEquals(aFormat(returnResult), bFormat(returnResult));
    }

    public Map<String, ?> getA(ReturnResult<?> returnResult) {
        return getFor(returnResult.getRawValue());
    }

    public Map<String, ?> getB(ReturnResult<?> returnResult) {
        return getFor(getReformtedJson(returnResult));
    }

    private Map<String, ?> getFor(String s) {
        try {
            Map<String, ?> map = JsonUtil.MOSHI.adapter(Map.class).failOnUnknown().fromJson(s);
            return map;
        }catch (JsonDataException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String aFormat(ReturnResult<?> returnResult) {
        return JsonUtil.MOSHI.adapter(Object.class).indent("    ").lenient().toJson(getA(returnResult));
    }
    public String bFormat(ReturnResult<?> returnResult) {
        return JsonUtil.MOSHI.adapter(Object.class).indent("    ").lenient().toJson(getB(returnResult));
    }

    public <T> String getReformtedJson(ReturnResult<T> returnResult) {
        return JsonUtil.MOSHI.adapter(returnResult.getClazz()).indent("    ").toJson(returnResult.get());
    }

}
