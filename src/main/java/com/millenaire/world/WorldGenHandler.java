package com.millenaire.world;

import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class WorldGenHandler {
    @SubscribeEvent
    public static void onWorldLoad(LevelEvent.Load event) {
        // Handle world generation
    }
}
