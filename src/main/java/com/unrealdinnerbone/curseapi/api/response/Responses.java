package com.unrealdinnerbone.curseapi.api.response;

import com.unrealdinnerbone.curseapi.api.Pagination;
import com.unrealdinnerbone.curseapi.api.category.Category;
import com.unrealdinnerbone.curseapi.api.fingerprint.FingerprintFuzzyMatchResult;
import com.unrealdinnerbone.curseapi.api.fingerprint.FingerprintsMatchesResult;
import com.unrealdinnerbone.curseapi.api.game.GameVersionType;
import com.unrealdinnerbone.curseapi.api.game.GameVersionsByType;
import com.unrealdinnerbone.curseapi.api.file.FeaturedModsResponse;
import com.unrealdinnerbone.curseapi.api.file.File;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Responses
{
    public record Categories(List<Category> data) {}
    public record FeaturedMods(FeaturedModsResponse data) {}
    public record Files(List<File> data) {}
    public record FingerprintMatches(FingerprintsMatchesResult data) {}
    public record FingerprintsFuzzyMatches(FingerprintFuzzyMatchResult data) {}
    public record Game(com.unrealdinnerbone.curseapi.api.game.Game data) {}
    public record Games(List<com.unrealdinnerbone.curseapi.api.game.Game> data, Pagination pagination) {}
    public record ModFile(File data) {}
    public record ModFiles(List<File> data, Pagination pagination) {}
    public record Mod(com.unrealdinnerbone.curseapi.api.mod.Mod data) {}
    public record Mods(List<com.unrealdinnerbone.curseapi.api.mod.Mod> data) {}
    public record VersionTypes(List<GameVersionType> data) {}
    public record Versions(List<GameVersionsByType> data) {}
    public record SearchMods(List<com.unrealdinnerbone.curseapi.api.mod.Mod> data, Pagination pagination) {}
    public record String(java.lang.String data) {}
    public record DownloadURL(java.lang.String data) {

        public java.lang.String getFormattedURL() throws UnsupportedEncodingException {
            return URLEncoder.encode(data, StandardCharsets.UTF_8.name());
        }
    }



}
