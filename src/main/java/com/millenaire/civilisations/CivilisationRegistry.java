package com.millenaire.civilisations;

import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class CivilisationRegistry {
    private static final Map<ResourceLocation, AbstractCivilisation> CIVILISATIONS = new HashMap<>();

    public static void registerCivilisation(AbstractCivilisation civilisation) {
        CIVILISATIONS.put(civilisation.getCivilisationId(), civilisation);
    }

    public static AbstractCivilisation getCivilisation(ResourceLocation id) {
        return CIVILISATIONS.get(id);
    }

    public static void registerDefaultCivilisations() {
        registerCivilisation(new NormandCivilisation());
        registerCivilisation(new AztequeCivilisation());
        registerCivilisation(new JaponaisCivilisation());
    }
}
