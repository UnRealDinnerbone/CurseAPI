package com.unrealdinnerbone.curseapi.api.addon;


import com.unrealdinnerbone.curseapi.api.base.ICategory;

public record AddonCategory(int categoryId, String name, String url, String avatarUrl, int parentId, int rootId, int projectId, int avatarId, int gameId) implements ICategory {
}
