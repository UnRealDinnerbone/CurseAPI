package com.unrealdinnerbone.curseapi.api.body;

import com.unrealdinnerbone.curseapi.lib.ReturnResult;

import java.util.List;

public record FingerprintMatchesRequestBody(List<Integer> fingerprints) {
    @Override
    public String toString() {
        return ReturnResult.MOSHI.adapter(FingerprintMatchesRequestBody.class).toJson(this);
    }
}
