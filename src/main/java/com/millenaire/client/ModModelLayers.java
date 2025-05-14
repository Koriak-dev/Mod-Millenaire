/**
 * FICHIER: ModModelLayers.java
 * DESCRIPTION: Définit les layers de modèles 3D pour le rendu client
 * RESPONSABILITES:
 * - Centraliser les définitions de layers
 * - Fournir des références type-safe
 * - Garantir l'unicité des noms
 */
package com.millenaire.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    /**
     * Layer pour le modèle de villageois standard
     * Utilisé pour le rendu des villageois génériques
     */
    public static final ModelLayerLocation VILLAGER = new ModelLayerLocation(
        new ResourceLocation("millenaire", "villager"), "main");
        
    /**
     * Layer pour le modèle de PNJ générique
     * Utilisé pour le rendu des PNJs non-spécifiques
     */
    public static final ModelLayerLocation NPC = new ModelLayerLocation(
        new ResourceLocation("millenaire", "npc"), "main");
}
