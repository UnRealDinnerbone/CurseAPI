package com.unrealdinnerbone.curseapi.api.file;

import com.unrealdinnerbone.curseapi.lib.json.IID;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public enum HashAlgo implements IID
{
    SHA1("SHA-1", 1),
    MD5("MD5", 2),
    UNKNOWN("ERROR", -1),
    ;

    private final int id;
    private final String type;

    HashAlgo(String type, int id) {
        this.id = id;
        this.type = type;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getHash(Path path) throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance(getType());
        InputStream fis = Files.newInputStream(path);
        byte[] dataBytes = new byte[1024];
        int nread = 0;
        while ((nread = fis.read(dataBytes)) != -1) {
            md.update(dataBytes, 0, nread);
        }
        byte[] mdbytes = md.digest();
        StringBuilder sb = new StringBuilder("");
        for(byte mdbyte : mdbytes) {
            sb.append(Integer.toString((mdbyte & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}
