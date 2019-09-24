//package com.unrealdinnerbone.curseapi;
//
//import com.unrealdinnerbone.curseapi.api.addon.Addon;
//import com.unrealdinnerbone.curseapi.api.addon.AddonSortMethod;
//import com.unrealdinnerbone.curseapi.api.addon.CurseFile;
//import com.unrealdinnerbone.curseapi.api.FingerprintResult;
//import com.unrealdinnerbone.curseapi.lib.JsonUtil;
//import com.unrealdinnerbone.unreallib.StringUtils;
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import static com.unrealdinnerbone.curseapi.CurseAPIUtils.get;
//import static com.unrealdinnerbone.curseapi.CurseAPIUtils.post;
//
//@Slf4j
//public class CurseAPIL {
//
//    public static String getRawAddon(int addonId) {
//        System.out.println(get(StringUtils.replace("addon/{0}", addonId)));
//        return get(StringUtils.replace("addon/{0}", addonId));
//    }
//
//    public static Addon getAddon(int addonId) {
//        return JsonUtil.getBasicGson().fromJson(getRawAddon(addonId), Addon.class);
////        return JsonUtil.getBasicGson().fromJson(getRawAddon(addonId), Addon.class);
//    }
//
//    public static Addon getAddon(String addonJson) {
//        return JsonUtil.getBasicGson().fromJson(addonJson, Addon.class);
//    }
//
//    public static Addon[] getAddons(Integer[] addonIds) {
//        return JsonUtil.getBasicGson().fromJson(post("addon", addonIds), Addon[].class);
//    }
//
//    public static String getAddonDescription(int addonId) {
//        return get(StringUtils.replace("addon/{0}/description", addonId));
//    }
//
//    public static String getAddonChangelog(int addonId, int fileId) {
//        return get(StringUtils.replace("addon/{0}/file/{1}/changelog", addonId, fileId));
//    }
//
//    public static CurseFile getAddonFile(int addonId, int fileId) {
//        return JsonUtil.getBasicGson().fromJson(get(StringUtils.replace("addon/{0}/file/{1]", addonId, fileId)), CurseFile.class);
//    }
//
//    public static List<CurseFile> getAddonFiles(int addonId) {
//        return Arrays.asList(JsonUtil.getBasicGson().fromJson(get(StringUtils.replace("addon/{0}/files", addonId)), CurseFile[].class));
//    }
//
//    public static FingerprintResult getFingerprintMatch(long[] murs) {
//        return JsonUtil.getBasicGson().fromJson(post("fingerprint", murs), FingerprintResult.class);
//    }
//
//    public static List<Addon> getAddonsByCriteria(int gameId, int sectionId, int categoryId, String gameVenison, int index, int pageSize, String searchFilter, AddonSortMethod sortMethod, boolean sortDescending) {
//        return Arrays.asList(JsonUtil.getBasicGson().fromJson(get(StringUtils.replace("addon/search?gameId={0}&sectionId={1}&categoryId={2}&gameVersion={3}&index={4}&pageSize={5}&searchFilter={6}&sort={7}&sortDescending={8}", gameId, sectionId, categoryId, gameVenison, index, pageSize, searchFilter, sortMethod, sortDescending)), Addon[].class));
//    }
//
//    public static List<Addon> getAddons(int gameId, int sectionId, int index) {
//        String value = get(StringUtils.replace("addon/search?gameId={0}&sectionId={1}&index={2}&pageSize=1000", gameId, sectionId, index));
//        return value != null && !(value.isEmpty()) ? Arrays.asList(JsonUtil.getBasicGson().fromJson(value, Addon[].class)) : Collections.emptyList();
//    }
//}
//
//
////    public static CurseFile getLatestFile(FingerprintMatch fingerprintMatch, String minecraftVersion, ReleaseType releaseType) {
////        long lastestFileUploadedTime = 0;
////        CurseFile lastestFile = null;
////        for (CurseFile loopFile : fingerprintMatch.getLatestFiles()) {
////            ReleaseType fileRelaseType = ReleaseType.fromId(loopFile.getReleaseType());
////            if (fileRelaseType.getId() <= releaseType.getId()) {
////                if (loopFile.getGameVersion().contains(minecraftVersion)) {
////                    long time = CurseAPIUtils.formatTime(loopFile.getFileDate());
////                    if (time > lastestFileUploadedTime) {
////                        lastestFile = loopFile;
////                        lastestFileUploadedTime = time;
////                    }
////                }
////            }
////        }
////        return lastestFile;
////    }
//
////    public static CompletableFuture<Boolean> downloadCurseFile(CurseFile curseFile, File downloadLocation) {
////        CompletableFuture<Boolean> booleanCompletableFuture = new CompletableFuture<>();
////        if(curseFile.getDownloadUrl().contains("'")) {
////            log.error(StringUtils.replace("{0} Will not be updated!, there is a ' in the download file url (this may be fixed in the future)", curseFile.getFileName()));
////            log.error(StringUtils.replace("\t use {0} to update it", curseFile.getDownloadUrl()));
////            FileHelper.deleteFile(downloadLocation);
////            booleanCompletableFuture.complete(false);
////        }else {
////            log.debug(StringUtils.replace("Downloading file {0}... to {1}", downloadLocation.getName()));
////            FileHelper.downloadFile(curseFile.getDownloadUrl(), downloadLocation);
////            booleanCompletableFuture.complete(true);
////        }
////        return booleanCompletableFuture;
////    }
//
////    public static HashMap<Long, File> getFilesHashesMap(File folder){
////        HashMap<Long, File> map = new HashMap<>();
////        FileHelper.getFilesTypesInFolder(folder, "jar").forEach(file -> map.put(FileHelper.getFilesMurmurHash(file), file));
////        return map;
////    }
//
////    public static List<Addon> getAllAddonsForGame(int gameId) {
////        int starIndex = 0;
////        List<Addon> allAddons = new ArrayList<>();
////        boolean keepGoing = true;
////        while (keepGoing) {
////            List<Addon> addons = getAddons(gameId, -1, starIndex + 1);
////            log.debug("Addon size is {}", addons.size());
////            if(addons.size() == 1000) {
////                allAddons.addAll(addons);
////            }else {
////                keepGoing = false;
////            }
////            starIndex += 1000;
////            if (allAddons.size() != starIndex) {
////                keepGoing = false;
////            }
////        }
////
////        return allAddons;
////    }
//
////    public static CurseFile[] getAllFilesForAddon(int addonID) {
////       return JsonUtil.getBasicGson().fromJson(get(StringUtils.replace("addon/{0}/files", addonID)), CurseFile[].class);
////    }