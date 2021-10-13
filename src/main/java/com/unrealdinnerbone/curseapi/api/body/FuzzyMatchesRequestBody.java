package com.unrealdinnerbone.curseapi.api.body;

import com.unrealdinnerbone.curseapi.api.fingerprint.FolderFingerprint;
import com.unrealdinnerbone.curseapi.lib.ReturnResult;

import java.util.List;

public record FuzzyMatchesRequestBody(int gameId, List<FolderFingerprint> fingerprints) {
    @Override
    public String toString() {
        return ReturnResult.MOSHI.adapter(FuzzyMatchesRequestBody.class).toJson(this);
    }
}
