package com.unrealdinnerbone.curseapi.api.file;

import com.unrealdinnerbone.curseapi.lib.json.IID;

public enum FileReleaseType implements IID
{
    RELEASE(1),
    BETA(2),
    ALPHA(3),
    UNKNOWN(-1),
    ;

    private final int id;

    FileReleaseType(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }
}
