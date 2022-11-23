package com.unrealdinnerbone.curseapi.api.file;


import com.unrealdinnerbone.curseapi.api.mod.ModLoaderType;

import java.util.Optional;
//, ModLoaderType modLoaderType
public record FileIndex(String gameVersion, int fileId, String filename, FileReleaseType releaseType, Integer gameVersionTypeId) {
}
