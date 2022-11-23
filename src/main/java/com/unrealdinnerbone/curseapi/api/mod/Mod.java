package com.unrealdinnerbone.curseapi.api.mod;

import com.unrealdinnerbone.curseapi.api.category.Category;
import com.unrealdinnerbone.curseapi.api.file.File;

import java.util.List;

public record Mod(int id,
                  int gameId,
                  String name,
                  String slug,
                  ModLinks links,
                  String summary,
                  ModStatus status,
                  double downloadCount,
                  boolean isFeatured,
                  int primaryCategoryId,
                  List<Category> categories,
                  Integer classId,
                  List<ModAuthor> authors,
                  ModAsset logo,
                  List<ModAsset> screenshots,
                  int mainFileId,
                  List<File> latestFiles,
                  List<FileIndex> latestFilesIndexes,
                  String dateCreated,
                  String dateModified,
                  String dateReleased,
                  Boolean allowModDistribution,
                  int gamePopularityRank,
                  boolean isAvailable) {
}
