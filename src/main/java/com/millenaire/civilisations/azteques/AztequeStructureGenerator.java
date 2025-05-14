package com.millenaire.civilisations.azteques;

import com.millenaire.world.StructureGenerator;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public class AztequeStructureGenerator extends StructureGenerator {
    public AztequeStructureGenerator(AztequeCivilisation civilisation) {
        super(civilisation, "azteque");
    }

    @Override
    public void generateStructure(Level level, BlockPos pos) {
        // Implémentation spécifique aux structures aztèques
    }
}
