package com.millenaire.registries;

import com.millenaire.items.CivilisationScrollItem;
import com.millenaire.items.VillageMapItem;
import com.millenaire.core.ModConstants;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, ModConstants.MOD_ID);

    public static final RegistryObject<Item> CIVILISATION_SCROLL = ITEMS.register("civilisation_scroll",
        CivilisationScrollItem::new);
        
    public static final RegistryObject<Item> VILLAGE_MAP = ITEMS.register("village_map",
        VillageMapItem::new);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
