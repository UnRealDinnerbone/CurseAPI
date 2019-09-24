package com.unrealdinnerbone.curseapi.api.addon;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Dependency
{
    private String id;
    private String addonId;
    private Type type;


    @SuppressWarnings("UnnecessaryEnumModifier")
    @AllArgsConstructor
    @Getter
    public static enum Type
    {
        EMBEDDED_LIBRARY(1),
        OPTIONAL_DEPENDENCY(2),
        REQUIRED_DEPENDENCY(3),
        TOOL(4),
        INCOMPATIBLE(5),
        INCLUDE(6);

        private int id;


    }
}
