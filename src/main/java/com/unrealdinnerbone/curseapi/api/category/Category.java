package com.unrealdinnerbone.curseapi.api.category;

public record Category(int id,
                       int gameId,
                       String name,
                       String slug,
                       String url,
                       String iconUrl,
                       String dateModified,
                       Boolean isClass,
                       Integer classId,
                       Integer parentCategoryId) {
}
