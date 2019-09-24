package com.unrealdinnerbone.curseapi;

import com.unrealdinnerbone.unreallib.time.TimeUtil;
import com.unrealdinnerbone.unreallib.web.HttpUtils;
import lombok.extern.slf4j.Slf4j;


import java.text.DateFormat;
import java.text.SimpleDateFormat;


@Slf4j
public class CurseAPIUtils
{
    private static final DateFormat[] curseDateFormats;

    static {
        curseDateFormats = new DateFormat[] {
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")};
    }

    public static String get(String dataURL)  {
        String url = getURL(dataURL);
        log.debug("Sending \"get\" to " + url);
        return HttpUtils.get(url);
    }

    public static String post(String dataURL, Object dataMap)  {
        return HttpUtils.post(getURL(dataURL), dataMap, null);
    }

    public static String getURL(String dataURL) {
        return "https://addons-ecs.forgesvc.net/api/v2/" + dataURL;
    }

    public synchronized static long formatTime(String time) {
        String fixedTime = time.replace("T", " ");
        return TimeUtil.formatTime(fixedTime, curseDateFormats);
    }

}
