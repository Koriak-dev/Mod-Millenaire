/**
 * FICHIER: CivilisationRegistry.java
 * DESCRIPTION: Registre central des civilisations
 * RESPONSABILITES:
 * - Enregistrement des civilisations
 * - Gestion des références
 * - Initialisation des civilisations par défaut
 */
package com.millenaire.civilisations;

import com.millenaire.civilisations.azteques.AztequeCivilisation;
import com.millenaire.civilisations.japonais.JaponaisCivilisation;
import com.millenaire.civilisations.normands.NormandCivilisation;

import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class CivilisationRegistry {
    // Map des civilisations enregistrées (ID -> Civilisation)
    private static final Map<ResourceLocation, AbstractCivilisation> CIVILISATIONS = new HashMap<>();

    /**
     * Enregistre une nouvelle civilisation
     * @param civilisation La civilisation à enregistrer
     */
    public static void registerCivilisation(AbstractCivilisation civilisation) {
        CIVILISATIONS.put(civilisation.getCivilisationId(), civilisation);
    }

    /**
     * Récupère une civilisation par son ID
     * @param id L'identifiant de la civilisation
     * @return La civilisation correspondante, ou null si non trouvée
     */
    public static AbstractCivilisation getCivilisation(ResourceLocation id) {
        return CIVILISATIONS.get(id);
    }

    /**
     * Enregistre les civilisations par défaut du mod
     * - Normands
     * - Aztèques
     * - Japonais
     */
    public static void registerDefaultCivilisations() {
        registerCivilisation(new NormandCivilisation());
        registerCivilisation(new AztequeCivilisation());
        registerCivilisation(new JaponaisCivilisation());
    }

    /**
     * @return Une liste de toutes les civilisations enregistrées
     */
    public static List<AbstractCivilisation> getCivilisations() {
        return new ArrayList<>(CIVILISATIONS.values());
    }
}
