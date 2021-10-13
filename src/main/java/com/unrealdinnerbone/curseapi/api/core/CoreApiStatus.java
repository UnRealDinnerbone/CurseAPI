package com.unrealdinnerbone.curseapi.api.core;

import com.unrealdinnerbone.curseapi.lib.json.IID;

public enum CoreApiStatus implements IID
{
    PRIVATE(1),
    PUBLIC(2);

    private final int id;

    CoreApiStatus(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }
}
