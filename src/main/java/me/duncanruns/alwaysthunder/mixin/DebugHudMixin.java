package me.duncanruns.alwaysthunder.mixin;

import me.duncanruns.alwaysthunder.AlwaysThunder;
import net.minecraft.client.gui.hud.DebugHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(DebugHud.class)
public abstract class DebugHudMixin {
    @Inject(method = "getLeftText",at=@At("RETURN"))
    private void addF3TextMixin(CallbackInfoReturnable<List<String>> info){
        info.getReturnValue().add(AlwaysThunder.MOD_NAME+" v"+AlwaysThunder.VERSION+" by DuncanRuns");
    }
}
