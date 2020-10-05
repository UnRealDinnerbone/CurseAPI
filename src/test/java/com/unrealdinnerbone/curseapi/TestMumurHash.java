package com.unrealdinnerbone.curseapi;

import com.unrealdinnerbone.curseapi.api.FingerprintMatch;
import com.unrealdinnerbone.curseapi.api.FingerprintResult;
import com.unrealdinnerbone.curseapi.api.addon.Addon;
import com.unrealdinnerbone.curseapi.lib.ReturnResult;
import com.unrealdinnerbone.unreallib.ArrayUtil;
import com.unrealdinnerbone.unreallib.file.FileHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;

public class TestMumurHash {
    @Test
    public void test() {
        for (File mods : FileHelper.getOrCreateFolder("mods").listFiles()) {
            if(mods.isFile()) {
                System.out.println(mods.getName() + " " + FileHelper.getFilesMurmurHash(mods));
                System.out.println(CurseAPI.getAddonsByFingerprint(new long[]{FileHelper.getFilesMurmurHash(mods)}).getFormattedJson());
            }
        }
    }

}
