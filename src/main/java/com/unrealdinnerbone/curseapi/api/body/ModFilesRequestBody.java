package com.unrealdinnerbone.curseapi.api.body;

import com.unrealdinnerbone.curseapi.lib.ReturnResult;

import java.util.List;

public record ModFilesRequestBody(List<Integer> fileIds) {
    @Override
    public String toString() {
        return ReturnResult.MOSHI.adapter(ModFilesRequestBody.class).toJson(this);
    }
}
