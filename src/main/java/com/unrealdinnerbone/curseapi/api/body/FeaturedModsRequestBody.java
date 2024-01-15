package com.unrealdinnerbone.curseapi.api.body;

import java.util.List;

public record FeaturedModsRequestBody(int gameId, List<Integer> excludedModIds, Integer gameVersionTypeId) {

}
