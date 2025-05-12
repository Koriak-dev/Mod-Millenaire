package com.millenaire.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class CivilisationScrollItem extends Item {
    public CivilisationScrollItem() {
        super(new Item.Properties()
            .stacksTo(1)
            .rarity(Rarity.UNCOMMON));
    }
}
