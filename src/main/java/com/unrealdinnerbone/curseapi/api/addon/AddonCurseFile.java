package com.unrealdinnerbone.curseapi.api.addon;

import lombok.Getter;

import java.util.List;

@Getter
public class AddonCurseFile implements ICurseFile
{
    private int id;
    private String displayName;
    private String fileName;
    private String fileDate;
    private int fileLength;
    private int releaseType;
    private int fileStatus;
    private String downloadUrl;
    private boolean isAlternate;
    private int alternateFileId;
    //Todo check this one
    private List<Dependency> dependencies;
    private boolean isAvailable;
    private List<Module> modules;
    private long packageFingerprint;
    private List<String> gameVersion;
    private List<GameVersion> sortableGameVersion;
    //Todo check all these
    private String installMetadata;
    private String changelog;
    private boolean hasInstallScript;
    private boolean isCompatibleWithClient;
    private int categorySectionPackageType;
    private int restrictProjectFileAccess;
    private int projectStatus;
    private int renderCacheId;
    private String fileLegacyMappingId;
    private int projectId;
    private String parentProjectFileId;
    private String parentFileLegacyMappingId;
    private String fileTypeId;
    private String exposeAsAlternative;
    private long packageFingerprintId;
    private String gameVersionDateReleased;
    private int gameVersionMappingId;
    private int gameVersionId;
    private int gameId;
    private boolean isServerPack;
    private String serverPackFileId;
    private String gameVersionFlavor;

}
