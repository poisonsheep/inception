package io.github.poisonsheep.inception.potion;

import io.github.poisonsheep.inception.Inception;
import io.github.poisonsheep.inception.effect.MobEffectDrowsy;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MobEffectRegistry {
    public static final DeferredRegister<MobEffect> EFFECT = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Inception.MODID);

    public static final RegistryObject<MobEffect> DROWSY = EFFECT.register("drowsy", () -> new MobEffectDrowsy());
}
