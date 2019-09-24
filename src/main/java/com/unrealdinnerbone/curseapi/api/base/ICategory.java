package com.unrealdinnerbone.curseapi.api.base;

public interface ICategory {
    int getCategoryId();
    String getName();
    String getUrl();
    String getAvatarUrl();
    int getParentId();
    int getRootId();
    int getProjectId();
    int getAvatarId();
    int getGameId();

}
