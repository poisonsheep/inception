package io.github.poisonsheep.inception.mixin;

import io.github.poisonsheep.inception.potion.MobEffectRegistry;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;



@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity {
    @Shadow public abstract boolean hasEffect(MobEffect pEffect);

    @Inject(method = "stopSleeping" ,at = @At("HEAD"), cancellable = true)
    private void wakeUp(CallbackInfo ci) {
        if (this.hasEffect(MobEffectRegistry.DROWSY.get())) {
            ci.cancel();
        }
    }
}
