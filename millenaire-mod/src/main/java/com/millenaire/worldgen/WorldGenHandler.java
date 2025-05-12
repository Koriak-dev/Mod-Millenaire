package com.millenaire.worldgen;

import com.millenaire.civilisations.CivilisationRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class WorldGenHandler {
    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        ResourceLocation biomeName = event.getName();
        if (biomeName == null) return;

        // Check biome tags to determine which civilisations can spawn here
        CivilisationRegistry.REGISTRY.getEntries().forEach(entry -> {
            AbstractCivilisation civilisation = entry.getValue();
            if (isBiomeValidForCivilisation(event, civilisation)) {
                addCivilisationFeatures(event, civilisation);
            }
        });
    }

    private static boolean isBiomeValidForCivilisation(BiomeLoadingEvent event, AbstractCivilisation civilisation) {
        // Check if biome matches civilisation's biome tags
        for (String tag : civilisation.getBiomeTags()) {
            if (event.getCategory().toString().equalsIgnoreCase(tag) || 
                event.getName().getPath().contains(tag)) {
                return true;
            }
        }
        return false;
    }

    private static void addCivilisationFeatures(BiomeLoadingEvent event, AbstractCivilisation civilisation) {
        // Add village generation feature for valid biomes
        ResourceKey<PlacedFeature> villageFeature = ResourceKey.create(
            Registry.PLACED_FEATURE_REGISTRY,
            new ResourceLocation(ModConstants.MOD_ID, civilisation.getId() + "_village")
        );

        event.getGeneration().addFeature(
            GenerationStep.Decoration.SURFACE_STRUCTURES,
            Holder.direct(villageFeature)
        );
    }
}
