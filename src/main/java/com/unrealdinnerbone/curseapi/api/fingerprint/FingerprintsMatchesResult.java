package com.unrealdinnerbone.curseapi.api.fingerprint;

import java.util.List;

public record FingerprintsMatchesResult(boolean isCacheBuilt,
                                        List<FingerprintMatch> exactMatches,
                                        List<Integer> exactFingerprints,
                                        List<FingerprintMatch> partialMatches,
//                                        Todo partialMatchFingerprints	object	none
                                        List<Integer> additionalProperties,
                                        List<Integer> installedFingerprints,
                                        List<Integer> unmatchedFingerprints) {}
