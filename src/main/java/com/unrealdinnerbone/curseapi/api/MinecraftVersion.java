package com.unrealdinnerbone.curseapi.api;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class MinecraftVersion{

	private int id;
	private int gameVersionId;
	private String versionString;
	private String jarDownloadUrl;
	private String jsonDownloadUrl;
	private boolean approved;
	private String dateModified;
	private int gameVersionTypeId;
	private int gameVersionStatus;
	private int gameVersionTypeStatus;
}