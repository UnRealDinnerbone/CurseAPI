package com.unrealdinnerbone.curseapi.api;

import lombok.Getter;

@Getter
public class ModLoader{

	private String name;
	private String gameVersion;
	private boolean latest;
	private boolean recommended;
	private String dateModified;
}