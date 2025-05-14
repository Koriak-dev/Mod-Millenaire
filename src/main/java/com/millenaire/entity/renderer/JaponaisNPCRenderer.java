/**
 * FICHIER: JaponaisNPCRenderer.java
 * DESCRIPTION: Renderer spécifique pour les PNJs japonais
 * RESPONSABILITES:
 * - Gérer le rendu visuel des PNJs japonais
 * - Charger la texture appropriée
 * - Appliquer le modèle 3D
 */
package com.millenaire.entity.renderer;

import com.millenaire.civilisations.japonais.JaponaisNPCEntity;
import com.millenaire.entity.models.NPCModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import javax.annotation.Nonnull;

public class JaponaisNPCRenderer extends MobRenderer<JaponaisNPCEntity, NPCModel<JaponaisNPCEntity>> {
    /**
     * Chemin vers la texture des PNJs japonais
     * Format: textures/entity/japonais_npc.png
     * Contient:
     * - Diffuse map (couleur)
     * - Normal map (optionnelle)
     */
    private static final ResourceLocation TEXTURE = 
        new ResourceLocation("millenaire", "textures/entity/japonais_npc.png");

    public JaponaisNPCRenderer(EntityRendererProvider.Context context) {
        super(context, new NPCModel<>(context.bakeLayer(NPCModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    /**
     * Retourne la texture à utiliser pour le rendu
     * @param entity L'entité PNJ à render
     * @return ResourceLocation pointant vers la texture japonaise
     * Note: La même texture est utilisée pour tous les PNJs japonais
     */
    public ResourceLocation getTextureLocation(@Nonnull JaponaisNPCEntity entity) {
        return TEXTURE;
    }
}
