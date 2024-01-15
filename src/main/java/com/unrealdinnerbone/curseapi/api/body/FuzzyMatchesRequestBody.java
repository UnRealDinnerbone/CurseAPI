package com.unrealdinnerbone.curseapi.api.body;

import com.unrealdinnerbone.curseapi.api.fingerprint.FolderFingerprint;

import java.util.List;

public record FuzzyMatchesRequestBody(int gameId, List<FolderFingerprint> fingerprints) {}
