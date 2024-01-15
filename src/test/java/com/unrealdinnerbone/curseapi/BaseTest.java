//package com.unrealdinnerbone.curseapi;
//
//import com.unrealdinnerbone.curseapi.api.IResponse;
//import com.unrealdinnerbone.curseapi.lib.ReturnResult;
//import com.unrealdinnerbone.curseapi.lib.json.JsonUtil;
//import org.junit.jupiter.api.Assertions;
//
//import java.io.IOException;
//import java.util.Map;
//import java.util.concurrent.ExecutionException;
//
//public abstract class BaseTest {
//
//    protected <T extends IResponse<?>> T test(IResponse<T> completableFuture) throws ExecutionException, InterruptedException, IOException {
//        T returnResult = completableFuture.data();
//        Assertions.assertNotNull(returnResult);
////        Assertions.assertNotNull(returnResult.getRawValue());
////        Assertions.assertNotNull(returnResult.get());
////        Assertions.assertNotNull(returnResult.get().data());
////        Assertions.assertNotNull(getReformtedJson(returnResult));
////        Assertions.assertNotNull(returnResult.getRawValue());
////        Assertions.assertEquals(aFormat(returnResult), bFormat(returnResult));
//        return returnResult;
//    }
//
//    public Map<String, ?> getA(ReturnResult<?> returnResult) throws IOException {
//        return getFor(returnResult.getRawValue());
//    }
//
//    public Map<String, ?> getB(ReturnResult<?> returnResult) throws IOException {
//        return getFor(getReformtedJson(returnResult));
//    }
//
//    private Map<String, ?> getFor(String s) throws IOException {
//        return JsonUtil.MOSHI.adapter(Map.class).failOnUnknown().fromJson(s);
//    }
//
//    public String aFormat(ReturnResult<?> returnResult) throws IOException {
//        return JsonUtil.MOSHI.adapter(Object.class).indent("    ").lenient().toJson(getA(returnResult));
//    }
//    public String bFormat(ReturnResult<?> returnResult) throws IOException {
//        return JsonUtil.MOSHI.adapter(Object.class).indent("    ").lenient().toJson(getB(returnResult));
//    }
//
//    public <T> String getReformtedJson(ReturnResult<T> returnResult) {
//        return JsonUtil.MOSHI.adapter(returnResult.getClazz()).indent("    ").toJson(returnResult.get());
//    }
//
//}
