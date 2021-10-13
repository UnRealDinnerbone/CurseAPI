package com.unrealdinnerbone.curseapi.api.fingerprint;

import com.unrealdinnerbone.curseapi.api.file.File;

import java.util.List;

public record FingerprintMatch(long id, File file, List<File> latestFiles) {
}
