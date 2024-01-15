package com.unrealdinnerbone.curseapi.quaries;

public interface Queries {
    static ModQuery mod() {
        return ModQuery.builder();
    }

    static CategoryQuery category() {
        return CategoryQuery.builder();
    }
}
