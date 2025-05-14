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
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    /**
     * Registre différé pour les blocs du mod.
     * Les blocs doivent être enregistrés via cette instance.
     */
    public static final DeferredRegister<Block> BLOCKS = 
        DeferredRegister.create(ForgeRegistries.BLOCKS, "millenaire");

    // Les blocs du mod sont enregistrés ici via BLOCKS.register()
}
