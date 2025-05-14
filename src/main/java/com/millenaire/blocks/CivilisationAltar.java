/**
 * FICHIER: CivilisationAltar.java
 * DESCRIPTION: Bloc autel pour les civilisations
 * FONCTIONNALITES:
 * - Représente le centre religieux d'une civilisation
 * - Forme spécifique (12 pixels de haut)
 * - Optimisé pour l'occlusion lumineuse
 */
package com.millenaire.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import javax.annotation.Nonnull;

public class CivilisationAltar extends Block {
    private static final VoxelShape SHAPE = Block.box(2, 0, 2, 14, 12, 14);

    /**
     * Constructeur de l'autel de civilisation
     * @param properties Propriétés du bloc (résistance, luminosité, etc.)
     */
    public CivilisationAltar(Properties properties) {
        super(properties);
    }

    @Override
    /**
     * Retourne la forme de collision de l'autel
     * @return VoxelShape de dimensions 12x12x12 pixels
     */
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull BlockGetter world, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        return SHAPE;
    }

    @Override
    /**
     * Définit que l'autel utilise sa forme pour l'occlusion lumineuse
     * @return Toujours true pour une occlusion précise
     */
    public boolean useShapeForLightOcclusion(@Nonnull BlockState state) {
        return true;
    }
}
