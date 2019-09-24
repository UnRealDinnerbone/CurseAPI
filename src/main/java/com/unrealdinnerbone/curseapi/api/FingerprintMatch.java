package com.unrealdinnerbone.curseapi.api;

import com.unrealdinnerbone.curseapi.api.addon.AddonCurseFile;
import lombok.Getter;

import java.util.List;

@Getter
public class FingerprintMatch
{
    private int id;
    private AddonCurseFile file;
    private List<AddonCurseFile> latestFiles;

}
