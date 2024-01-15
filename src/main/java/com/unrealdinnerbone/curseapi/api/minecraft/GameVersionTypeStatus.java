package com.unrealdinnerbone.curseapi.api.minecraft;

import com.unrealdinnerbone.unreallib.json.api.IID;

public enum GameVersionTypeStatus implements IID {
    NORMAL(1),
    DELETED(2);

    private final int id;

    GameVersionTypeStatus(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }
}
