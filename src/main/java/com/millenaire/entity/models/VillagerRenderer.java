/**
 * FICHIER: VillagerRenderer.java
 * DESCRIPTION: Rendu des villageois dans le jeu
 * RESPONSABILITES:
 * - Charger et appliquer les textures des villageois
 * - Gérer l'affichage 3D des modèles
 * - Adapter le rendu selon le type de villageois
 */
package com.millenaire.entity.models;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import com.millenaire.client.ModModelLayers;
import com.millenaire.entity.VillagerEntity;
import javax.annotation.Nonnull;

public class VillagerRenderer extends MobRenderer<VillagerEntity, NPCModel<VillagerEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("millenaire", "textures/entity/villager.png");

    /**
     * Constructeur du renderer de villageois
     * @param context Le contexte de rendu fourni par Minecraft
     */
    public VillagerRenderer(EntityRendererProvider.Context context) {
        super(context, new NPCModel<>(context.bakeLayer(ModModelLayers.VILLAGER)), 0.5F);
    }

    /**
     * Obtient la texture à appliquer au villageois
     * @param entity Le villageois à rendre (non null)
     * @return L'emplacement de la ressource texture
     */
    @Override
    public ResourceLocation getTextureLocation(@Nonnull VillagerEntity entity) {
        return TEXTURE; // Retourne la texture de base des villageois
    }
}
