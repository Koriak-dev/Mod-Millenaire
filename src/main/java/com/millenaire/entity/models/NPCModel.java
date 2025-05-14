/**
 * FICHIER: NPCModel.java
 * DESCRIPTION: Modèle 3D de base pour les PNJs
 * RESPONSABILITES:
 * - Définir la structure du modèle 3D
 * - Gérer les animations de base
 * - Servir de base aux modèles spécifiques
 */
package com.millenaire.entity.models;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class NPCModel<T extends LivingEntity> extends HumanoidModel<T> {
    /**
     * Layer location pour le modèle de PNJ
     * Utilisé par:
     * - Le chargement des assets
     * - Le rendu client
     * - La configuration des modèles
     */
    public static final ModelLayerLocation LAYER_LOCATION = 
        new ModelLayerLocation(new ResourceLocation("millenaire", "npc"), "main");
    
    /**
     * Constructeur du modèle de PNJ
     * @param root La racine du modèle (parties du corps)
     * Initialise le modèle avec:
     * - La hiérarchie des parties
     * - Les transformations par défaut
     * - Les animations de base
     */
    public NPCModel(ModelPart root) {
        super(root);
    }
    
    // Add custom model parts and animations here
}
