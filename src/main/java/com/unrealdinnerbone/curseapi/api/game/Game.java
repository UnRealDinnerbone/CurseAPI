package com.unrealdinnerbone.curseapi.api.game;

import java.util.List;

public class Game {

	private int id;
	private String name;
	private String slug;
	private String dateModified;
	private List<GameFilesItem> gameFiles;
	private List<GameDetectionHintsItem> gameDetectionHints;
	private List<FileParsingRule> fileParsingRules;
	private List<CategorySectionsItem> categorySections;
	private int maxFreeStorage;
	private int maxPremiumStorage;
	private int maxFileSize;
	private Object addonSettingsFolderFilter;
	private Object addonSettingsStartingFolder;
	private Object addonSettingsFileFilter;
	private Object addonSettingsFileRemovalFilter;
	private boolean supportsAddons;
	private boolean supportsPartnerAddons;
	private int supportedClientConfiguration;
	private boolean supportsNotifications;
	private int profilerAddonId;
	private int twitchGameId;
	private int clientGameSettingsId;
}