package com.unrealdinnerbone.curseapi.api.body;

import com.unrealdinnerbone.curseapi.api.fingerprint.FolderFingerprint;
import com.unrealdinnerbone.curseapi.lib.json.JsonUtil;

import java.util.List;

public record FuzzyMatchesRequestBody(int gameId, List<FolderFingerprint> fingerprints) {
    @Override
    public String toString() {
        return JsonUtil.MOSHI.adapter(FuzzyMatchesRequestBody.class).toJson(this);
    }
}
