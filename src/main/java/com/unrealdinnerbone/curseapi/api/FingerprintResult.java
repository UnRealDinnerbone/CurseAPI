package com.unrealdinnerbone.curseapi.api;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;

@Getter
public class FingerprintResult
{
    private boolean isCacheBuilt;
    private List<FingerprintMatch> exactMatches;
    private List<Long> exactFingerprints;
    private List<Long> partialMatches;
    public HashMap<Integer,Long> partialMatchFingerprints;
    private List<Long> installedFingerprints;
    private List<Long> unmatchedFingerprints;
}
