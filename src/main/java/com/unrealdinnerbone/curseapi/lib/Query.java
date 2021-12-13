package com.unrealdinnerbone.curseapi.lib;

import com.unrealdinnerbone.curseapi.api.SortOrder;
import com.unrealdinnerbone.curseapi.api.mod.ModLoaderType;
import com.unrealdinnerbone.curseapi.api.mod.ModsSearchSortField;

import java.util.HashMap;
import java.util.Map;

public record Query(String query) {


    public static class Builder {

        private final Map<String, String> map;

        public Builder() {
            this.map = new HashMap<>();
        }

        public Builder withQuery(String key, String value) {
            map.put(key, value);
            return this;
        }

        public Query build() {
            StringBuilder builder = new StringBuilder("?");
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builder.append(entry.getKey() + "=" + entry.getValue()).append("&");
            }
            return new Query(builder.toString().substring(0, builder.length() -1 ));
        }
    }


    public static class Mod {


        private final Query.Builder builder;

        public Mod() {
            this.builder = new Query.Builder();
        }

        public Mod gameId(int id) {
            builder.withQuery("gameId", String.valueOf(id));
            return this;
        }

        public Mod classId(int classId) {
            builder.withQuery("classId", String.valueOf(classId));
            return this;
        }

        public Mod categoryId(int classId) {
            builder.withQuery("categoryId", String.valueOf(classId));
            return this;
        }


        public Mod gameVersion(String classId) {
            builder.withQuery("gameVersion", String.valueOf(classId));
            return this;
        }


        public Mod searchFilter(String classId) {
            builder.withQuery("searchFilter", String.valueOf(classId));
            return this;
        }


        public Mod sortField(ModsSearchSortField searchSortField) {
            builder.withQuery("sortField", String.valueOf(searchSortField.getId()));
            return this;
        }


        public Mod sortOrder(SortOrder sortOrder) {
            builder.withQuery("sortOrder", sortOrder.name().toLowerCase());
            return this;
        }


        public Mod modLoaderType(ModLoaderType modLoaderType) {
            builder.withQuery("modLoaderType", String.valueOf(modLoaderType.getId()));
            return this;
        }


        public Mod gameVersionTypeId(int classId) {
            builder.withQuery("gameVersionTypeId", String.valueOf(classId));
            return this;
        }


        public Mod index(int classId) {
            builder.withQuery("index", String.valueOf(classId));
            return this;
        }


        public Mod pageSize(int classId) {
            builder.withQuery("pageSize", String.valueOf(classId));
            return this;
        }



        public Query build() {
            if(builder.map.size() > 0) {
                return builder.build();
            }else {
                throw new IllegalArgumentException("There must be atleast one query value");
            }
        }

    }


    public static class Category {


        private final Query.Builder builder;

        public Category() {
            this.builder = new Query.Builder();
        }

        public Category setGameId(int id) {
            builder.withQuery("gameId", String.valueOf(id));
            return this;
        }

        public Category withClassId(int classId) {
            builder.withQuery("classId", String.valueOf(classId));
            return this;
        }

        public Query build() {
            if(builder.map.size() > 0) {
                return builder.build();
            }else {
                throw new IllegalArgumentException("There must be atleast one query value");
            }
        }

    }
}
