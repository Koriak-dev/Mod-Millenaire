/**
 * FICHIER: VillageMarkerBlock.java
 * DESCRIPTION: Bloc marqueur invisible pour les villages
 * CARACTERISTIQUES:
 * - Forme verticale (4x4x16 pixels)
 * - Transmet la lumière du ciel
 * - Utilisé pour marquer le centre des villages
 */
package com.millenaire.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import javax.annotation.Nonnull;

public class VillageMarkerBlock extends Block {
    private static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 16, 12);

    public VillageMarkerBlock(Properties properties) {
        super(properties);
    }

    @Override
    /**
     * Retourne la forme verticale du marqueur (pilier)
     * @return VoxelShape de 8x8x16 pixels
     */
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull BlockGetter world, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        return SHAPE;
    }

    @Override
    /**
     * Permet à la lumière du ciel de passer à travers le bloc
     * @return Toujours true pour ce bloc invisible
     */
    public boolean propagatesSkylightDown(@Nonnull BlockState state, @Nonnull BlockGetter reader, @Nonnull BlockPos pos) {
        return true;
    }
}
