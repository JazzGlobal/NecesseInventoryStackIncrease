package examplemod;

import com.jubiman.customdatalib.api.ClientTickable;
import com.jubiman.customdatalib.api.HUDDrawable;
import com.jubiman.customdatalib.api.Savable;
import com.jubiman.customdatalib.api.Syncable;
import com.jubiman.customdatalib.player.CustomPlayer;
import examplemod.playermob.PlayerLevelStats;
import necesse.engine.network.Packet;
import necesse.engine.network.client.Client;
import necesse.engine.save.LoadData;
import necesse.engine.save.SaveData;
import necesse.engine.tickManager.TickManager;
import necesse.entity.mobs.PlayerMob;

import java.awt.*;

/**
 * Example player that implements all currently available modules
 */
public class ExamplePlayer extends CustomPlayer implements HUDDrawable, ClientTickable, Savable, Syncable {
    PlayerLevelStats playerLevelStats;
    public ExamplePlayer(long auth) {
        super(auth);
    }

    @Override
    public void clientTick(Client client) {
        // Do client side ticking logic here (e.g. mana regeneration simulation)
    }

    @Override
    public void drawHUD(TickManager tickManager, PlayerMob playerMob, Rectangle renderBox) {
        // Draw HUD elements here (e.g. mana bar)
    }

    @Override
    public void addSaveData(SaveData save) {
        // Add save data here (e.g. mana or any other custom data)

        if (playerLevelStats != null) {
            save.addInt("experience", playerLevelStats.currentExperience);
            save.addInt("level", playerLevelStats.currentLevel);
        }
        else {
            save.addInt("experience", 100);
            save.addInt("level", 4);
        }


    }

    @Override
    public void loadEnter(LoadData data) {
        // Load data here that needs to be loaded before the rest of the player is loaded
        // (e.g. mana or any other custom data)
        if (data == null)
        {
            playerLevelStats = new PlayerLevelStats(1, 0);
            return;
        };
        Integer experience = data.getInt("experience");
        Integer level = data.getInt("level");
        playerLevelStats = new PlayerLevelStats(
                (level != null) ? level : 1,
                (experience != null) ? experience : 0
        );
    }

    @Override
    public void loadExit(LoadData data) {
        // Load data here that needs to be loaded after the rest of the player is loaded
        // (e.g. mana or any other custom data)
    }

    @Override
    public boolean isContinuousSync() {
        return false;
    }

    @Override
    public Packet getSyncPacket() {
        return new PacketSyncExamplePlayer(this);
    }
}
