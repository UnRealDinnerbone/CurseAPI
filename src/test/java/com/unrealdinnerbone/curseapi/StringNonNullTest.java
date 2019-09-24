package com.unrealdinnerbone.curseapi;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class StringNonNullTest {

    @Test
    public void testGetAddonDescription() {
        test(CurseAPI.getAddonDescription(238222));
    }

    @Test
    public void testGetAddonFileChangelog() {
        test(CurseAPI.getAddonFileChangelog(238222, 2682936));
    }

    @Test
    public void testGetAddonFileDownload() {
        test(CurseAPI.getAddonFileDownloadURL(238222, 2682936));
    }

    public void testTime() {
        test(CurseAPI.getCategoryTimestamp());
        test(CurseAPI.getGameTimestamp());
        test(CurseAPI.getAddonDatabaseTimestamp());
        test(CurseAPI.getMinecraftVersionTimestamp());
        test(CurseAPI.getModLoaderTimestamp());

    }
    private void test(String value) {
        Assert.assertNotNull(value);
        log.debug(value);
    }
}
