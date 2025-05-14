/**
 * FICHIER: TranslationHelper.java
 * DESCRIPTION: Utilitaire de traduction pour le mod Millénaire
 * RESPONSABILITES:
 * - Fournir des méthodes simplifiées pour accéder aux traductions
 * - Standardiser les clés de traduction
 * - Centraliser la gestion des textes localisés
 */
package com.millenaire.util;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.resources.ResourceLocation;

public class TranslationHelper {
    /**
     * Récupère le nom traduit d'une civilisation
     * @param civilisationId L'identifiant de la civilisation
     * @return Le nom traduit de la civilisation
     */
    public static String getCivilisationName(ResourceLocation civilisationId) {
        return I18n.get("civilisation." + civilisationId.getNamespace() + "." + civilisationId.getPath());
    }

    /**
     * Récupère le type de village traduit
     * @param villageType Le type de village
     * @return Le type de village traduit
     */
    public static String getVillageTypeName(String villageType) {
        return I18n.get("village.type." + villageType);
    }

    /**
     * Récupère la description traduite d'un item
     * @param itemKey La clé de l'item
     * @return La description traduite de l'item
     */
    public static String getItemDescription(String itemKey) {
        return I18n.get("item." + itemKey + ".description");
    }

    /**
     * Récupère le nom traduit d'un bâtiment
     * @param buildingKey La clé du bâtiment
     * @return Le nom traduit du bâtiment
     */
    public static String getBuildingName(String buildingKey) {
        return I18n.get("building." + buildingKey);
    }
}
