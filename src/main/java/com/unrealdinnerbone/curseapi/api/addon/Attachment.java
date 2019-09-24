package com.unrealdinnerbone.curseapi.api.addon;

import lombok.Getter;

@Getter
public class Attachment
{
    private int id;
    private int projectId;
    private String description;
    private boolean isDefault;
    private String thumbnailUrl;
    private String title;
    private String url;
    private int status;

}
