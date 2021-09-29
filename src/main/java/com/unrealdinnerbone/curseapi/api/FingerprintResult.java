package com.unrealdinnerbone.curseapi.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record FingerprintResult(boolean isCacheBuilt,
                                List<FingerprintMatch> exactMatches,
                                List<Long> exactFingerprints,
                                List<Long> partialMatches,
                                Map<Integer, Long> partialMatchFingerprints,
                                List<Long> installedFingerprints,
                                List<Long> unmatchedFingerprints) {
}
