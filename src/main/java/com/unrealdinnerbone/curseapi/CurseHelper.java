package com.unrealdinnerbone.curseapi;

import com.unrealdinnerbone.curseapi.api.Catergory;
import com.unrealdinnerbone.curseapi.api.FingerprintMatch;
import com.unrealdinnerbone.curseapi.api.MinecraftVersion;
import com.unrealdinnerbone.curseapi.api.ReleaseType;
import com.unrealdinnerbone.curseapi.api.addon.Addon;
import com.unrealdinnerbone.curseapi.api.addon.AddonCurseFile;
import com.unrealdinnerbone.curseapi.api.addon.ICurseFile;
import com.unrealdinnerbone.curseapi.api.file.FileCurseFile;
import com.unrealdinnerbone.curseapi.lib.JsonUtil;
import com.unrealdinnerbone.curseapi.lib.ReturnResult;
import com.unrealdinnerbone.unreallib.ArrayUtil;
import com.unrealdinnerbone.unreallib.StringUtils;
import com.unrealdinnerbone.unreallib.file.FileHelper;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Slf4j
public class CurseHelper {

        public static DecimalFormat df2 = new DecimalFormat("#.##");


//        public static HashMap<Long, File> getFilesHashesMap(File folder) {
//            HashMap<Long, File> map = new HashMap<>();
//            FileHelper.findFilesInFolder(folder, "jar").forEach(file -> map.put(FileHelper.getFilesMurmurHash(file), file));
//            return map;
//        }

        public static ICurseFile getLatestFile(FingerprintMatch fingerprintMatch, String minecraftVersion, ReleaseType releaseType) {
            List<ICurseFile> curseFiles = filterFiles(fingerprintMatch.getLatestFiles(), minecraftVersion, releaseType);
            if(curseFiles.size() == 0) {
                List<FileCurseFile> list = Arrays.asList(CurseAPI.getAddonFiles(fingerprintMatch.getId()).get());
                curseFiles = filterFiles(list, minecraftVersion, releaseType);
            }
            if(curseFiles.size() == 0) {
                log.error("There is not a better version {} mod with the release type {}", fingerprintMatch.getFile().getFileName(), releaseType.name());
                return null;
            }
            return ArrayUtil.getLastValue(curseFiles);
        }

        private static <T extends ICurseFile> List<ICurseFile> filterFiles(List<T> files, String minecraftVersion, ReleaseType releaseType) {
            return files.stream()
                    .filter(addonCurseFile -> addonCurseFile.getGameVersion().stream()
                            .anyMatch(gameVersion -> matchesVersion(gameVersion, minecraftVersion)))
                    .filter(addonCurseFile -> addonCurseFile.getReleaseType() <= releaseType.getId())
                    .sorted(Comparator.comparingLong(addonCurseFile -> CurseAPIUtils.formatTime(addonCurseFile.getFileDate())))
                    .collect(Collectors.toList());
        }

        //Todo this to have wild card matches
        public static boolean matchesVersion(String version, String matchVersion) {
            return version.equals(matchVersion);
        }

        public static void downloadCurseFile(ICurseFile curseFile, File downloadLocation) throws IOException {
            String fname = curseFile.getDownloadUrl().substring(curseFile.getDownloadUrl().lastIndexOf('/')+1);
            String rest = curseFile.getDownloadUrl().substring(0, curseFile.getDownloadUrl().lastIndexOf('/'));
            String encname = fname;
            try {
                encname = URLEncoder.encode(fname, StandardCharsets.UTF_8.name());
            } catch (UnsupportedEncodingException e) {
                // never going to happen
            }
            encname = encname.replaceAll("\\+","%20");

            log.debug("Downloading file {}... to {}", downloadLocation.getName(), downloadLocation.getName());
            FileHelper.downloadFile( rest+"/"+encname, downloadLocation);
        }



//    public static HashMap<Long, File> getFilesHashesMap(File folder){
//        HashMap<Long, File> map = new HashMap<>();
//        FileHelper.getFilesTypesInFolder(folder, "jar").forEach(file -> map.put(FileHelper.getFilesMurmurHash(file), file));
//        return map;
//    }

    public static List<Integer> getAllAddonsForGame(int gameId, Constants.MinecraftSections minecraftSection) {
        int starIndex = 0;
        List<Integer> allAddons = new ArrayList<>();
        log.info("Starting Search for all addons for {} with the selection {}", gameId, minecraftSection.name());
        log.warn("This will take a few minutes");
        List<MinecraftVersion> minecraftVersions = Arrays.asList(CurseAPI.getMinecraftVersionsList().get());
        List<Catergory> catergoriesList = Arrays.stream(CurseAPI.getCategoryList().get()).filter(catergory -> catergory.getRootGameCategoryId() != null).filter(catergory -> catergory.getGameId() == gameId).filter(catergory -> catergory.getRootGameCategoryId() == minecraftSection.getSectionID()).collect(Collectors.toList());
        int amount = minecraftVersions.size() * catergoriesList.size();
        AtomicInteger runCount = new AtomicInteger();
        minecraftVersions.stream().parallel().forEach(minecraftVersion -> {
            catergoriesList.parallelStream().forEach(catergory -> {
                String percent = df2.format(((double) runCount.getAndIncrement() / (double) amount) * 100);
                log.info("[{}%]: scan for all on {} and category {}", percent, minecraftVersion.getVersionString(), catergory.getName());
                if (catergory.getGameId() == gameId) {
                    ReturnResult<Addon[]> returnResult = CurseAPI.getAddons(gameId, starIndex, minecraftVersion.getVersionString(), catergory.getId(), minecraftSection);
                    if (returnResult.get() != null) {
                        Addon[] addons = returnResult.get();
                        for (Addon addon : addons) {
                            if (!allAddons.contains(addon.getId())) {
                                allAddons.add(addon.getId());
                            }
                        }
                    }

                }
            });
        });
        log.info("Found {} addons", allAddons.size());
        return allAddons;
    }

}


//    public static CurseFile[] getAllFilesForAddon(int addonID) {
//       return JsonUtil.getBasicGson().fromJson(get(StringUtils.replace("addon/{0}/files", addonID)), CurseFile[].class);
//    }