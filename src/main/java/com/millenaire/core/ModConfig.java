/**
 * FICHIER: ModConfig.java
 * DESCRIPTION: Configuration principale du mod Millénaire
 * PARAMETRES:
 * - Distance d'apparition des villages
 * - Activation des civilisations  
 * - Paramètres économiques
 */
/**
 * FICHIER: ModConfig.java
 * DESCRIPTION: Configuration principale du mod
 * RESPONSABILITES:
 * - Gérer la configuration utilisateur
 * - Charger/sauvegarder les paramètres
 * - Fournir un accès centralisé aux options
 */
package com.millenaire.core;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Distance minimale entre les villages (en chunks)
    /**
     * Distance minimale entre les villages (en chunks)
     * Valeur par défaut: 10
     * Plage: 5-50 chunks
     */
    public static final ForgeConfigSpec.ConfigValue<Integer> VILLAGE_SPAWN_DISTANCE;
    
    // Active/désactive toutes les civilisations
    /**
     * Active/désactive toutes les civilisations
     * Valeur par défaut: true
     * Impacte:
     * - Génération des villages
     * - Apparition des PNJs
     * - Système économique
     */
    public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_CIVILISATIONS;
    
    // Pourcentage de réduction sur les échanges  
    /**
     * Pourcentage de réduction sur les échanges
     * Valeur par défaut: 0.1 (10%)
     * Plage: 0.0-1.0 (0-100%)
     * Impacte:
     * - Prix des échanges avec les villages
     * - Économie globale
     */
    public static final ForgeConfigSpec.ConfigValue<Double> TRADE_DISCOUNT;

    static {
        BUILDER.push("Configuration Millénaire");

        VILLAGE_SPAWN_DISTANCE = BUILDER
            .comment("Distance minimale entre les villages (en chunks)")
            .defineInRange("villageSpawnDistance", 10, 5, 50);

        ENABLE_CIVILISATIONS = BUILDER
            .comment("Active toutes les civilisations")
            .define("enableCivilisations", true);

        TRADE_DISCOUNT = BUILDER
            .comment("Pourcentage de réduction de base pour les échanges")
            .defineInRange("tradeDiscount", 0.1, 0.0, 1.0);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
