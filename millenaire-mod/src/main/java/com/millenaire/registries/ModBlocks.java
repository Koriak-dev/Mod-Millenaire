package com.millenaire.registries;

import com.millenaire.blocks.VillageMarkerBlock;
import com.millenaire.blocks.CivilisationAltar;
import com.millenaire.core.ModConstants;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, ModConstants.MOD_ID);

    public static final RegistryObject<Block> VILLAGE_MARKER = BLOCKS.register("village_marker",
        VillageMarkerBlock::new);
        
    public static final RegistryObject<Block> CIVILISATION_ALTAR = BLOCKS.register("civilisation_altar",
        CivilisationAltar::new);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
