package com.unrealdinnerbone.curseapi.api;

import lombok.Getter;

@Getter
public class Catergory
{
    private int id;
    private String name;
    private String slug;
    private String avatarUrl;
    private String dateModified;
    private Integer parentGameCategoryId;
    private Integer rootGameCategoryId;
    private int gameId;
}
