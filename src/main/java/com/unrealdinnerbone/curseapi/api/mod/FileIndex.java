package com.unrealdinnerbone.curseapi.api.mod;

import com.unrealdinnerbone.curseapi.api.file.FileReleaseType;

import java.util.Optional;

public record FileIndex(String gameVersion, int fileId, String filename, FileReleaseType releaseType, Optional<Integer> gameVersionTypeId, Optional<ModLoaderType> modLoader) {
}
