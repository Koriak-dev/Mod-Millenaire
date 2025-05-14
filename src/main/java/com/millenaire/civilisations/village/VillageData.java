/**
 * FICHIER: VillageData.java
 * DESCRIPTION: Stocke les données persistantes d'un village
 * RESPONSABILITES:
 * - Maintenir l'état du village (position, nom, civilisation)
 * - Sauvegarder/charger les données du village
 * - Fournir un accès thread-safe aux données
 */
package com.millenaire.civilisations.village;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.resources.ResourceLocation;
import com.millenaire.civilisations.AbstractCivilisation;
import com.millenaire.civilisations.CivilisationRegistry;
import net.minecraftforge.common.util.INBTSerializable;

public class VillageData implements INBTSerializable<CompoundTag> {
    private BlockPos centerPos;
    private String name;
    private AbstractCivilisation civilisation;

    public VillageData() {
        // For NBT deserialization
    }

    /**
     * Constructeur principal pour créer un nouveau village
     * @param centerPos Position centrale du village (coordonnées du point de spawn)
     * @param name Nom du village (doit être unique)
     * @param civilisation Référence à la civilisation propriétaire
     */
    public VillageData(BlockPos centerPos, String name, AbstractCivilisation civilisation) {
        this.centerPos = centerPos;
        this.name = name;
        this.civilisation = civilisation;
    }

    public BlockPos getCenterPos() {
        return centerPos;
    }

    public String getName() {
        return name;
    }

    public AbstractCivilisation getCivilisation() {
        return civilisation;
    }

    /**
     * Sérialise les données du village en NBT pour la sauvegarde
     * @return Un CompoundTag contenant toutes les données du village
     * Format du tag:
     * - centerPos: BlockPos (position centrale)
     * - name: String (nom du village)
     * - civilisationId: String (ID de la civilisation)
     */
    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.put("centerPos", NbtUtils.writeBlockPos(centerPos));
        tag.putString("name", name);
        tag.putString("civilisationId", civilisation.getCivilisationId().toString());
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        this.centerPos = NbtUtils.readBlockPos(tag.getCompound("centerPos"));
        this.name = tag.getString("name");
        ResourceLocation civId = new ResourceLocation(tag.getString("civilisationId"));
        this.civilisation = CivilisationRegistry.getCivilisation(civId);
        if (this.civilisation == null) {
            throw new IllegalStateException("Unknown civilisation ID: " + civId);
        }
    }
}
