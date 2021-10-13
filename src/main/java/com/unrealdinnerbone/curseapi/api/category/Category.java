package com.unrealdinnerbone.curseapi.api.category;

import java.util.Optional;

public record Category(int id,
                       int gameId,
                       String name,
                       String slug,
                       String url,
                       String iconUrl,
                       String dateModified,
                       Optional<Boolean> isClass,
                       Optional<Integer> classId,
                       Optional<Integer> parentCategoryId) {
}
