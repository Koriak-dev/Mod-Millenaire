package com.millenaire.civilisations.village;

import com.millenaire.civilisations.AbstractCivilisation;
import com.millenaire.economy.EconomyManager;
import com.millenaire.interactions.*;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public abstract class AbstractVillage {
    protected final AbstractCivilisation civilisation;
    protected final Level level;
    protected final BlockPos centerPos;
    
    protected final EconomyManager economyManager;
    protected final QuestSystem questSystem;
    protected final NPCInteractionManager interactionManager;
    protected final ReputationSystem reputationSystem;

    protected int population;
    protected int size;

    public AbstractVillage(AbstractCivilisation civilisation, Level level, BlockPos centerPos) {
        this.civilisation = civilisation;
        this.level = level;
        this.centerPos = centerPos;
        
        this.economyManager = new EconomyManager(this);
        this.questSystem = new QuestSystem(this);
        this.interactionManager = new NPCInteractionManager(this);
        this.reputationSystem = new ReputationSystem(this);
        
        this.population = 10; // Starting population
        this.size = 1; // Starting size level
    }

    public AbstractCivilisation getCivilisation() {
        return civilisation;
    }

    public Level getLevel() {
        return level;
    }

    public BlockPos getCenterPos() {
        return centerPos;
    }

    public int getPopulation() {
        return population;
    }

    public int getSize() {
        return size;
    }

    public EconomyManager getEconomyManager() {
        return economyManager;
    }

    public QuestSystem getQuestSystem() {
        return questSystem;
    }

    public NPCInteractionManager getInteractionManager() {
        return interactionManager;
    }

    public ReputationSystem getReputationSystem() {
        return reputationSystem;
    }

    public abstract void tick();
    public abstract void updateVillageData();
    public abstract void expand();
}
