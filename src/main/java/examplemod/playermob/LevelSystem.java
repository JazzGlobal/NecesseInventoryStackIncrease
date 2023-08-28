package examplemod.playermob;

public class LevelSystem {
    protected int baseExperience = 100;
    protected double experienceMultiplier = 1.25;

    // (currentLevel * baseExperience)^experienceMultiplier.
    public int getExperienceForNextLevel(int currentLevel) {
        return (int)Math.pow(currentLevel * baseExperience, experienceMultiplier);
    }

    // currentLevel = ExperienceNeeded^(1 / ExperienceMultiplier) / BaseExperience
    public int getLevelFromTotalExperience(PlayerLevelStats stats) {
        return (int)Math.pow(getExperienceForNextLevel(stats.getCurrentLevel()), (1 / experienceMultiplier)) / baseExperience;
    }
}

class LinearLevelSystem extends LevelSystem {
    @Override
    public int getExperienceForNextLevel(int currentLevel) {
        return baseExperience + 100 * currentLevel;
    }

    public void myfunction() {
        LevelSystem mylevelsystem = (LevelSystem) this;
    }
}