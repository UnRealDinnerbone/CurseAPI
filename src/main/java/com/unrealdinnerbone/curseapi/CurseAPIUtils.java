package com.unrealdinnerbone.curseapi;

import com.unrealdinnerbone.curseapi.lib.ReturnResult;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;


public class CurseAPIUtils
{

    private static final HttpClient CLIENT = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();

    private static final String API_URL = System.getenv().getOrDefault("API_URL", "https://api.curseforge.com/");

    public static String getURL(String dataURL) {
        return API_URL + dataURL;
    }


    public static <T> CompletableFuture<ReturnResult<T>> post(Class<T> tClass, String urlData, String map, String apiKey) {
        String url = getURL(urlData);
        HttpRequest request = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(map))
                .setHeader("Content-Type", "application/json")
                .setHeader("Accept", "application/json")
                .setHeader("x-api-key", apiKey)
                .uri(URI.create(url))
                .build();

      return handle(request, tClass, url);
    }

    public static <T> CompletableFuture<ReturnResult<T>> handle(HttpRequest request, Class<T> tClass, String url) {
        CompletableFuture<ReturnResult<T>> future = new CompletableFuture<>();

        CLIENT.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .whenComplete((stringHttpResponse, throwable) -> {
                    if(throwable != null) {
                        future.completeExceptionally(throwable);
                    }else {
                        if(stringHttpResponse.statusCode() == 200) {
                            future.complete(new ReturnResult<>(stringHttpResponse.body(), tClass));
                        }else {
                            future.completeExceptionally(new WebResultException(url, stringHttpResponse.statusCode()));
                        }
                    }
                });
        return future;
    }


    public static <T> CompletableFuture<ReturnResult<T>> get(Class<T> tClass, String urlData, String apiKey) {
        String url = getURL(urlData);
        HttpRequest request = HttpRequest.newBuilder().GET()
                .setHeader("Accept", "application/json")
                .setHeader("x-api-key", apiKey)
                .uri(URI.create(url))
                .build();


        return handle(request, tClass, url);
    }

//    public static String encode(String toencode) {
//        try {
//            return URLEncoder.encode(toencode, StandardCharsets.UTF_8.name());
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }


//    public static long formatTime(String time) {
//        String fixedTime = time.replace("T", " ").replace("Z", "");
//        for (DateFormat curseDateFormat : curseDateFormats) {
//            try {
//                return curseDateFormat.parse(fixedTime).getTime();
//            }catch (Exception e) {
//
//            }
//        }
//        return 0;
//    }

}
