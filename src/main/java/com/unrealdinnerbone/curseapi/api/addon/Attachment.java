package com.unrealdinnerbone.curseapi.api.addon;

public record Attachment(int id, int projectId, String description, boolean isDefault, String thumbnailUrl,
                         String title, String url, int status) {
}
