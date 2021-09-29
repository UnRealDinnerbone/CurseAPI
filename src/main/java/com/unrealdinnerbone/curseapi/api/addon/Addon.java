package com.unrealdinnerbone.curseapi.api.addon;

import java.math.BigDecimal;
import java.util.List;

public record Addon(int id, String name,
                    List<Author> authors,
                    List<Attachment> attachments,
                    String websiteUrl, int gameId, String summary, int defaultFileId,
                    long downloadCount,
                    List<AddonCurseFile> latestFiles,
                    List<AddonCategory> categories, int status,
                    int primaryCategoryId, CategorySection categorySection,
                    String slug,
                    List<GameVersionFile> gameVersionLatestFiles,
                    boolean isFeatured, double popularityScore, int gamePopularityRank,
                    String primaryLanguage, String gameSlug, String gameName,
                    String portalName, String dateModified, String dateCreated,
                    String dateReleased, boolean isAvailable, boolean isExperiemental) {
}
