package com.unrealdinnerbone.curseapi.api.body;

import com.unrealdinnerbone.curseapi.lib.json.JsonUtil;

import java.util.List;
import java.util.Optional;

public record FeaturedModsRequestBody(int gameId, List<Integer> excludedModIds, Optional<Integer> gameVersionTypeId) {
    @Override
    public String toString() {
        return JsonUtil.MOSHI.adapter(FeaturedModsRequestBody.class).toJson(this);
    }
}
