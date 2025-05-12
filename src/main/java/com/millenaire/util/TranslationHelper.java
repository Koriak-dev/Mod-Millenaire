package com.millenaire.util;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.resources.ResourceLocation;

public class TranslationHelper {
    public static String getCivilisationName(ResourceLocation civilisationId) {
        return I18n.get("civilisation." + civilisationId.getNamespace() + "." + civilisationId.getPath());
    }

    public static String getVillageTypeName(String villageType) {
        return I18n.get("village.type." + villageType);
    }

    public static String getItemDescription(String itemKey) {
        return I18n.get("item." + itemKey + ".description");
    }

    public static String getBuildingName(String buildingKey) {
        return I18n.get("building." + buildingKey);
    }
}
