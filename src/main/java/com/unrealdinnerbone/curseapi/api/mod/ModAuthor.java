package com.unrealdinnerbone.curseapi.api.mod;

public record ModAuthor(int id, String name, String url) {

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ModAuthor author && author.name().equals(name());
    }
}
