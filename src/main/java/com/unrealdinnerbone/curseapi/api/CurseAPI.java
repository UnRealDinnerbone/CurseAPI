package com.unrealdinnerbone.curseapi.api;

import com.unrealdinnerbone.curseapi.CurseAPIUtils;
import com.unrealdinnerbone.curseapi.api.body.*;
import com.unrealdinnerbone.curseapi.api.minecraft.MinecraftGameVersion;
import com.unrealdinnerbone.curseapi.api.response.Responses;
import com.unrealdinnerbone.curseapi.quaries.CategoryQuery;
import com.unrealdinnerbone.curseapi.quaries.ModQuery;
import com.unrealdinnerbone.unreallib.apiutils.result.IResult;
import com.unrealdinnerbone.unreallib.json.JsonUtil;

public final class CurseAPI {

    private final String apiKey;
    private final V1 v1;

    public CurseAPI(String apiKey) {
        this.apiKey = apiKey;
        this.v1 = new V1();
    }

    public CurseAPI(String apiKey, String url) {
        this.apiKey = apiKey;
        this.v1 = new V1(url);
    }

    public V1 v1() {
        return v1;
    }


    public class V1 {

        private final String url;

        public V1() {
            this.url = "https://api.curseforge.com/v1/";
        }

        public V1(String url) {
            this.url = url;
        }

        //Games
        public IResult<Responses.Games> getGames() {
            return getV1(Responses.Games.class, "games");
        }

        public IResult<Responses.Game> getGame(int game) {
            return getV1(Responses.Game.class, "games/" + game);
        }

        public IResult<Responses.Versions> getGameVersions(int game) {
            return getV1(Responses.Versions.class, "games/"+ game + "/versions");
        }

        public IResult<Responses.VersionTypes> getVersionTypes(int game) {
            return getV1(Responses.VersionTypes.class, "games/" + game + "/version-types");
        }


        //Categories
        public IResult<Responses.Categories> getCategories(CategoryQuery category) {
            return getV1(Responses.Categories.class, "categories" + category.build().query());
        }



        //Mods
        public IResult<Responses.SearchMods> searchMods(ModQuery mod) {
            return getV1(Responses.SearchMods.class, "mods/search?" + mod.build().query());
        }


        public IResult<Responses.Mod> getMod(int id) {
            return getV1(Responses.Mod.class, "mods/" + id);
        }

        public IResult<Responses.Mods> getMods(ModsByIdsListRequestBody body) {
            return postV1(Responses.Mods.class, JsonUtil.DEFAULT.toJson(body), "mods");
        }

        public IResult<Responses.FeaturedMods> getFeaturedMods(FeaturedModsRequestBody body) {
            return postV1(Responses.FeaturedMods.class, JsonUtil.DEFAULT.toJson(body), "mods/featured");
        }

        public IResult<Responses.String> getModDescription(int id) {
            return getV1(Responses.String.class, "mods/" + id + "/description");
        }


        //Files
        public IResult<Responses.ModFile> getModFile(int modId, int fileId) {
            return getV1(Responses.ModFile.class, "mods/" + modId +"/files/" + fileId);
        }

        public IResult<Responses.ModFiles> getModFiles(int modId) {
            return getV1(Responses.ModFiles.class, "mods/" + modId + "/files");
        }

        //Todo https://docs.curseforge.com/#get-mod-file
        @Deprecated
        public IResult<Responses.ModFiles> getFiles(int modId) {
            return getModFiles(modId);
        }

        public IResult<Responses.Files> getFiles(ModFilesRequestBody body) {
            return postV1(Responses.Files.class, JsonUtil.DEFAULT.toJson(body), "mods/files");
        }

        public IResult<Responses.String> getModFileChangelog(int modId, int fileId) {
            return getV1(Responses.String.class, "mods/" + modId + "/files/" + fileId +"/changelog");
        }

        @Deprecated
        public IResult<Responses.String> getFileChangelog(int modId, int fileId) {
            return getModFileChangelog(modId, fileId);
        }

        public IResult<Responses.String> getModFileDownloadURl(int modId, int fileId) {
            return getV1(Responses.String.class, "mods/" + modId + "/files/" + fileId+ "/download-url");
        }

        @Deprecated
        public IResult<Responses.String> getFileDownloadURl(int modId, int fileId) {
            return getModFileDownloadURl(modId, fileId);
        }


        //Fingerprints
        public IResult<Responses.Mods> getFingerprintMatches(FingerprintMatchesRequestBody body) {
            return postV1(Responses.Mods.class, JsonUtil.DEFAULT.toJson(body), "fingerprints");
        }

        public IResult<Responses.Mods> getFeaturedMods(FuzzyMatchesRequestBody body) {
            return postV1(Responses.Mods.class, JsonUtil.DEFAULT.toJson(body), "fingerprints/fuzzy");
        }



        //Minecraft
        public IResult<MinecraftGameVersion[]> getMinecraftVersions() {
            return getV1(MinecraftGameVersion[].class, "minecraft/versions");
        }


        public IResult<MinecraftGameVersion> getMinecraftVersion(String gameVersionString) {
            return getV1(MinecraftGameVersion.class, "minecraft/versions/" + gameVersionString);
        }


        public <T> IResult<T> getV1(Class<T> tClass, String base) {
            return getBase(tClass, url + base);
        }

        public <T> IResult<T> postV1(Class<T> tClass, String data, String base) {
            return postBase(tClass, data, url + base);
        }

    }


    public <T> IResult<T> getBase(Class<T> tClass, String base) {
        return CurseAPIUtils.get(tClass, base, apiKey);
    }

    public <T> IResult<T> postBase(Class<T> tClass, String data, String base) {
        return CurseAPIUtils.post(tClass, base, data, apiKey);
    }

}
