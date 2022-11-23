package com.unrealdinnerbone.curseapi.api.file;

import com.unrealdinnerbone.curseapi.lib.json.IID;

public enum FileStatus implements IID
{
    PROCESSING(1),
    CHANGES_REQUIRED(2),
    UNDER_REVIEW(3),
    APPROVED(4),
    REJECTED(5),
    MALWARE_DETECTED(6),
    DELETED(7),
    ARCHIVED(8),
    TESTING(9),
    RELEASED(10),
    READY_FOR_REVIEW(11),
    DEPRECATED(12),
    BAKING(13),
    AWAITING_PUBLISHING(14),
    FAILED_PUBLISHING(15),
    UNKNOWN(-1),
    ;

    private final int id;

    FileStatus(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }
}
