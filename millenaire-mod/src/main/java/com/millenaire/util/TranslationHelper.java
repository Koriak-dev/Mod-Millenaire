package com.millenaire.util;

import net.minecraft.client.resources.language.I18n;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TranslationHelper {
    @OnlyIn(Dist.CLIENT)
    public static String translate(String key) {
        return I18n.get(key);
    }

    public static String translate(String key, Object... args) {
        return String.format(translate(key), args);
    }
}
