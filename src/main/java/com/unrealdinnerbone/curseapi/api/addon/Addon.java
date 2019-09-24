package com.unrealdinnerbone.curseapi.api.addon;


import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class Addon
{
    private int id;
    private String name;
    private List<Author> authors;
    private List<Attachment> attachments;
    private String websiteUrl;
    private int gameId;
    private String summary;
    private int defaultFileId;
    private BigDecimal downloadCount;
    private List<AddonCurseFile> latestFiles;
    private List<AddonCategory> categories;
    private int status;
    private int primaryCategoryId;
    private CategorySection categorySection;
    private String slug;
    List<GameVersionFile> gameVersionLatestFiles;
    private boolean isFeatured;
    private double popularityScore;
    private int gamePopularityRank;
    private String primaryLanguage;
    private String gameSlug;
    private String gameName;
    private String portalName;
    private String dateModified;
    private String dateCreated;
    private String dateReleased;
    private boolean isAvailable;
    private boolean isExperiemental;
}
