package com.unrealdinnerbone.curseapi;

import com.unrealdinnerbone.curseapi.lib.ReturnResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;


public class CurseAPIUtils
{

    private static final Logger LOGGER = LoggerFactory.getLogger("CurseAPI");

    private static final HttpClient CLIENT = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();

    private static final String API_URL = System.getenv().getOrDefault("API_URL", "https://api.curseforge.com/");

    public static String getURL(String dataURL) {
        return API_URL + dataURL;
    }

    public static <T> CompletableFuture<ReturnResult<T>> post(Class<T> tClass, String urlData, String map, String apiKey) {
        String url = getURL(urlData);
        LOGGER.debug("Sending post to {}", url);
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
        LOGGER.debug("Sending get to {}", url);
        HttpRequest request = HttpRequest.newBuilder().GET()
                .setHeader("Accept", "application/json")
                .setHeader("x-api-key", apiKey)
                .uri(URI.create(url))
                .build();


        return handle(request, tClass, url);
    }

}
