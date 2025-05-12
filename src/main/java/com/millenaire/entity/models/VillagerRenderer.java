package com.millenaire.entity.models;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import com.millenaire.entity.VillagerEntity;

public class VillagerRenderer extends MobRenderer<VillagerEntity, NPCModel<VillagerEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("millenaire", "textures/entity/villager.png");

    public VillagerRenderer(EntityRendererProvider.Context context) {
        super(context, new NPCModel<>(context.bakeLayer(ModelLayers.VILLAGER)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(VillagerEntity entity) {
        return TEXTURE;
    }
}
