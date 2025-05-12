package com.millenaire.core;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> VILLAGE_SPAWN_DISTANCE;
    public static final ForgeConfigSpec.ConfigValue<Double> REPUTATION_GAIN_MULTIPLIER;

    static {
        BUILDER.push("Millenaire Config");

        VILLAGE_SPAWN_DISTANCE = BUILDER
            .comment("Minimum distance between villages (in chunks)")
            .defineInRange("villageSpawnDistance", ModConstants.DEFAULT_VILLAGE_SPAWN_DISTANCE, 5, 50);

        REPUTATION_GAIN_MULTIPLIER = BUILDER
            .comment("Multiplier for reputation gain rates")
            .defineInRange("reputationGain", ModConstants.DEFAULT_REPUTATION_GAIN, 0.1, 5.0);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }

    public static void register() {
        // Config will be automatically registered by Forge
    }
}
