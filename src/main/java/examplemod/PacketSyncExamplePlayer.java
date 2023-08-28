package examplemod;

import necesse.engine.network.NetworkPacket;
import necesse.engine.network.Packet;
import necesse.engine.network.client.Client;

public class PacketSyncExamplePlayer extends Packet {
    public PacketSyncExamplePlayer(ExamplePlayer examplePlayer) {
        super();

        // Write packet data here (e.g. the current and max mana of the player)
        // This is always sent from the server to the client
    }

    public PacketSyncExamplePlayer(byte[] data) {
        super(data);

        // Read packet data here (e.g. the current and max mana of the player)
        // This is always received from the server to the client
    }

    @Override
    public void processClient(NetworkPacket packet, Client client) {
        // Process packet data here (e.g. set the current and max mana of the player on the client-side cache)
    }
}
