package com.unrealdinnerbone.curseapi;

import com.unrealdinnerbone.curseapi.api.CurseAPI;
import com.unrealdinnerbone.curseapi.api.body.FeaturedModsRequestBody;
import com.unrealdinnerbone.curseapi.api.body.ModFilesRequestBody;
import com.unrealdinnerbone.curseapi.api.body.ModsByIdsListRequestBody;
import com.unrealdinnerbone.curseapi.lib.Query;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

public class CurseAPITest extends BaseTest
{
    public static final CurseAPI CURSE_API = new CurseAPI(System.getenv().getOrDefault("TEST_API_KEY", "FIX_ME"));

    @Test
    public void getGames() throws ExecutionException, InterruptedException, IOException {
        test(CURSE_API.v1().getGames());
    }

    @Test
    public void getGame() throws ExecutionException, InterruptedException, IOException {
        test(CURSE_API.v1().getGame(432));
    }


    @Test
    public void getGameVersions() throws ExecutionException, InterruptedException, IOException {
        test(CURSE_API.v1().getGameVersions(432));
    }

    @Test
    public void getCategories() throws ExecutionException, InterruptedException, IOException {
        test(CURSE_API.v1().getCategories( new Query.Category().setGameId(432)));
    }

    @Test
    public void searchMods() throws ExecutionException, InterruptedException, IOException {
        test(CURSE_API.v1().searchMods(new Query.Mod().gameId(432)));
    }


    @Test
    public void testGameVersionsTypes() throws ExecutionException, InterruptedException, IOException {
        test(CURSE_API.v1().getVersionTypes(432));
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
        test(CURSE_API.v1().getFeaturedMods(new FeaturedModsRequestBody(432, new ArrayList<>(), Optional.empty())));
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
