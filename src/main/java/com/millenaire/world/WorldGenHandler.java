package com.millenaire.world;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class WorldGenHandler {
    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        // Handle world generation based on biome
    }
}
