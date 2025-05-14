/**
 * FICHIER: AztequeNPCEntity.java  
 * DESCRIPTION: Entité NPC pour la civilisation aztèque
 * RESPONSABILITES:
 * - Implémenter les comportements spécifiques aux NPC aztèques
 * - Gérer les interactions culturelles
 * - Définir les caractéristiques des différentes professions
 */
package com.millenaire.civilisations.azteques;

import com.millenaire.entity.NPCEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

public class AztequeNPCEntity extends NPCEntity {
    public AztequeNPCEntity(EntityType<? extends NPCEntity> type, Level world) {
        super(type, world);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return NPCEntity.createAttributes()
            .add(Attributes.MAX_HEALTH, 22.0)  // Plus résistants
            .add(Attributes.MOVEMENT_SPEED, 0.23)
            .add(Attributes.ATTACK_DAMAGE, 3.0);  // Plus guerriers
    }

    public String getCivilisation() {
        return "azteque";
    }

    public String getProfession() {
        String[] professions = {
            "pretre", "guerrier_jaguar", "artisan", "marchand", "agriculteur"
        };
        return professions[random.nextInt(professions.length)];
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        // Comportements spécifiques aux Aztèques
    }
}
