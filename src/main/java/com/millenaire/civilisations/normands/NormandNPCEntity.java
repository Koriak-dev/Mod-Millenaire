/**
 * FICHIER: NormandNPCEntity.java  
 * DESCRIPTION: Entité NPC pour la civilisation normande
 * RESPONSABILITES:
 * - Implémenter les comportements spécifiques aux NPC normands
 * - Gérer les interactions culturelles
 * - Définir les caractéristiques des différentes professions
 */
package com.millenaire.civilisations.normands;

import com.millenaire.entity.NPCEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

public class NormandNPCEntity extends NPCEntity {
    public NormandNPCEntity(EntityType<? extends NPCEntity> type, Level world) {
        super(type, world);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return NPCEntity.createAttributes()
            .add(Attributes.MAX_HEALTH, 20.0)
            .add(Attributes.MOVEMENT_SPEED, 0.22)
            .add(Attributes.ATTACK_DAMAGE, 4.0);
    }

    public String getCivilisation() {
        return "normand";
    }

    public String getProfession() {
        String[] professions = {
            "chevalier", "paysan", "forgeron", "pretre", "marchand"
        };
        return professions[random.nextInt(professions.length)];
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        // Comportements spécifiques aux Normands
    }
}
