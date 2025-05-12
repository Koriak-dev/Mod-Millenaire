package com.millenaire;

import com.millenaire.core.ModConfig;
import com.millenaire.core.ModConstants;
import com.millenaire.network.ModPacketHandler;
import com.millenaire.util.CompatibilityManager;
import com.millenaire.util.LogHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ModConstants.MOD_ID)
public class MillenaireMod {
    public MillenaireMod() {
        LogHelper.info("Initializing Millenaire Mod");
        
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register configuration
        ModConfig.register();
        
        // Initialize network
        ModPacketHandler.register();
        
        // Check for compatibility with other mods
        CompatibilityManager.checkCompatibilities();
        
        LogHelper.info("Millenaire Mod initialized successfully");
    }
}
