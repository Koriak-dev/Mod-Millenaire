package com.millenaire;

import com.millenaire.core.ModConfig;
import com.millenaire.core.ModConstants;
import com.millenaire.registries.ModBlocks;
import com.millenaire.registries.ModItems;
import com.millenaire.util.CompatibilityManager;
import com.millenaire.util.LogHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ModConstants.MOD_ID)
public class MillenaireMod {
    public MillenaireMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register registries
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);

        // Register setup method
        modEventBus.addListener(this::setup);

        // Register ourselves for server and other game events
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LogHelper.info("Initializing Millenaire Mod");
        CompatibilityManager.checkCompatibilities();
        
        // Network initialization would go here
    }
}
