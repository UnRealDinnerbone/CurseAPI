package com.unrealdinnerbone.curseapi;

import com.unrealdinnerbone.curseapi.api.Catergory;
import com.unrealdinnerbone.curseapi.api.FingerprintResult;
import com.unrealdinnerbone.curseapi.api.MinecraftVersion;
import com.unrealdinnerbone.curseapi.api.ModLoader;
import com.unrealdinnerbone.curseapi.api.addon.Addon;
import com.unrealdinnerbone.curseapi.api.addon.AddonCurseFile;
import com.unrealdinnerbone.curseapi.api.file.FileCurseFile;
import com.unrealdinnerbone.curseapi.api.game.Game;
import com.unrealdinnerbone.curseapi.lib.ReturnResult;
import com.unrealdinnerbone.unreallib.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class CurseAPI {

    public static ReturnResult<Addon> getAddon(int addonId) {
        return get(Addon.class, "addon/{0}", addonId);
    }

    public static ReturnResult<Addon[]> getAddons(Integer[] addonIds) {
        return post(Addon[].class, "addon", addonIds);
    }

    public static String getAddonDescription(int addonId) {
        return getString("addon/{0}/description", addonId);
    }

    public static String getAddonFileChangelog(int addonId, int fileId) {
        return getString("addon/{0}/file/{1}/changelog", addonId, fileId);
    }

    public static ReturnResult<FileCurseFile> getAddonFileInfo(int addonID, int fileId) {
        return get(FileCurseFile.class,"addon/{0}/file/{1}", addonID, fileId);
    }

    public static String getAddonFileDownloadURL(int addonID, int fileId) {
        return getString("addon/{0}/file/{1}/download-url", addonID, fileId);
    }

    public static ReturnResult<FileCurseFile[]> getAddonFiles(Integer addonID) {
        return get(FileCurseFile[].class, "addon/{0}/files", addonID);
    }

    public static String getAddonDatabaseTimestamp() {
        return getString("addon/timestamp");
    }

    //Todo TEST ME
    public static ReturnResult<FingerprintResult> getAddonsByFingerprint(long[] fingerprint) {
        return post(FingerprintResult.class, "fingerprint", fingerprint);
    }

    public static String getMinecraftVersionTimestamp() {
        return getString("minecraft/version/timestamp");
    }

    public static ReturnResult<MinecraftVersion[]> getMinecraftVersionsList() {
        return get(MinecraftVersion[].class, "minecraft/version");
    }

    public static ReturnResult<MinecraftVersion> getMinecraftVersionInfo(String version) {
        return get(MinecraftVersion.class,"minecraft/version/{0}", version);
    }

    public static String getModLoaderTimestamp() {
        return getString("minecraft/modloader/timestamp");
    }

    public static ReturnResult<ModLoader[]> getModLoaderList() {
        return get(ModLoader[].class, "minecraft/modloader");
    }

    //Todo TEST ME ALSO
    public static ReturnResult<ModLoader> getModLoaderInfo(String versionName) {
        return get(ModLoader.class, "minecraft/modloader/{0}", versionName);
    }

    public static String getCategoryTimestamp() {
        return getString("category/timestamp");
    }

    public static ReturnResult<Catergory[]> getCategoryList() {
        return get(Catergory[].class, "category");
    }

    public static ReturnResult<Catergory> getCategoryListInfo(int categoryId) {
        return get(Catergory.class,"category/{0}", categoryId);
    }

    @Deprecated
    public static ReturnResult<Catergory> getCategorySectionInfo(int sectionId) {
        return get(Catergory.class, "category/section/{0}", sectionId);
    }

    public static String getGameTimestamp() {
        return getString("game/timestamp");
    }

    public static ReturnResult<Game[]> getGameList(boolean supportsAddons)
    {
        return get(Game[].class, "/game?supportsAddons={0}", supportsAddons);
    }

    public static ReturnResult<Addon[]> getAddons(int gameId, int start, String gameVersion, int cat, Constants.MinecraftSections minecraftSection) {
        ReturnResult<Addon[]> ad = get(Addon[].class, "addon/search?gameId={0}&index={1}&pageSize=10000&sectionId={4}&gameVersion={2}&categoryId={3}", gameId, start, gameVersion, cat, minecraftSection.getSectionID());
        return ad;
    }

    public static ReturnResult<Addon[]> getAddons(int gameId) {
        ReturnResult<Addon[]> ad = get(Addon[].class, "addon/search?gameId={0}", gameId);
        return ad;
    }

    public static ReturnResult<Game> getGameInfo(int gameId) {
        return get(Game.class, "game/{0}", gameId);
    }

    private static <T> ReturnResult<T> post(Class<T> tClass, String base, Object dataValue) {
        return new ReturnResult<>(CurseAPIUtils.post(base, dataValue), tClass);
    }

    private static String getString(String base, Object... replacements) {
        return CurseAPIUtils.get(StringUtils.replace(base, replacements));
    }

    private static <T> ReturnResult<T> get(Class<T> tClass, String base, Object... replacements) {
        return new ReturnResult<>(CurseAPIUtils.get(StringUtils.replace(base, replacements)), tClass);
    }


}
