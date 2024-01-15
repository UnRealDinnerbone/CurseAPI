package com.unrealdinnerbone.curseapi.api.mod;

import com.unrealdinnerbone.unreallib.json.api.IID;

public enum ModStatus implements IID
{
    NEW(1),
    CHANGES_REQUIRED(2),
    UNDER_SOFT_REVIEW(3),
    APPROVED(4),
    REJECTED(5),
    CHANGES_MADE(6),
    INACTIVE(7),
    ABANDONED(8),
    DELETED(9),
    UNDER_REVIEW(10),
    ;

    private final int id;

    ModStatus(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }
}
