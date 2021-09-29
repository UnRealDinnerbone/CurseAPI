package com.unrealdinnerbone.curseapi;

import com.unrealdinnerbone.curseapi.lib.ReturnResult;
import com.unrealdinnerbone.unreallib.web.HttpUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class CurseAPIUtils
{
    private static final DateFormat[] curseDateFormats;

    static {
        curseDateFormats = new DateFormat[] {
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")};
    }

    public static String post(String dataURL, String dataMap) {
        try {
            return postIt(getURL(dataURL), dataMap).body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getURL(String dataURL) {
        return "https://addons-ecs.forgesvc.net/api/v2/" + dataURL;
    }


    private static final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();

    public static HttpResponse<String> postIt(String url, String map) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(map))
                .uri(URI.create(url))
                .setHeader("User-Agent", "Java") // add request header
                .header("Content-Type", "application/json")
                .build();
        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public static <T> ReturnResult<T> get(Class<T> tClass, String urlData) {
        String theUrlData = null;
        try {
            theUrlData = HttpUtils.get(getURL(urlData)).body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return theUrlData != null ? new ReturnResult<>(theUrlData, tClass) : null;
    }

    public static String encode(String toencode) {
        try {
            return URLEncoder.encode(toencode, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static long formatTime(String time) {
        String fixedTime = time.replace("T", " ").replace("Z", "");
        for (DateFormat curseDateFormat : curseDateFormats) {
            try {
                return curseDateFormat.parse(time).getTime();
            }catch (Exception e) {

            }
        }
        System.out.println("CAke");
        return 0;
    }

}
