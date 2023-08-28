package examplemod.playermob;

import java.io.FileNotFoundException;
import java.io.Serializable;

public class PlayerLevelStats implements Serializable {
    int uniqueId;
    public int currentLevel;
    public int currentExperience;

    public int getCurrentLevel() {
        return currentLevel;
    }

    public PlayerLevelStats(int currentLevel, int currentExperience){
        this.currentLevel = currentLevel;
        this.currentExperience = currentExperience;
    }

    public void giveExperience(int experienceAmount, int experienceNeededForLevelUp) {
        currentExperience += experienceAmount;
        if (currentExperience >= experienceNeededForLevelUp)
            this.currentLevel += 1;
    }

    // Overriding toString() method of String class
    @Override
    public String toString() {
        return "Unique ID: " + uniqueId +
                "\n" +
                "Current Level: " + currentLevel +
                "\n";
    }

    public static void SaveData() throws FileNotFoundException {

    }

//    public static PlayerLevelStats LoadData() throws FileNotFoundException {
//
//    }
}
