package com.unrealdinnerbone.curseapi.api.body;

import com.unrealdinnerbone.curseapi.lib.json.JsonUtil;

import java.util.List;

public record FingerprintMatchesRequestBody(List<Integer> fingerprints) {
    @Override
    public String toString() {
        return JsonUtil.MOSHI.adapter(FingerprintMatchesRequestBody.class).toJson(this);
    }
}
