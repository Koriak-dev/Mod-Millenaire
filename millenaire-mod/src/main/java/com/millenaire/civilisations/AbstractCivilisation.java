package com.millenaire.civilisations;

import com.millenaire.core.ModConstants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public abstract class AbstractCivilisation {
    private final String id;
    private final String name;
    private boolean discovered = false;
    private ResourceLocation icon;

    public AbstractCivilisation(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isDiscovered() {
        return discovered;
    }

    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
    }

    public ResourceLocation getIcon() {
        return icon;
    }

    public void setIcon(ResourceLocation icon) {
        this.icon = icon;
    }

    public abstract ItemStack getVillageMarkerItem();

    public abstract String getLanguageCode();

    public String getTexturePrefix() {
        return ModConstants.TEXTURE_PATH + id + "/";
    }

    public String getModelPrefix() {
        return ModConstants.MODEL_PATH + id + "/";
    }
}
