package com.unrealdinnerbone.curseapi;

import com.unrealdinnerbone.curseapi.api.CurseAPI;
import com.unrealdinnerbone.curseapi.api.body.FeaturedModsRequestBody;
import com.unrealdinnerbone.curseapi.api.body.ModFilesRequestBody;
import com.unrealdinnerbone.curseapi.api.body.ModsByIdsListRequestBody;
import com.unrealdinnerbone.curseapi.api.game.GameVersionType;
import com.unrealdinnerbone.curseapi.api.game.GameVersionsByType;
import com.unrealdinnerbone.curseapi.api.response.Responses;
import com.unrealdinnerbone.curseapi.lib.EnvUtil;
import com.unrealdinnerbone.curseapi.lib.Query;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

public class CurseAPITest extends BaseTest
{
    private static final Logger LOGGER = LoggerFactory.getLogger(CurseAPITest.class);

    public static final CurseAPI CURSE_API = new CurseAPI(System.getenv().getOrDefault("TEST_API_KEY", ""));

    public static final int MINECRAFT_ID = EnvUtil.getInt("MINECRAFT_ID", 432);
    public static final String MINECRAFT_NAME = EnvUtil.getString("MINECRAFT_NAME", "Minecraft");

    @Before
    public void setUp() {
        Assert.assertNotEquals("API Key is not set", "", System.getenv().getOrDefault("TEST_API_KEY", ""));
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
        test(CURSE_API.v1().getCategories( new Query.Category().setGameId(MINECRAFT_ID)));
    }

    @Test
    public void searchMods() throws ExecutionException, InterruptedException, IOException {
        test(CURSE_API.v1().searchMods(new Query.Mod().gameId(MINECRAFT_ID)));
    }


    @Test
    public void testGameVersionsTypes() throws ExecutionException, InterruptedException, IOException {
        test(CURSE_API.v1().getVersionTypes(MINECRAFT_ID));
    }


    @Test
    public void getMod() throws ExecutionException, InterruptedException, IOException {
        test(CURSE_API.v1().getMod(297028));
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
        test(CURSE_API.v1().getFileDownloadURl(297028, 3432688));
    }

}
