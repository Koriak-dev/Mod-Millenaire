package com.millenaire.interactions;

import com.millenaire.civilisations.village.AbstractVillage;
import com.millenaire.civilisations.quest.Quest;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class QuestSystem {
    private final AbstractVillage village;
    private final List<Quest> activeQuests = new ArrayList<>();
    private final List<Quest> completedQuests = new ArrayList<>();

    public QuestSystem(AbstractVillage village) {
        this.village = village;
    }

    public void offerNewQuests(Player player) {
        // Generate new quests based on village state and player reputation
    }

    public boolean acceptQuest(Player player, Quest quest) {
        if (!activeQuests.contains(quest)) {
            activeQuests.add(quest);
            return true;
        }
        return false;
    }

    public boolean completeQuest(Player player, Quest quest, ItemStack... items) {
        if (activeQuests.contains(quest) && quest.isComplete(player)) {
            activeQuests.remove(quest);
            completedQuests.add(quest);
            giveReward(player, quest);
            return true;
        }
        return false;
    }

    private void giveReward(Player player, Quest quest) {
        // Give player quest rewards
        player.addItem(quest.getReward());
        village.getReputationSystem().addReputation(
            player.getUUID(), 
            quest.getReputationReward()
        );
    }

    public void dailyUpdate() {
        // Check for expired quests
        activeQuests.removeIf(quest -> {
            if (quest.isExpired()) {
                quest.onExpire();
                return true;
            }
            return false;
        });
    }

    public List<Quest> getAvailableQuests() {
        return activeQuests;
    }
}
