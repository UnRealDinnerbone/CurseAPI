package com.unrealdinnerbone.curseapi.api.addon;

public record CategorySection(int id, int gameId, String name, int packageType, String path, String initialInclusionPattern, String extraIncludePattern, int gameCategoryId) {}
