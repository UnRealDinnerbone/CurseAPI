package com.unrealdinnerbone.curseapi.api.body;

import com.unrealdinnerbone.curseapi.lib.json.JsonUtil;

import java.util.List;

public record ModFilesRequestBody(List<Integer> fileIds) {
    @Override
    public String toString() {
        return JsonUtil.MOSHI.adapter(ModFilesRequestBody.class).toJson(this);
    }
}
