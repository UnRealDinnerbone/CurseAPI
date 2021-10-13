package com.unrealdinnerbone.curseapi.api.file;


import com.unrealdinnerbone.curseapi.api.mod.ModLoaderType;

import java.util.Optional;

public record FileIndex(String gameVersion, int fileId, String filename, FileReleaseType releaseType, Optional<Integer> gameVersionTypeId, Optional<ModLoaderType> modLoaderType) {
}
