package com.unrealdinnerbone.curseapi;

import com.unrealdinnerbone.curseapi.api.IResponse;
import com.unrealdinnerbone.curseapi.lib.ReturnResult;
import com.unrealdinnerbone.curseapi.lib.json.JsonUtil;
import org.junit.Assert;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public abstract class BaseTest {

    protected <T extends IResponse<?>> T test(CompletableFuture<ReturnResult<T>> completableFuture) throws ExecutionException, InterruptedException, IOException {

        ReturnResult<T> returnResult = completableFuture.get();

        Assert.assertNotNull(returnResult);
        Assert.assertNotNull(returnResult.getRawValue());
        Assert.assertNotNull(returnResult.get());
        Assert.assertNotNull(returnResult.get().data());
        Assert.assertNotNull(getReformtedJson(returnResult));
        Assert.assertNotNull(returnResult.getRawValue());
        Assert.assertEquals(aFormat(returnResult), bFormat(returnResult));
        return returnResult.get();
    }

    public Map<String, ?> getA(ReturnResult<?> returnResult) throws IOException {
        return getFor(returnResult.getRawValue());
    }

    public Map<String, ?> getB(ReturnResult<?> returnResult) throws IOException {
        return getFor(getReformtedJson(returnResult));
    }

    private Map<String, ?> getFor(String s) throws IOException {
        return JsonUtil.MOSHI.adapter(Map.class).failOnUnknown().fromJson(s);
    }

    public String aFormat(ReturnResult<?> returnResult) throws IOException {
        return JsonUtil.MOSHI.adapter(Object.class).indent("    ").lenient().toJson(getA(returnResult));
    }
    public String bFormat(ReturnResult<?> returnResult) throws IOException {
        return JsonUtil.MOSHI.adapter(Object.class).indent("    ").lenient().toJson(getB(returnResult));
    }

    public <T> String getReformtedJson(ReturnResult<T> returnResult) {
        return JsonUtil.MOSHI.adapter(returnResult.getClazz()).indent("    ").toJson(returnResult.get());
    }

}
