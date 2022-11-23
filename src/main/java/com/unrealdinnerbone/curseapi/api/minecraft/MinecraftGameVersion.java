package com.unrealdinnerbone.curseapi.api.minecraft;

public record MinecraftGameVersion(int id,
                                   int gameVersionId,
                                   String versionString,
                                   String jarDownloadUrl,
                                   String jsonDownloadUrl,
                                   String approved,
                                   String dateModified,
                                   int gameVersionTypeId,
                                   GameVersionStatus gameVersionStatus,
                                   GameVersionTypeStatus gameVersionTypeStatus) {}
