package com.unrealdinnerbone.curseapi.api.game;


public record GameFilesItem(int id, int gameId, boolean isRequired, String fileName, int fileType,
							int platformType) {

}