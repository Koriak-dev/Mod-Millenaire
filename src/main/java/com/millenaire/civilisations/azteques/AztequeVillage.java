package com.millenaire.civilisations.azteques;

import com.millenaire.civilisations.AbstractCivilisation;
import com.millenaire.civilisations.village.AbstractVillage;
import com.millenaire.civilisations.village.VillageData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class AztequeVillage extends AbstractVillage {
    private final VillageData villageData;
    private final AztequeCivilisation civilisation;

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

    public void generateStructures() {
        BlockPos center = villageData.getCenterPos();
        Level level = civilisation.getWorld();
        
        generatePyramid(level, center);
        
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BlockPos templePos = center.relative(direction, 15);
            generateTemple(level, templePos, direction);
        }
        
        generateHouses(level, center);
    }
    
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
