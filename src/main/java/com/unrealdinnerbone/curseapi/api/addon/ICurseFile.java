package com.unrealdinnerbone.curseapi.api.addon;

import com.unrealdinnerbone.curseapi.api.file.ModulesItem;

import java.util.List;

public interface ICurseFile 
{
    int getId();
    String getDisplayName();
    String getFileName();
    String getFileDate();
    int getFileLength();
    int getReleaseType();
    int getFileStatus();
    String getDownloadUrl();
    boolean isAlternate();
    int getAlternateFileId();
    List<Dependency> getDependencies();
    boolean isAvailable();
    long getPackageFingerprint();
    List<String> getGameVersion();
    Object getInstallMetadata();
    Object getServerPackFileId();
    boolean isHasInstallScript();
    String getGameVersionDateReleased();
    Object getGameVersionFlavor();
}
