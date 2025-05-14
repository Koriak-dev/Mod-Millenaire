package com.millenaire.entity.renderer;

import com.millenaire.civilisations.japonais.JaponaisNPCEntity;
import com.millenaire.entity.models.NPCModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class JaponaisNPCRenderer extends MobRenderer<JaponaisNPCEntity, NPCModel<JaponaisNPCEntity>> {
    private static final ResourceLocation TEXTURE = 
        new ResourceLocation("millenaire", "textures/entity/japonais_npc.png");

    public JaponaisNPCRenderer(EntityRendererProvider.Context context) {
        super(context, new NPCModel<>(context.bakeLayer(NPCModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(JaponaisNPCEntity entity) {
        return TEXTURE;
    }
}
