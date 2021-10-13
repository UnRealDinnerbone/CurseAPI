package com.unrealdinnerbone.curseapi.api.file;

import com.unrealdinnerbone.curseapi.lib.json.IID;

public enum FileRelation implements IID
{
    EMBEDDED(1),
    OPTIONAL(2),
    REQUIRED(3),
    TOOL(4),
    INCOMPATIBLE(5),
    INCLUDE(6);

    private final int id;

    FileRelation(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }
}
