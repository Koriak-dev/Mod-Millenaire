/**
 * FICHIER: ModBlocks.java
 * DESCRIPTION: Registre des blocs du mod Millénaire
 * RESPONSABILITES:
 * - Maintenir la liste de tous les blocs du mod
 * - Enregistrer les blocs auprès de Minecraft
 * - Fournir un accès centralisé aux blocs
 */
package com.millenaire.registries;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    /**
     * Registre différé pour les blocs du mod.
     * Les blocs doivent être enregistrés via cette instance.
     */
    public static final DeferredRegister<Block> BLOCKS = 
        DeferredRegister.create(ForgeRegistries.BLOCKS, "millenaire");

    // Blocs aztèques
    public static final RegistryObject<Block> AZTEC_STONE_BLOCK = BLOCKS.register("aztec_stone_block", 
        () -> new Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .strength(2.0f, 6.0f)
            .requiresCorrectToolForDrops()));
            
    public static final RegistryObject<Block> SACRIFICIAL_ALTAR = BLOCKS.register("sacrificial_altar",
        () -> new Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .strength(3.0f, 10.0f)
            .lightLevel(state -> 5)
            .requiresCorrectToolForDrops()));
}
