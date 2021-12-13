package com.unrealdinnerbone.curseapi.api;

import com.unrealdinnerbone.curseapi.CurseAPIUtils;
import com.unrealdinnerbone.curseapi.api.body.*;
import com.unrealdinnerbone.curseapi.api.response.Responses;
import com.unrealdinnerbone.curseapi.lib.Query;
import com.unrealdinnerbone.curseapi.lib.ReturnResult;

import java.util.concurrent.CompletableFuture;

public final class CurseAPI {

    private final String apiKey;
    private final V1 v1;

    public CurseAPI(String apiKey) {
        this.apiKey = apiKey;
        this.v1 = new V1();
    }

    public V1 v1() {
        return v1;
    }


    public class V1 {

        //Games
        public CompletableFuture<ReturnResult<Responses.Games>> getGames() {
            return getV1(Responses.Games.class, "games");
        }

        public CompletableFuture<ReturnResult<Responses.Game>> getGame(int game) {
            return getV1(Responses.Game.class, "games/" + game);
        }

        public CompletableFuture<ReturnResult<Responses.Versions>> getGameVersions(int game) {
            return getV1(Responses.Versions.class, "games/"+ game + "/versions");
        }

        public CompletableFuture<ReturnResult<Responses.VersionTypes>> getVersionTypes(int game) {
            return getV1(Responses.VersionTypes.class, "games/" + game + "/version-types");
        }

        public CompletableFuture<ReturnResult<Responses.Categories>> getCategories(Query.Category category) {
            return getV1(Responses.Categories.class, "categories" + category.build().query());
        }



        //Mods

        public CompletableFuture<ReturnResult<Responses.SearchMods>> searchMods(Query.Mod mod) {
            return getV1(Responses.SearchMods.class, "mods/search" + mod.build().query());
        }


        public CompletableFuture<ReturnResult<Responses.Mod>> getMod(int id) {
            return getV1(Responses.Mod.class, "mods/" + id);
        }

        public CompletableFuture<ReturnResult<Responses.Mods>> getMods(ModsByIdsListRequestBody body) {
            return postV1(Responses.Mods.class, body.toString(), "mods");
        }

        public CompletableFuture<ReturnResult<Responses.FeaturedMods>> getFeaturedMods(FeaturedModsRequestBody body) {
            return postV1(Responses.FeaturedMods.class, body.toString(), "mods/featured");
        }

        public CompletableFuture<ReturnResult<Responses.String>> getModDescription(int id) {
            return getV1(Responses.String.class, "mods/" + id + "/description");
        }


        //Files
        public CompletableFuture<ReturnResult<Responses.ModFile>> getModFile(int modId, int fileId) {
            return getV1(Responses.ModFile.class, "mods/" + modId +"/files/" + fileId);
        }

        //Todo https://docs.curseforge.com/#get-mod-file
        public CompletableFuture<ReturnResult<Responses.ModFiles>> getFiles(int modId) {
            return getV1(Responses.ModFiles.class, "mods/" + modId + "/files");
        }

        public CompletableFuture<ReturnResult<Responses.Files>> getFiles(ModFilesRequestBody body) {
            return postV1(Responses.Files.class, body.toString(), "mods/files");
        }


        public CompletableFuture<ReturnResult<Responses.String>> getFileChangelog(int modId, int fileId) {
            return getV1(Responses.String.class, "mods/" + modId + "/files/" + fileId +"/changelog");
        }

        public CompletableFuture<ReturnResult<Responses.DownloadURL>> getFileDownloadURl(int modId, int fileId) {
            return getV1(Responses.DownloadURL.class, "mods/" + modId + "/files/" + fileId+ "/download-url");
        }




        //Fingerprints
        public CompletableFuture<ReturnResult<Responses.Mods>> getFingerprintMatches(FingerprintMatchesRequestBody body) {
            return postV1(Responses.Mods.class, body.toString(), "fingerprints");
        }

        public CompletableFuture<ReturnResult<Responses.Mods>> getFeaturedMods(FuzzyMatchesRequestBody body) {
            return postV1(Responses.Mods.class, body.toString(), "fingerprints/fuzzy");
        }


        public <T> CompletableFuture<ReturnResult<T>> getV1(Class<T> tClass, String base) {
            return getBase(tClass, "v1/" + base);
        }

        public <T> CompletableFuture<ReturnResult<T>> postV1(Class<T> tClass, String data, String base) {
            return postBase(tClass, data, "v1/" + base);
        }

    }


    public <T> CompletableFuture<ReturnResult<T>> getBase(Class<T> tClass, String base) {
        return CurseAPIUtils.get(tClass, base, apiKey);
    }

    public <T> CompletableFuture<ReturnResult<T>> postBase(Class<T> tClass, String data, String base) {
        return CurseAPIUtils.post(tClass, base, data, apiKey);
    }

}
