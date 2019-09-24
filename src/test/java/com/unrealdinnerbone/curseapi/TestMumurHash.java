package com.unrealdinnerbone.curseapi;

import com.unrealdinnerbone.unreallib.file.FileHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
public class TestMumurHash
{
    @Test
    public void test() {
        File file = FileHelper.getOrCreateFolder("test");
        FileHelper.getFilesTypesInFolder(file, "jar").forEach(file1 -> {
            log.debug(FileHelper.getFilesMurmurHash(file1) + "");
        });

    }
}
