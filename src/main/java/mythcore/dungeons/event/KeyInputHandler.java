package mythcore.dungeons.event;

import mythcore.dungeons.DungeonsRPG;
import mythcore.dungeons.screen.StatScreen;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    private static final String KEY_CATEGORY_DUNGEONS = "key.category.dungeonsrpg.dungeonsrpg";
    private static final String KEY_OPEN_STATS = "key.dungeonsrpg.open_stats";

    public static KeyBinding statKey;

    public static void registerKeyInputs () {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            Object player = null;
            if(statKey.wasPressed()) {
                DungeonsRPG.LOGGER.info("Stat Key Pressed");
                // Check if the client and current screen are not null to avoid opening the screen in unintended situations
                if (client != null && client.player != null && client.currentScreen == null) {
                    client.setScreen(new StatScreen());
                }
            }
        });
    }
    public static void register() {
        statKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_OPEN_STATS,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_Z,
                KEY_CATEGORY_DUNGEONS
        ));


        registerKeyInputs();
    }

}
