package com.millenaire.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.Level;

public class NPCEntity extends PathfinderMob {
    public NPCEntity(EntityType<? extends PathfinderMob> type, Level world) {
        super(type, world);
    }

    // Add NPC-specific behavior here
}
