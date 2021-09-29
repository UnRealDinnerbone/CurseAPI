package com.unrealdinnerbone.curseapi.api;

public record Catergory(int id, String name, String slug, String avatarUrl,
                        String dateModified, Integer parentGameCategoryId,
                        Integer rootGameCategoryId, int gameId) {
}
