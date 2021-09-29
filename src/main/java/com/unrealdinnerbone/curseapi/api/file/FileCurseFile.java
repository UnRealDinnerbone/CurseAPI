package com.unrealdinnerbone.curseapi.api.file;

import java.util.List;
import com.unrealdinnerbone.curseapi.api.addon.Dependency;
import com.unrealdinnerbone.curseapi.api.addon.ICurseFile;

public record FileCurseFile(int id, String displayName, String fileName, String fileDate,
							int fileLength, int releaseType, int fileStatus, String downloadUrl,
							boolean isAlternate, int alternateFileId,
							List<Dependency> dependencies,
							boolean isAvailable,
							List<ModulesItem> modules,
							long packageFingerprint, List<String> gameVersion,
							Object installMetadata, Object serverPackFileId,
							boolean hasInstallScript, String gameVersionDateReleased,
							Object gameVersionFlavor) implements ICurseFile {

}