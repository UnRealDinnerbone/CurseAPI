package com.unrealdinnerbone.curseapi.api.mod;

import com.unrealdinnerbone.unreallib.json.api.IID;

public enum ModLoaderType implements IID
{
    ANY(0),
    FORGE(1),
    CAULDRON(2),
    LITE_LOADER(3),
    FABRIC(4),
    ;

    private final int id;

    ModLoaderType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
