package com.unrealdinnerbone.curseapi;

import com.unrealdinnerbone.curseapi.lib.ReturnResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;


public class CurseAPIUtils
{
    private static final Logger LOGGER = LoggerFactory.getLogger("CurseAPI");


    private static final HttpClient CLIENT = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();

    private static final String USER_AGENT = System.getenv().getOrDefault("USER_AGENT", "Java-CurseAPI/v1");
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
                .setHeader("User-Agent", USER_AGENT)
                .uri(URI.create(url))
                .build();

      return handle(request, tClass, url);
    }

    public static <T> CompletableFuture<ReturnResult<T>> handle(HttpRequest request, Class<T> tClass, String url) {
        return CLIENT
                .sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .handle((response, error) -> {
                    try {
                        if(error == null && response.statusCode() == 200) {
                            return new ReturnResult<>(response.body(), tClass);
                        }else {
                            LOGGER.error("Error while sending request to {}", url);
                            return ReturnResult.createException(Objects.requireNonNullElseGet(error, () -> new WebResultException(url, response.body(), response.statusCode())));
                        }
                    }catch(Exception e) {
                        LOGGER.error("Error while sending request to {}", url);
                        return ReturnResult.createException(e);
                    }

                });
    }

    public java.lang.String getFormattedURL(String url) {
        return URLEncoder.encode(url, StandardCharsets.UTF_8);
    }


    public static <T> CompletableFuture<ReturnResult<T>> get(Class<T> tClass, String urlData, String apiKey) {
        String url = getURL(urlData);
        HttpRequest request = HttpRequest.newBuilder().GET()
                .setHeader("Accept", "application/json")
                .setHeader("User-Agent", USER_AGENT)
//                .setHeader("x-api-key", apiKey)
                .uri(URI.create(url))
                .build();


        return handle(request, tClass, url);
    }

}
