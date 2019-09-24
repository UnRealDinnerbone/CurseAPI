package com.unrealdinnerbone.curseapi.api.game;

import lombok.Getter;

@Getter
public class FileParsingRule
{
    private String commentStripPattern;
    private String fileExtension;
    private String inclusionPattern;
    private int gameId;
    private int id;

}
