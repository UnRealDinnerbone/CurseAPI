package com.unrealdinnerbone.curseapi.api.response;

import com.unrealdinnerbone.curseapi.api.IListResponse;
import com.unrealdinnerbone.curseapi.api.IResponse;
import com.unrealdinnerbone.curseapi.api.Pagination;
import com.unrealdinnerbone.curseapi.api.category.Category;
import com.unrealdinnerbone.curseapi.api.fingerprint.FingerprintFuzzyMatchResult;
import com.unrealdinnerbone.curseapi.api.fingerprint.FingerprintsMatchesResult;
import com.unrealdinnerbone.curseapi.api.game.GameVersionType;
import com.unrealdinnerbone.curseapi.api.game.GameVersionsByType;
import com.unrealdinnerbone.curseapi.api.file.FeaturedModsResponse;
import com.unrealdinnerbone.curseapi.api.file.File;
import com.unrealdinnerbone.curseapi.api.mod.Mod;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

public class Responses
{
    public record Categories(List<Category> data) implements IListResponse<Category> {}
    public record FeaturedMods(FeaturedModsResponse data) implements IResponse<FeaturedModsResponse> {}
    public record Files(List<File> data) implements IListResponse<File> {}
    public record FingerprintMatches(FingerprintsMatchesResult data) implements IResponse<FingerprintsMatchesResult> {}
    public record FingerprintsFuzzyMatches(FingerprintFuzzyMatchResult data) implements IResponse<FingerprintFuzzyMatchResult> {}
    public record Game(com.unrealdinnerbone.curseapi.api.game.Game data) implements IResponse<com.unrealdinnerbone.curseapi.api.game.Game> {}
    public record Games(List<com.unrealdinnerbone.curseapi.api.game.Game> data, Pagination pagination) implements IListResponse<com.unrealdinnerbone.curseapi.api.game.Game> {}
    public record ModFile(File data) implements IResponse<File> {}
    public record ModFiles(List<File> data, Pagination pagination) implements IListResponse<File> {}
    public record Mod(com.unrealdinnerbone.curseapi.api.mod.Mod data) implements IResponse<com.unrealdinnerbone.curseapi.api.mod.Mod> {}
    public record Mods(List<com.unrealdinnerbone.curseapi.api.mod.Mod> data) implements IListResponse<com.unrealdinnerbone.curseapi.api.mod.Mod> {}
    public record VersionTypes(List<GameVersionType> data) implements IListResponse<GameVersionType> {}
    public record Versions(List<GameVersionsByType> data) implements IListResponse<GameVersionsByType> {}
    public record SearchMods(List<com.unrealdinnerbone.curseapi.api.mod.Mod> data, Pagination pagination) implements IListResponse<com.unrealdinnerbone.curseapi.api.mod.Mod> {}
    public record String(java.lang.String data) implements IResponse<java.lang.String> {}
    public record DownloadURL(java.lang.String data) implements IResponse<java.lang.String> {
        public java.lang.String getFormattedURL() throws UnsupportedEncodingException {
            return URLEncoder.encode(data(), StandardCharsets.UTF_8.name());
        }
    }



}
