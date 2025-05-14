/**
 * FICHIER: CompatibilityManager.java
 * DESCRIPTION: Gestionnaire de compatibilité avec d'autres mods
 * RESPONSABILITES:
 * - Détecter la présence de mods tiers
 * - Fournir des méthodes pour vérifier les dépendances
 * - Logger l'état des compatibilités
 */
package com.millenaire.util;

import net.minecraftforge.fml.ModList;

public class CompatibilityManager {
    // États de compatibilité avec les mods tiers
    private static boolean isJeiLoaded;
    private static boolean isPatchouliLoaded;
    private static boolean isCuriosLoaded;

    /**
     * Vérifie la présence des mods tiers et met à jour les états de compatibilité
     */
    public static void checkCompatibilities() {
        isJeiLoaded = ModList.get().isLoaded("jei");
        isPatchouliLoaded = ModList.get().isLoaded("patchouli");
        isCuriosLoaded = ModList.get().isLoaded("curios");

        LogHelper.debug("JEI loaded: " + isJeiLoaded);
        LogHelper.debug("Patchouli loaded: " + isPatchouliLoaded);
        LogHelper.debug("Curios loaded: " + isCuriosLoaded);
    }

    /**
     * @return true si JEI est installé
     */
    public static boolean isJeiLoaded() {
        return isJeiLoaded;
    }

    /**
     * @return true si Patchouli est installé
     */
    public static boolean isPatchouliLoaded() {
        return isPatchouliLoaded;
    }

    /**
     * @return true si Curios est installé
     */
    public static boolean isCuriosLoaded() {
        return isCuriosLoaded;
    }
}
