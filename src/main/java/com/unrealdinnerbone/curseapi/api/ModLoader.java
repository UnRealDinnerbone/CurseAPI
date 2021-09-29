package com.unrealdinnerbone.curseapi.api;

public record ModLoader(String name, String gameVersion, boolean latest, boolean recommended,
						String dateModified) {

}