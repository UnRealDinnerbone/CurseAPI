package com.unrealdinnerbone.curseapi.api.fingerprint;

import com.unrealdinnerbone.curseapi.api.file.File;

import java.util.List;

public record FingerprintFuzzyMatch(long id, File file, List<File> latestFiles, List<Integer> fingerprints) {
}
