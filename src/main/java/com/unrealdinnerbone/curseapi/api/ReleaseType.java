package com.unrealdinnerbone.curseapi.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum ReleaseType {
    RELEASE(1),
    BETA(2),
    ALPHA(3);

    private final int id;

    private static final ReleaseType[] TYPES = ReleaseType.values();

    public static ReleaseType fromId(int id) {
        return Arrays.stream(TYPES).filter(type -> type.getId() == id).findFirst().orElse(null);
    }
}
