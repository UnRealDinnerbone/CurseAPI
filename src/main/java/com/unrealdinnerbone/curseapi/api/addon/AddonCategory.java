package com.unrealdinnerbone.curseapi.api.addon;

import com.unrealdinnerbone.curseapi.api.base.ICategory;
import lombok.Getter;

@Getter
public class AddonCategory implements ICategory
{
    private int categoryId;
    private String name;
    private String url;
    private String avatarUrl;
    private int parentId;
    private int rootId;
    private int projectId;
    private int avatarId;
    private int gameId;
}
