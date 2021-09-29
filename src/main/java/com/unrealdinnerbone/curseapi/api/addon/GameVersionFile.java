package com.unrealdinnerbone.curseapi.api.addon;

public record GameVersionFile(String gameVersion, int projectFileId, String projectFileName,
                              int fileType, String gameVersionFlavor) {
}
