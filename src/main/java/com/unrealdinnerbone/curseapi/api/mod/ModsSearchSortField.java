package com.unrealdinnerbone.curseapi.api.mod;

import com.unrealdinnerbone.curseapi.lib.json.IID;

public enum ModsSearchSortField implements IID
{
    FEATURED(1),
    POPULARITY(2),
    LAST_UPDATED(3),
    NAME(4),
    AUTHOR(5),
    TOTAL_DOWNLOADS(6),
    CATEGORY(7),
    GAME_VERSION(8);

    private final int id;

    ModsSearchSortField(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
