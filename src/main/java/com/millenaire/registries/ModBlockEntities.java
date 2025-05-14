/**
 * FICHIER: ModBlockEntities.java
 * DESCRIPTION: Registre des block entities du mod Millénaire
 * RESPONSABILITES:
 * - Maintenir la liste de toutes les block entities du mod
 * - Enregistrer les block entities auprès de Minecraft
 * - Fournir un accès centralisé aux block entities
 */
package com.millenaire.registries;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockEntities {
    /**
     * Registre différé pour les block entities du mod.
     * Les block entities doivent être enregistrées via cette instance.
     */
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
        DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, "millenaire");

    // Les block entities du mod sont enregistrées ici via BLOCK_ENTITIES.register()
}
