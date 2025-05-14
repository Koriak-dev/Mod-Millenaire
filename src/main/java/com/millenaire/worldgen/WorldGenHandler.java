package com.millenaire.worldgen;

import com.millenaire.civilisations.AbstractCivilisation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class WorldGenHandler {
    @SubscribeEvent
    public static void onWorldLoad(LevelEvent.Load event) {
        // Handle civilisation-specific world generation
    }

    private static boolean isValidForCivilisation(AbstractCivilisation civilisation) {
        // Check if civilisation should generate in this world
        return true;
    }

    private static void addCivilisationFeatures(AbstractCivilisation civilisation) {
        // Add civilisation features to world
    }
}
