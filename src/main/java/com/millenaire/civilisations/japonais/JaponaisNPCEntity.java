/**
 * FICHIER: JaponaisNPCEntity.java  
 * DESCRIPTION: Entité NPC pour la civilisation japonaise
 * RESPONSABILITES:
 * - Implémenter les comportements spécifiques aux NPC japonais
 * - Gérer les interactions culturelles
 * - Définir les caractéristiques des différentes professions
 */
package com.millenaire.civilisations.japonais;

import com.millenaire.entity.NPCEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

public class JaponaisNPCEntity extends NPCEntity {
    public JaponaisNPCEntity(EntityType<? extends NPCEntity> type, Level world) {
        super(type, world);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return NPCEntity.createAttributes()
            .add(Attributes.MAX_HEALTH, 20.0)
            .add(Attributes.MOVEMENT_SPEED, 0.25)
            .add(Attributes.ATTACK_DAMAGE, 2.0);
    }

    public String getCivilisation() {
        return "japonais";
    }

    public String getProfession() {
        // Types de PNJ japonais
        String[] professions = {
            "moine", "samurai", "artisan", "marchand", "geisha"
        };
        return professions[random.nextInt(professions.length)];
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        // Comportements spécifiques aux PNJ japonais
    }

    @Override
    public void aiStep() {
        super.aiStep();
        // Comportements spécifiques
    }
}
