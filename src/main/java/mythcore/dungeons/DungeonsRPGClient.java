package mythcore.dungeons;

import mythcore.dungeons.event.KeyInputHandler;
import net.fabricmc.api.ClientModInitializer;

public class DungeonsRPGClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();
    }
}
