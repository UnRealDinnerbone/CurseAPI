package com.unrealdinnerbone.curseapi;

import com.unrealdinnerbone.curseapi.api.CurseAPI;
import com.unrealdinnerbone.curseapi.api.SortOrder;
import com.unrealdinnerbone.curseapi.api.body.FeaturedModsRequestBody;
import com.unrealdinnerbone.curseapi.api.body.ModFilesRequestBody;
import com.unrealdinnerbone.curseapi.api.body.ModsByIdsListRequestBody;
import com.unrealdinnerbone.curseapi.api.game.GameVersionType;
import com.unrealdinnerbone.curseapi.api.game.GameVersionsByType;
import com.unrealdinnerbone.curseapi.api.mod.Mod;
import com.unrealdinnerbone.curseapi.api.mod.ModsSearchSortField;
import com.unrealdinnerbone.curseapi.api.response.Responses;
import com.unrealdinnerbone.curseapi.lib.EnvUtil;
import com.unrealdinnerbone.curseapi.lib.Query;
import com.unrealdinnerbone.curseapi.lib.json.JsonUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class CurseAPITest extends BaseTest
{
    private static final Logger LOGGER = LoggerFactory.getLogger(CurseAPITest.class);

    public static final CurseAPI CURSE_API = new CurseAPI(System.getenv().getOrDefault("TEST_API_KEY", ""));

    public static final int MINECRAFT_ID = EnvUtil.getInt("MINECRAFT_ID", 432);
    public static final String MINECRAFT_NAME = EnvUtil.getString("MINECRAFT_NAME", "Minecraft");

//    @Before
//    public void setUp() {
//        Assert.assertNotEquals("API Key is not set", "", System.getenv().getOrDefault("TEST_API_KEY", ""));
//    }

    @Test
    public void cake() throws ExecutionException, InterruptedException {
        for (Mod gaz : CURSE_API.v1().searchMods(Query.Mod.builder().searchFilter("bLog")).get().get().data()) {
            LOGGER.info("{}", gaz);
        }
    }

    @Test
    public void getGames() throws ExecutionException, InterruptedException, IOException {
        Responses.Games games = test(CURSE_API.v1().getGames());
        Assert.assertTrue("Game Minecraft not found", games.data().stream().anyMatch(game -> game.id() == MINECRAFT_ID));
        LOGGER.info("Found {} Games", games.pagination().resultCount());
    }

    @Test
    public void getGame() throws ExecutionException, InterruptedException, IOException {
        Responses.Game game = test(CURSE_API.v1().getGame(MINECRAFT_ID));
        Assert.assertEquals(MINECRAFT_ID + " is not Minecraft?", MINECRAFT_NAME, game.data().name());
    }


    @Test
    public void getGameVersions() throws ExecutionException, InterruptedException, IOException {
        Responses.Versions versions = test(CURSE_API.v1().getGameVersions(MINECRAFT_ID));
    }

    @Test
    public void getCategories() throws ExecutionException, InterruptedException, IOException {
        test(CURSE_API.v1().getCategories(Query.Category.builder().setGameId(MINECRAFT_ID)));
    }

    @Test
    public void searchMods() throws ExecutionException, InterruptedException, IOException {
        test(CURSE_API.v1().searchMods(Query.Mod.builder().gameId(MINECRAFT_ID)));
    }


    @Test
    public void testGameVersionsTypes() throws ExecutionException, InterruptedException, IOException {
        test(CURSE_API.v1().getVersionTypes(MINECRAFT_ID));
    }


    @Test
    public void getMod() throws ExecutionException, InterruptedException, IOException {
        test(CURSE_API.v1().getMod(230556));
    }

    @Test
    public void getMods() throws ExecutionException, InterruptedException, IOException {
        test(CURSE_API.v1().getMods(new ModsByIdsListRequestBody(List.of(297028))));
    }

    @Test
    public void getFeaturedMods() throws ExecutionException, InterruptedException, IOException {
        test(CURSE_API.v1().getFeaturedMods(new FeaturedModsRequestBody(432, new ArrayList<>(), null)));
    }

    @Test
    public void getModDescription() throws ExecutionException, InterruptedException, IOException {
        test(CURSE_API.v1().getModDescription(297028));
    }


    @Test
    public void getModFile() throws ExecutionException, InterruptedException, IOException {
        test(CURSE_API.v1().getModFile(297028, 3432688));
    }

    @Test
    public void getFiles() throws ExecutionException, InterruptedException, IOException {
        test(CURSE_API.v1().getFiles(297028));
    }

    @Test
    public void getAllFiles() throws ExecutionException, InterruptedException, IOException {
        test(CURSE_API.v1().getFiles(new ModFilesRequestBody(Arrays.asList(297028))));
    }

    @Test
    public void getFileChangelog() throws ExecutionException, InterruptedException, IOException {
        test(CURSE_API.v1().getFileChangelog(297028, 3432688));
    }

    @Test
    public void getFileDownloadURl() throws ExecutionException, InterruptedException, IOException {
        test(CURSE_API.v1().getModFileDownloadURl(230556, 3684260));
    }

    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    @Test
    public void blockTest() throws ExecutionException, InterruptedException, IOException {
        List<GameVersionType> type = CURSE_API.v1().getVersionTypes(MINECRAFT_ID).get().get().data();
        for(GameVersionType datum : type) {
            try {
                findBlockedMods(0, datum.id());
            }catch(Exception e) {
                LOGGER.error("Error while testing {}", datum.id(), e);
            }
            LOGGER.info("Total Mods Found: {}", atomicInteger.get());
        }

//        Data data = JsonUtil.MOSHI.adapter(Data.class).fromJson(Files.readString(Path.of("thing.json")));
//        for(Data.File file : data.files()) {
//            Mod mod = CURSE_API.v1().getMod(file.projectID).get().getExceptionally().data();
//            if(mod.allowModDistribution() != null && !mod.allowModDistribution()) {
//                LOGGER.info("{} {}", mod.name(), false);
//
//            }
//        }
    }


    List<String> foundMods = new ArrayList<>();
    private void findBlockedMods(int offset, int gameVersion) throws ExecutionException, InterruptedException, IOException {

        List<Mod> mods = CURSE_API.v1().searchMods(Query.Mod.builder().gameId(MINECRAFT_ID).index(offset).gameVersionTypeId(gameVersion).pageSize(50)).get().get().data();
        for(Mod mod : mods) {
            if(!foundMods.contains(mod.slug())) {
                atomicInteger.incrementAndGet();
                if(mod.allowModDistribution() == null || !mod.allowModDistribution()) {
                    LOGGER.info("Found Blocked Mod: {}", mod.name());
                    if(!Files.exists(Path.of("blocked.txt"))) {
                        Files.createFile(Path.of("blocked.txt"));
                    }
                    String type = mod.allowModDistribution() == null ? "Unchanged" : "Blocked";
                    Files.writeString(Path.of("blocked.txt"),  String.format("%09d", (int) mod.downloadCount()) + " - " + type + " - " + mod.name() + "\n", StandardOpenOption.APPEND);
                }
                foundMods.add(mod.slug());
            }

        }
        if(mods.size() == 50) {
            if(offset + 50 < 10000) {
                findBlockedMods(offset + 50, gameVersion);
            }else {
                LOGGER.warn("Offset: {}", offset);
            }
        }else {
            LOGGER.warn("Found {} mods", mods.size());
        }
    }


    public record Data(File[] files) {
        public record File(int projectID, int fileID) {}
    }

}
