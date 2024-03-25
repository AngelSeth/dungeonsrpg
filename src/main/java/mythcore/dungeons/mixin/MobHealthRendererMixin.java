package mythcore.dungeons.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class MobHealthRendererMixin {
    @Shadow public abstract float getHealth();

    @Shadow public abstract float getMaxHealth();

    @Inject(at = @At("TAIL"), method = "tick")
    private void healthBar(CallbackInfo info) {
        int mobHP = (int) this.getHealth();
        int mobMaxHealth = (int) this.getMaxHealth();
        final Entity cameraEntity = MinecraftClient.getInstance().getCameraEntity();
        //if (cameraEntity != null){
        //    cameraEntity.getWorld().addParticle(new Textp);
        //}
    }
}