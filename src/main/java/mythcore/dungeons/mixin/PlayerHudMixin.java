package mythcore.dungeons.mixin;

import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class PlayerHudMixin {
    @Inject(at = @At("HEAD"), method = "render(Lnet/minecraft/client/util/math/MatrixStack;F)V", cancellable = true)
    private void init(CallbackInfo info) {
        System.out.println("This line is printed by an example mod mixin!");
    }
}