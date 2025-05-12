package com.millenaire.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class VillageMapItem extends Item {
    public VillageMapItem() {
        super(new Item.Properties()
            .stacksTo(1)
            .rarity(Rarity.RARE));
    }
}
