package com.millenaire.world.normands;

import com.millenaire.civilisations.normands.NormandCivilisation;
import com.millenaire.world.StructureGenerator;
import com.millenaire.world.BuildingPlan;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

import java.io.IOException;
import java.nio.file.Path;

public class NormandStructureGenerator extends StructureGenerator {
    private BuildingPlan buildingPlan;

    public NormandStructureGenerator(NormandCivilisation civilisation, String structureId) {
        super(civilisation, structureId);
    }

    @Override
    public void generateStructure(Level world, BlockPos pos) {
        try {
            loadBuildingPlan();
            placeBlocks(world, pos);
        } catch (IOException e) {
            civilisation.getLOGGER().error("Erreur lors du chargement du bâtiment " + structureId, e);
        }
    }

    @Override
    protected void loadBuildingPlan() throws IOException {
        Path buildingPath = civilisation.getCulturePath()
            .resolve("buildings")
            .resolve(structureId.split("_")[0]) // type de bâtiment
            .resolve(structureId + ".txt");
        
        buildingPlan = new BuildingPlan(buildingPath);
    }

    @Override
    protected void placeBlocks(Level world, BlockPos pos) {
        // Implémenter la logique de placement des blocs
        // selon le plan chargé dans buildingPlan
    }
}
