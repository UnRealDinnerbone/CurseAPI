package com.unrealdinnerbone.curseapi.api.body;

import com.unrealdinnerbone.curseapi.lib.json.JsonUtil;

import java.util.List;

public record ModsByIdsListRequestBody(List<Integer> modIds) {
    @Override
    public String toString() {
        return JsonUtil.MOSHI.adapter(ModsByIdsListRequestBody.class).toJson(this);
    }
}
