package com.unrealdinnerbone.curseapi.api.file;

import com.unrealdinnerbone.curseapi.api.mod.Mod;

import java.util.List;

//https://docs.curseforge.com/?shell#tocS_FeaturedModsResponse
public record FeaturedModsResponse(List<Mod> featured,
                                   List<Mod> popular,
                                   List<Mod> recentlyUpdated) {
}
