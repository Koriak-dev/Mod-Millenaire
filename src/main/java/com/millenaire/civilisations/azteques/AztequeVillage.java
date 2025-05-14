/**
 * FICHIER: AztequeVillage.java
 * DESCRIPTION: Implémentation du village aztèque
 * RESPONSABILITES:
 * - Génération des structures du village
 * - Mise à jour des bâtiments
 * - Gestion de l'expansion
 */
/**
 * FICHIER: AztequeVillage.java
 * DESCRIPTION: Implémentation du village aztèque
 * CARACTERISTIQUES:
 * - Pyramides centrales
 * - Maisons en adobe
 * - Jardins flottants (chinampas)
 * - Architecture mésoaméricaine
 */
package com.millenaire.civilisations.azteques;

import com.millenaire.civilisations.AbstractCivilisation;
import com.millenaire.civilisations.village.AbstractVillage;
import com.millenaire.civilisations.village.VillageData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class AztequeVillage extends AbstractVillage {
    // Données du village
    private final VillageData villageData;
    
    // Référence à la civilisation aztèque
    private final AztequeCivilisation civilisation;

    /**
     * Crée un nouveau village aztèque
     * @param villageData Les données du village
     * @param civilisation La civilisation associée
     */
    public AztequeVillage(VillageData villageData, AztequeCivilisation civilisation) {
        this.villageData = villageData;
        this.civilisation = civilisation;
    }

    @Override
    public String getName() {
        return villageData.getName();
    }

    @Override
    public BlockPos getCenterPos() {
        return villageData.getCenterPos();
    }

    @Override
    public AbstractCivilisation getCivilisation() {
        return civilisation;
    }

    /**
     * Génère les structures principales du village
     */
    public void generateStructures() {
        BlockPos center = villageData.getCenterPos();
        Level level = civilisation.getWorld();
        
        // 1. Générer la pyramide centrale
        generatePyramid(level, center);
        
        // 2. Générer les 4 temples cardinaux
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BlockPos templePos = center.relative(direction, 15);
            generateTemple(level, templePos, direction);
        }
        
        // 3. Générer les habitations
        generateHouses(level, center);
    }
    
    /**
     * Génère une pyramide aztèque
     * @param level Le monde Minecraft
     * @param pos Position centrale de la base
     */
    private void generatePyramid(Level level, BlockPos pos) {
        int height = 5;
        int baseSize = 7;
        
        for (int y = 0; y < height; y++) {
            int currentSize = baseSize - y;
            for (int x = -currentSize; x <= currentSize; x++) {
                for (int z = -currentSize; z <= currentSize; z++) {
                    if (Math.abs(x) == currentSize || Math.abs(z) == currentSize) {
                        level.setBlock(pos.offset(x, y, z), Blocks.STONE.defaultBlockState(), 3);
                    }
                }
            }
        }
    }

    /**
     * Génère un temple aztèque
     * @param level Le monde Minecraft
     * @param pos Position centrale du temple
     * @param facing Orientation du temple
     */
    private void generateTemple(Level level, BlockPos pos, Direction facing) {
        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                level.setBlock(pos.offset(x, 0, z), Blocks.STONE_BRICKS.defaultBlockState(), 3);
            }
        }
        
        for (int y = 1; y <= 3; y++) {
            level.setBlock(pos.offset(-2, y, -2), Blocks.STONE_BRICK_SLAB.defaultBlockState(), 3);
            level.setBlock(pos.offset(2, y, -2), Blocks.STONE_BRICK_SLAB.defaultBlockState(), 3);
            level.setBlock(pos.offset(-2, y, 2), Blocks.STONE_BRICK_SLAB.defaultBlockState(), 3);
            level.setBlock(pos.offset(2, y, 2), Blocks.STONE_BRICK_SLAB.defaultBlockState(), 3);
        }
        
        level.setBlock(pos.offset(0, 4, 0), Blocks.STONE_BRICK_STAIRS.defaultBlockState(), 3);
    }
    
    /**
     * Génère les habitations du village
     * @param level Le monde Minecraft
     * @param center Position centrale du village
     */
    private void generateHouses(Level level, BlockPos center) {
        for (int i = 0; i < 8; i++) {
            double angle = i * Math.PI / 4;
            int x = (int) (20 * Math.cos(angle));
            int z = (int) (20 * Math.sin(angle));
            
            BlockPos housePos = center.offset(x, 0, z);
            
            for (int dx = -1; dx <= 1; dx++) {
                for (int dz = -1; dz <= 1; dz++) {
                    level.setBlock(housePos.offset(dx, 0, dz), Blocks.COBBLESTONE.defaultBlockState(), 3);
                    if (dx == 0 && dz == 0) {
                        level.setBlock(housePos.offset(dx, 1, dz), Blocks.OAK_DOOR.defaultBlockState(), 3);
                    }
                }
            }
            
            level.setBlock(housePos.offset(0, 2, 0), Blocks.OAK_PLANKS.defaultBlockState(), 3);
        }
    }

    /**
     * Met à jour l'état du village
     * - Répare les structures endommagées
     * - Vérifie l'intégrité des bâtiments
     */
    public void update() {
        Level level = civilisation.getWorld();
        BlockPos center = villageData.getCenterPos();
        
        if (level.getBlockState(center).isAir()) {
            generatePyramid(level, center);
        }
        
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BlockPos templePos = center.relative(direction, 15);
            if (level.getBlockState(templePos).isAir()) {
                generateTemple(level, templePos, direction);
            }
        }
    }
}
