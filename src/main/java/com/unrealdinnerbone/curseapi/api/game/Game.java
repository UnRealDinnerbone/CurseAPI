package com.unrealdinnerbone.curseapi.api.game;

import java.util.List;

public record Game(int id, String name, String slug, String dateModified,
				   List<GameFilesItem> gameFiles,
				   List<GameDetectionHintsItem> gameDetectionHints,
				   List<FileParsingRule> fileParsingRules,
				   List<CategorySectionsItem> categorySections,
				   int maxFreeStorage, int maxPremiumStorage, int maxFileSize,
				   Object addonSettingsFolderFilter, Object addonSettingsStartingFolder,
				   Object addonSettingsFileFilter, Object addonSettingsFileRemovalFilter,
				   boolean supportsAddons, boolean supportsPartnerAddons, int supportedClientConfiguration,
				   boolean supportsNotifications, int profilerAddonId, int twitchGameId, int clientGameSettingsId) {

}