package com.millenaire.entity.models;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;

public class NPCModel<T extends LivingEntity> extends HumanoidModel<T> {
    public NPCModel(ModelPart root) {
        super(root);
    }
    
    // Add custom model parts and animations here
}
