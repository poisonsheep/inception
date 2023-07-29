package io.github.poisonsheep.inception.event;

import io.github.poisonsheep.inception.Inception;
import io.github.poisonsheep.inception.client.render.RenderSleepingPlayer;
import io.github.poisonsheep.inception.entity.EntitySleepingPlayer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
@Mod.EventBusSubscriber(modid = Inception.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEvent {
    public static EntityType<EntitySleepingPlayer> CORPSE_ENTITY_TYPE;
    @SubscribeEvent
    public void clientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(CORPSE_ENTITY_TYPE, RenderSleepingPlayer::new);
    }
}
