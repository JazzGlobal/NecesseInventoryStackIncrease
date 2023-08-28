package examplemod.playermob;

import examplemod.ExampleMod;
import necesse.engine.modLoader.annotations.ModConstructorPatch;
import necesse.engine.network.NetworkClient;
import necesse.entity.mobs.PlayerMob;
import net.bytebuddy.asm.Advice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@ModConstructorPatch(target = PlayerMob.class, arguments = { long.class, NetworkClient.class })
public class PlayerMobConstructorPatch {

    @Advice.OnMethodExit
    static void onExit(@Advice.This PlayerMob playerMob) {
        // TODO: Lookup server-side save file for player's experience.

        // For now, we're just going to new-up an instance of PlayerLevelStats
        PlayerLevelStats stats = new PlayerLevelStats(playerMob.getUniqueID(), 1);

        // Before attempting to register, validate the LevelSystemManager is not null and the current playerMob isn't some
        // entity we don't want to register.
        if (ExampleMod.levelSystemManager != null &&
                !playerMob.getDisplayName().equalsIgnoreCase("player0") &&
                !playerMob.getDisplayName().equalsIgnoreCase("player1"))
        {
            ExampleMod.levelSystemManager.registerPlayerStats(stats);

            if (ExampleMod.DEBUG)
                System.out.println("Registered " + playerMob.getUniqueID() + " to LevelSystemManager");
        }
    }
}
