package com.unrealdinnerbone.curseapi.api.addon;

import com.unrealdinnerbone.curseapi.api.file.ModulesItem;

import java.util.List;

public interface ICurseFile 
{
    int id();
    String displayName();
    String fileName();
    String fileDate();
    int fileLength();
    int releaseType();
    int fileStatus();
    String downloadUrl();
    boolean isAlternate();
    int alternateFileId();
    List<Dependency> dependencies();
    boolean isAvailable();
    long packageFingerprint();
    List<String> gameVersion();
    Object installMetadata();
    Object serverPackFileId();
    boolean hasInstallScript();
    String gameVersionDateReleased();
    Object gameVersionFlavor();
}
