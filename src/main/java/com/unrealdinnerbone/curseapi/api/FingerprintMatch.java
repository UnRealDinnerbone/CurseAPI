package com.unrealdinnerbone.curseapi.api;

import com.unrealdinnerbone.curseapi.api.addon.AddonCurseFile;

import java.util.List;

public record FingerprintMatch(int id, AddonCurseFile file,
                               List<AddonCurseFile> latestFiles) {
}
