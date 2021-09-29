package com.unrealdinnerbone.curseapi.api.addon;

public class Dependency
{
    private String id;
    private String addonId;
    private Type type;


    @SuppressWarnings("UnnecessaryEnumModifier")
    public static enum Type
    {
        EMBEDDED_LIBRARY(1),
        OPTIONAL_DEPENDENCY(2),
        REQUIRED_DEPENDENCY(3),
        TOOL(4),
        INCOMPATIBLE(5),
        INCLUDE(6);

        private final int id;
        private Type(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }
}
