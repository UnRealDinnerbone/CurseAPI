package com.unrealdinnerbone.curseapi;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class Constants
{
    @Getter
    public static enum MinecraftSections {
        TEXTURE_PACKS(12),
        MODPACKS(4471),
        MODS(6),
        WORLDS(17);

        private final int sectionID;

        MinecraftSections(int sectionID) {
            this.sectionID = sectionID;
        }
    }
}
