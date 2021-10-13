package com.unrealdinnerbone.curseapi.api.file;

import java.util.List;
import java.util.Optional;

public record File(int id,
                   int gameId,
                   int modId,
                   boolean isAvailable,
                   String displayName,
                   String fileName,
                   FileReleaseType releaseType,
                   FileStatus fileStatus,
                   List<FileHash> hashes,
                   String fileDate,
                   long fileLength,
                   long downloadCount,
                   String downloadUrl,
                   List<String> gameVersions,
                   List<SortableGameVersion> sortableGameVersions,
                   List<FileDependency> dependencies,
                   Optional<Boolean> exposeAsAlternative,
                   Optional<Integer> parentProjectFileId,
                   Optional<Integer> alternateFileId,
                   Optional<Boolean> isServerPack,
                   Optional<Integer> serverPackFileId,
                   long fileFingerprint,
                   List<FileModule> modules) {
}
