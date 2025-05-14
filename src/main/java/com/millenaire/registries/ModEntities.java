package com.millenaire.registries;

import com.millenaire.civilisations.japonais.JaponaisNPCEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
        DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "millenaire");

    public static final RegistryObject<EntityType<JaponaisNPCEntity>> JAPONAIS_NPC = ENTITIES.register("japonais_npc",
        () -> EntityType.Builder.of(JaponaisNPCEntity::new, MobCategory.CREATURE)
            .sized(0.6f, 1.8f)
            .build("japonais_npc"));
}
