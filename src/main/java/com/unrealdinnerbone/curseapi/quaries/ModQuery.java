package com.unrealdinnerbone.curseapi.quaries;

import com.unrealdinnerbone.curseapi.api.SortOrder;
import com.unrealdinnerbone.curseapi.api.mod.ModLoaderType;
import com.unrealdinnerbone.curseapi.api.mod.ModsSearchSortField;
import com.unrealdinnerbone.unreallib.apiutils.Query;

public class ModQuery {

    private final Query.Builder builder;

    public static ModQuery builder() {
        return new ModQuery();
    }

    private ModQuery() {
        this.builder = new Query.Builder();
    }

    public ModQuery gameId(int id) {
        builder.withQuery("gameId", String.valueOf(id));
        return this;
    }

    public ModQuery classId(int classId) {
        builder.withQuery("classId", String.valueOf(classId));
        return this;
    }

    public ModQuery categoryId(int classId) {
        builder.withQuery("categoryId", String.valueOf(classId));
        return this;
    }


    public ModQuery gameVersion(String classId) {
        builder.withQuery("gameVersion", String.valueOf(classId));
        return this;
    }


    public ModQuery searchFilter(String classId) {
        builder.withQuery("searchFilter", String.valueOf(classId));
        return this;
    }


    public ModQuery sortField(ModsSearchSortField searchSortField) {
        builder.withQuery("sortField", String.valueOf(searchSortField.getId()));
        return this;
    }


    public ModQuery sortOrder(SortOrder sortOrder) {
        builder.withQuery("sortOrder", sortOrder.name().toLowerCase());
        return this;
    }


    public ModQuery modLoaderType(ModLoaderType modLoaderType) {
        builder.withQuery("modLoaderType", String.valueOf(modLoaderType.getId()));
        return this;
    }


    public ModQuery gameVersionTypeId(int classId) {
        builder.withQuery("gameVersionTypeId", String.valueOf(classId));
        return this;
    }


    public ModQuery index(int classId) {
        builder.withQuery("index", String.valueOf(classId));
        return this;
    }


    public ModQuery pageSize(int classId) {
        builder.withQuery("pageSize", String.valueOf(classId));
        return this;
    }

    public ModQuery slug(String slug) {
        builder.withQuery("slug", slug);
        return this;
    }



    public Query build() {
        return builder.build(1);
    }

}