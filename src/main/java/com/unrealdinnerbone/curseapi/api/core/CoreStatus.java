package com.unrealdinnerbone.curseapi.api.core;

import com.unrealdinnerbone.unreallib.json.api.IID;

public enum CoreStatus implements IID
{
    DRAFT(1),
    TEST(2),
    PENDING_REVIEW(3),
    REJECTED(4),
    APPROVED(5),
    LIVE(6),
    ;

    private final int id;

    CoreStatus(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }
}
