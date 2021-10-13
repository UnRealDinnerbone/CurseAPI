package com.unrealdinnerbone.curseapi.api.file;

import com.unrealdinnerbone.curseapi.lib.json.IID;

public enum HashAlgo implements IID
{
    MD5(1),
    SHA1(2);

    private final int id;

    HashAlgo(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }
}
