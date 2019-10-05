package com.unrealdinnerbone.curseapi;

import com.unrealdinnerbone.curseapi.api.FingerprintMatch;
import com.unrealdinnerbone.curseapi.api.ReleaseType;
import com.unrealdinnerbone.curseapi.api.addon.AddonCurseFile;
import com.unrealdinnerbone.curseapi.api.addon.ICurseFile;
import com.unrealdinnerbone.curseapi.api.file.FileCurseFile;
import com.unrealdinnerbone.curseapi.lib.ReturnResult;
import com.unrealdinnerbone.unreallib.ArrayUtil;
import com.unrealdinnerbone.unreallib.StringUtils;
import com.unrealdinnerbone.unreallib.file.FileHelper;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class CurseHelper {

        public static HashMap<Long, File> getFilesHashesMap(File folder) {
            HashMap<Long, File> map = new HashMap<>();
            FileHelper.getFilesTypesInFolder(folder, "jar").forEach(file -> map.put(FileHelper.getFilesMurmurHash(file), file));
            return map;
        }

        public static ICurseFile getLatestFile(FingerprintMatch fingerprintMatch, String minecraftVersion, ReleaseType releaseType) {
            List<ICurseFile> curseFiles = filterFiles(fingerprintMatch.getLatestFiles(), minecraftVersion, releaseType);
            if(curseFiles.size() == 0) {
                List<FileCurseFile> list = Arrays.asList(CurseAPI.getAddonFiles(fingerprintMatch.getId()).get());
                curseFiles = filterFiles(list, minecraftVersion, releaseType);
            }
            if(curseFiles.size() == 0) {
                log.error("There is now {} version of better for {} mod", releaseType.name(), fingerprintMatch.getFile().getFileName());
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

        public static void downloadCurseFile(ICurseFile curseFile, File downloadLocation) {
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

}


//    public static HashMap<Long, File> getFilesHashesMap(File folder){
//        HashMap<Long, File> map = new HashMap<>();
//        FileHelper.getFilesTypesInFolder(folder, "jar").forEach(file -> map.put(FileHelper.getFilesMurmurHash(file), file));
//        return map;
//    }

//    public static List<Addon> getAllAddonsForGame(int gameId) {
//        int starIndex = 0;
//        List<Addon> allAddons = new ArrayList<>();
//        boolean keepGoing = true;
//        while (keepGoing) {
//            List<Addon> addons = getAddons(gameId, -1, starIndex + 1);
//            log.debug("Addon size is {}", addons.size());
//            if(addons.size() == 1000) {
//                allAddons.addAll(addons);
//            }else {
//                keepGoing = false;
//            }
//            starIndex += 1000;
//            if (allAddons.size() != starIndex) {
//                keepGoing = false;
//            }
//        }
//
//        return allAddons;
//    }

//    public static CurseFile[] getAllFilesForAddon(int addonID) {
//       return JsonUtil.getBasicGson().fromJson(get(StringUtils.replace("addon/{0}/files", addonID)), CurseFile[].class);
//    }