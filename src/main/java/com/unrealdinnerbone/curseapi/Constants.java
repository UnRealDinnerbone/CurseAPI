package com.unrealdinnerbone.curseapi;


public class Constants
{
    public static enum MinecraftSections {
        TEXTURE_PACKS(12),
        MODPACKS(4471),
        MODS(6),
        WORLDS(17);

        private final int sectionID;

        MinecraftSections(int sectionID) {
            this.sectionID = sectionID;
        }

        public int getSectionID() {
            return sectionID;
        }
    }
}
