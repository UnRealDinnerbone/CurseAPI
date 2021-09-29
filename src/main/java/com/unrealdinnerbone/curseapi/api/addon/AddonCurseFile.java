package com.unrealdinnerbone.curseapi.api.addon;

import java.util.List;

public record AddonCurseFile(int id, String displayName, String fileName, String fileDate,
                             int fileLength, int releaseType, int fileStatus, String downloadUrl,
                             boolean isAlternate, int alternateFileId,
                             List<Dependency> dependencies,
                             boolean isAvailable,
                             List<Module> modules,
                             long packageFingerprint, List<String> gameVersion,
                             List<GameVersion> sortableGameVersion,
                             String installMetadata, String changelog, boolean hasInstallScript,
                             boolean isCompatibleWithClient, int categorySectionPackageType,
                             int restrictProjectFileAccess, int projectStatus, int renderCacheId,
                             String fileLegacyMappingId, int projectId, String parentProjectFileId,
                             String parentFileLegacyMappingId, String fileTypeId,
                             String exposeAsAlternative, long packageFingerprintId,
                             String gameVersionDateReleased, int gameVersionMappingId, int gameVersionId,
                             int gameId, boolean isServerPack, String serverPackFileId,
                             String gameVersionFlavor) implements ICurseFile {
}
