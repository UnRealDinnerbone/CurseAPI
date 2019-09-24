package com.unrealdinnerbone.curseapi.api.file;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.unrealdinnerbone.curseapi.api.addon.Dependency;

public class FileCurseFile{

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
	private List<Dependency> dependencies;
	private boolean isAvailable;
	private List<ModulesItem> modules;
	private long packageFingerprint;
	private List<String> gameVersion;
	private Object installMetadata;
	private Object serverPackFileId;
	private boolean hasInstallScript;
	private String gameVersionDateReleased;
	private Object gameVersionFlavor;
}