package com.unrealdinnerbone.curseapi.api.game;

public record CategorySectionsItem(int id, int gameId, String name, int packageType, String path,
								   String initialInclusionPattern, String extraIncludePattern,
								   int gameCategoryId) {

}