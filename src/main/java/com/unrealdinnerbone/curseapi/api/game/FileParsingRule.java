package com.unrealdinnerbone.curseapi.api.game;

public record FileParsingRule(String commentStripPattern, String fileExtension,
                              String inclusionPattern, int gameId, int id) {
}
