package com.millenaire.util;

import net.minecraftforge.fml.ModList;

public class CompatibilityManager {
    private static boolean isJeiLoaded;
    private static boolean isPatchouliLoaded;
    private static boolean isCuriosLoaded;

    public static void checkCompatibilities() {
        isJeiLoaded = ModList.get().isLoaded("jei");
        isPatchouliLoaded = ModList.get().isLoaded("patchouli");
        isCuriosLoaded = ModList.get().isLoaded("curios");

        LogHelper.debug("JEI loaded: " + isJeiLoaded);
        LogHelper.debug("Patchouli loaded: " + isPatchouliLoaded);
        LogHelper.debug("Curios loaded: " + isCuriosLoaded);
    }

    public static boolean isJeiLoaded() {
        return isJeiLoaded;
    }

    public static boolean isPatchouliLoaded() {
        return isPatchouliLoaded;
    }

    public static boolean isCuriosLoaded() {
        return isCuriosLoaded;
    }
}
