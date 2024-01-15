package com.unrealdinnerbone.curseapi.quaries;

import com.unrealdinnerbone.unreallib.apiutils.Query;

public class CategoryQuery {
    private final Query.Builder builder;

    public static CategoryQuery builder() {
        return new CategoryQuery();
    }

    private CategoryQuery() {
        this.builder = new Query.Builder();
    }

    public CategoryQuery setGameId(int id) {
        builder.withQuery("gameId", String.valueOf(id));
        return this;
    }

    public CategoryQuery withClassId(int classId) {
        builder.withQuery("classId", String.valueOf(classId));
        return this;
    }

    public Query build() {
        return builder.build(1);
    }

}
