package examplemod;

import com.jubiman.customdatalib.player.CustomPlayersHandler;
import necesse.engine.network.server.Server;

public class ExamplePlayersHandler extends CustomPlayersHandler<ExamplePlayer> {
    /**
     * The name of the handler of this mod, best to use a defined constant like this
     * instead of a string literal everywhere, as you can easily change it later on or make mistakes.
     */
    public static final String name = "EXAMPLEPLAYERS";

    /**
     * Constructs the storage class for custom players
     */
    public ExamplePlayersHandler() {
        super(ExamplePlayer.class, name);
    }

    @Override
    public void serverTick(Server server) {
        // Make sure to always call super.serverTick(server) as otherwise the library's logic won't run
        // This is especially important if you have a syncable player, as it won't sync otherwise
        super.serverTick(server);

        // Implement your own logic here
        // Bla bla bla
    }
}