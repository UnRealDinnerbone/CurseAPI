package com.unrealdinnerbone.curseapi.lib.json;

import com.squareup.moshi.Moshi;
import com.unrealdinnerbone.curseapi.api.core.CoreApiStatus;
import com.unrealdinnerbone.curseapi.api.core.CoreStatus;
import com.unrealdinnerbone.curseapi.api.file.FileRelation;
import com.unrealdinnerbone.curseapi.api.file.FileReleaseType;
import com.unrealdinnerbone.curseapi.api.file.FileStatus;
import com.unrealdinnerbone.curseapi.api.file.HashAlgo;
import com.unrealdinnerbone.curseapi.api.mod.ModLoaderType;
import com.unrealdinnerbone.curseapi.api.mod.ModStatus;
import dev.zacsweers.moshix.records.RecordsJsonAdapterFactory;

public class JsonUtil {
    public static final Moshi MOSHI = new Moshi.Builder().add(new RecordsJsonAdapterFactory())
            .add(FileReleaseType.class, EnumJsonAdapter.create(FileReleaseType.class))
            .add(FileStatus.class, EnumJsonAdapter.create(FileStatus.class))
            .add(HashAlgo.class, EnumJsonAdapter.create(HashAlgo.class))
            .add(FileRelation.class, EnumJsonAdapter.create(FileRelation.class))
            .add(CoreStatus.class, EnumJsonAdapter.create(CoreStatus.class))
            .add(CoreApiStatus.class, EnumJsonAdapter.create(CoreApiStatus.class))
            .add(ModStatus.class, EnumJsonAdapter.create(ModStatus.class))
            .add(ModLoaderType.class, EnumJsonAdapter.create(ModLoaderType.class))
            .add(new OptionalFactory())
            .build();
}
