package com.unrealdinnerbone.curseapi.api.body;

import com.unrealdinnerbone.curseapi.lib.ReturnResult;

import java.util.List;

public record ModsByIdsListRequestBody(List<Integer> modIds) {
    @Override
    public String toString() {
        return ReturnResult.MOSHI.adapter(ModsByIdsListRequestBody.class).toJson(this);
    }
}
