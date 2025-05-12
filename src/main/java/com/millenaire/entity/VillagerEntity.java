package com.millenaire.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.level.Level;

public class VillagerEntity extends Villager {
    public VillagerEntity(EntityType<? extends Villager> type, Level world) {
        super(type, world);
    }

    // Add custom villager behavior here
}
