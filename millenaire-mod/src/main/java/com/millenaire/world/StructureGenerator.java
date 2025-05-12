package com.millenaire.world;

import com.millenaire.civilisations.AbstractCivilisation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public abstract class StructureGenerator {
    protected final AbstractCivilisation civilisation;
    protected final String structureId;

    public StructureGenerator(AbstractCivilisation civilisation, String structureId) {
        this.civilisation = civilisation;
        this.structureId = structureId;
    }

    public abstract void generateStructure(Level world, BlockPos pos);

    protected void loadBuildingPlan() {
        // Charger le plan de construction depuis le fichier texte
    }

    protected void placeBlocks(Level world, BlockPos pos) {
        // Placer les blocs selon le plan chargé
    }
}
