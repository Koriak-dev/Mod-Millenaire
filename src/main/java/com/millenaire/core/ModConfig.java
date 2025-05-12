package com.millenaire.core;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> VILLAGE_SPAWN_DISTANCE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_CIVILISATIONS;
    public static final ForgeConfigSpec.ConfigValue<Double> TRADE_DISCOUNT;

    static {
        BUILDER.push("Millenaire Config");

        VILLAGE_SPAWN_DISTANCE = BUILDER
            .comment("Minimum distance between villages (in chunks)")
            .defineInRange("villageSpawnDistance", 10, 5, 50);

        ENABLE_CIVILISATIONS = BUILDER
            .comment("Enable all civilisations")
            .define("enableCivilisations", true);

        TRADE_DISCOUNT = BUILDER
            .comment("Base trade discount percentage")
            .defineInRange("tradeDiscount", 0.1, 0.0, 1.0);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
