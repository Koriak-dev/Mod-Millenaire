package com.millenaire.util;

import net.minecraftforge.fml.ModList;

public class CompatibilityManager {
    public static boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    public static void checkCompatibilities() {
        // Check for common compatibility mods
        if (isModLoaded("jei")) {
            LogHelper.info("Just Enough Items detected - enabling JEI integration");
        }
        if (isModLoaded("jade")) {
            LogHelper.info("Jade detected - enabling entity tooltips");
        }
        if (isModLoaded("journeymap")) {
            LogHelper.info("JourneyMap detected - enabling village markers");
        }
    }
}
