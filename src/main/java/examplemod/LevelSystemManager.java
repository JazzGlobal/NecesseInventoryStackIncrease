package examplemod;

import examplemod.playermob.LevelSystem;
import examplemod.playermob.PlayerLevelStats;

import java.util.ArrayList;

public class LevelSystemManager {
    ArrayList<PlayerLevelStats> registeredPlayerStats;
    LevelSystem levelSystem;

    public LevelSystemManager(LevelSystem levelSystem, ArrayList<PlayerLevelStats> registeredPlayerStats) {
        this.registeredPlayerStats = registeredPlayerStats;
        this.levelSystem = levelSystem;
    }

    public void giveExperience(PlayerLevelStats stats, int experienceAmount) {
        stats.giveExperience(experienceAmount, levelSystem.getExperienceForNextLevel(stats.getCurrentLevel()));
    }

    public void registerPlayerStats(PlayerLevelStats playerLevelStats) {
        registeredPlayerStats.add(playerLevelStats);
    }

    public String listPlayerStats() {
        String result = "";
        for(PlayerLevelStats stats : registeredPlayerStats) {
            result += stats;
        }
        return result;
    }

    public int getTotalRegisteredPlayers(){
        return registeredPlayerStats.size();
    }
}
