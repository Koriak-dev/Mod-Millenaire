package com.millenaire.civilisations.azteques;

import com.millenaire.civilisations.AbstractCivilisation;
import com.millenaire.world.StructureGenerator;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public class AztequeStructureGenerator extends StructureGenerator {
    private final AztequeCivilisation civilisation;

    public AztequeStructureGenerator(AztequeCivilisation civilisation) {
        super(civilisation, "azteque");
        this.civilisation = civilisation;
    }

    @Override
    public void generateStructure(Level level, BlockPos pos) {
        // Implémentation spécifique aux structures aztèques
    }
}
