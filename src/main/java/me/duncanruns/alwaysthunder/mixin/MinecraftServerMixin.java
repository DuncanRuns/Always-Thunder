package me.duncanruns.alwaysthunder.mixin;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.SaveProperties;
import net.minecraft.world.level.ServerWorldProperties;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BooleanSupplier;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {
    @Shadow
    @Final
    protected SaveProperties saveProperties;

    @Inject(method = "tick", at = @At("HEAD"))
    private void adjustThunderMixin(BooleanSupplier shouldKeepTicking, CallbackInfo ci) {
        ServerWorldProperties serverWorldProperties = saveProperties.getMainWorldProperties();
        serverWorldProperties.setThundering(serverWorldProperties.isRaining());
        serverWorldProperties.setThunderTime(serverWorldProperties.getRainTime());
    }
}
