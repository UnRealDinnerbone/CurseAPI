package com.unrealdinnerbone.curseapi.api.mod;

import com.unrealdinnerbone.curseapi.lib.json.IID;

public enum ModLoaderType implements IID
{
    ANY(0),
    FORGE(1),
    CAULDRON(2),
    LITE_LOADER(3),
    FABRIC(4),
    UNKNOWN(-1),
    ;

    private final int id;

    ModLoaderType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
