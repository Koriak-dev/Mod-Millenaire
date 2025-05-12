package com.millenaire.civilisations;

import com.millenaire.core.ModConstants;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class CivilisationRegistry {
    private static final Map<String, AbstractCivilisation> CIVILISATIONS = new HashMap<>();

    public static void registerCivilisation(AbstractCivilisation civilisation) {
        CIVILISATIONS.put(civilisation.getId(), civilisation);
        LogHelper.info("Registered civilisation: " + civilisation.getName());
    }

    public static AbstractCivilisation getCivilisation(String id) {
        return CIVILISATIONS.get(id);
    }

    public static void registerDefaultCivilisations() {
        // Normand civilisation
        NormandCivilisation normand = new NormandCivilisation();
        normand.setIcon(new ResourceLocation(ModConstants.MOD_ID, "textures/items/normand_icon.png"));
        registerCivilisation(normand);

        // Aztec civilisation
        AztequeCivilisation aztec = new AztequeCivilisation();
        aztec.setIcon(new ResourceLocation(ModConstants.MOD_ID, "textures/items/aztec_icon.png"));
        registerCivilisation(aztec);

        // Japanese civilisation
        JaponaisCivilisation japanese = new JaponaisCivilisation();
        japanese.setIcon(new ResourceLocation(ModConstants.MOD_ID, "textures/items/japanese_icon.png"));
        registerCivilisation(japanese);
    }

    public static Map<String, AbstractCivilisation> getCivilisations() {
        return new HashMap<>(CIVILISATIONS);
    }
}
