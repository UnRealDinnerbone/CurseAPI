package com.unrealdinnerbone.curseapi;

import com.unrealdinnerbone.curseapi.lib.ReturnResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

public class JsonMatchTest
{
    @Test
    public void testAddon() {
        test(CurseAPI.getAddon(228525));
    }
    @Test
    public void testAddons() {
        test(CurseAPI.getAddons(new Integer[]{60089, 238222}));
    }
    @Test
    public void testAddonsFile() {
        test(CurseAPI.getAddonFileInfo(396803, 3035339));
    }

    @Test
    public void testMumurhash() {
        test(CurseAPI.getAddonsByFingerprint(new long[]{1053776633L}));
    }
    @Test
    public void testAddonsFiles() {
        test(CurseAPI.getAddonFiles(60089));
    }

    @Test
    public void testMinecraftVersionList() {
        test(CurseAPI.getMinecraftVersionsList());
    }
    @Test
    public void testMinecraftVersionInfo() {
        test(CurseAPI.getMinecraftVersionInfo("1.14.4"));
    }
    @Test
    public void testGetModLoaderList() {
        test(CurseAPI.getModLoaderList());
    }

    @Test
    public void testCategoryList() {
        test(CurseAPI.getCategoryList());
    }

    @Test
    public void testCatergoryListInfo() {
        test(CurseAPI.getCategoryListInfo(423));
    }

    @Test
    public void testGameListAddons() {
        test(CurseAPI.getGameList(true));
    }

    @Test
    public void testGameList() {
        test(CurseAPI.getGameList(false));
    }

    @Test
    public void testGetGameInfo() {
        test(CurseAPI.getGameInfo(432));
    }

    private void test(ReturnResult<?> returnResult) {
        Assert.assertNotNull(returnResult);
        Assert.assertNotNull(returnResult.getFormattedJson());
        Assert.assertNotNull(returnResult.get());
        Assert.assertNotNull(returnResult.getReformtedJson());
        Assert.assertNotNull(returnResult.getRawValue());
        System.out.println(returnResult.getFormattedJson());
        Assert.assertEquals(returnResult.getFormattedJson(), returnResult.getReformtedJson());
    }

}
