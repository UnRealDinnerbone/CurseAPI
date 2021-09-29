package com.unrealdinnerbone.curseapi.api;

public record MinecraftVersion(int id, int gameVersionId, String versionString,
							   String jarDownloadUrl, String jsonDownloadUrl, boolean approved,
							   String dateModified, int gameVersionTypeId, int gameVersionStatus,
							   int gameVersionTypeStatus) {

}