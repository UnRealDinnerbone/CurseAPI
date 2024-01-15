package com.unrealdinnerbone.curseapi.api.minecraft;

import com.unrealdinnerbone.unreallib.json.api.IID;

public enum GameVersionStatus implements IID {
    APPROVED(1),
    DELETED(2),
    NEW(3);

    private final int id;

    GameVersionStatus(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }
}
