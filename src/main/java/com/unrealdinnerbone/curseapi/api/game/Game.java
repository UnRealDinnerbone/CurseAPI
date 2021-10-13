package com.unrealdinnerbone.curseapi.api.game;

import com.unrealdinnerbone.curseapi.api.core.CoreApiStatus;
import com.unrealdinnerbone.curseapi.api.core.CoreStatus;

public record Game(int id,
                   String name,
                   String slug,
                   String dateModified,
                   GameAssets assets,
                   CoreStatus status,
                   CoreApiStatus apiStatus) {}
