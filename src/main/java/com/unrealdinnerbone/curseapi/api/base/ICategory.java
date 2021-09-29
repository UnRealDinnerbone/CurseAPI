package com.unrealdinnerbone.curseapi.api.base;

public interface ICategory {
    int categoryId();
    String name();
    String url();
    String avatarUrl();
    int parentId();
    int rootId();
    int projectId();
    int avatarId();
    int gameId();

}
