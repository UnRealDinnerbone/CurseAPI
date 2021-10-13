package com.unrealdinnerbone.curseapi.api.body;

import com.unrealdinnerbone.curseapi.lib.ReturnResult;

import java.util.List;
import java.util.Optional;

public record FeaturedModsRequestBody(int gameId, List<Integer> excludedModIds, Optional<Integer> gameVersionTypeId) {
    @Override
    public String toString() {
        return ReturnResult.MOSHI.adapter(FeaturedModsRequestBody.class).toJson(this);
    }
}
