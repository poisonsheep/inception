package io.github.poisonsheep.inception.entity;

import io.github.poisonsheep.inception.Inception;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY = DeferredRegister.create(ForgeRegistries.ENTITIES, Inception.MODID);

    public static final RegistryObject<EntityType<EntitySleepingPlayer>> SLEEPING_PLAYER = ENTITY.register("sleeping_player",()-> EntityType.Builder.<EntitySleepingPlayer>of(io.github.poisonsheep.inception.entity.EntitySleepingPlayer::new, MobCategory.CREATURE).sized(1.0F,1.8F).build("sleeping_player"));

}
