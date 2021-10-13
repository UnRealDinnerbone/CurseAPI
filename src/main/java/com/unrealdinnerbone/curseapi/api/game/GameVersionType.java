package com.unrealdinnerbone.curseapi.api.game;

import java.util.Optional;

public record GameVersionType(int id, int gameId, String game, Optional<String> name, String slug) {
}
