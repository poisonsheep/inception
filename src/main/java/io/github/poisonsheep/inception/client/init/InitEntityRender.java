package io.github.poisonsheep.inception.client.init;


import io.github.poisonsheep.inception.Inception;
import io.github.poisonsheep.inception.entity.EntityRegistry;
import io.github.poisonsheep.inception.entity.EntitySleepingPlayer;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Inception.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class InitEntityRender {
    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent event){
        event.put(EntityRegistry.SLEEPING_PLAYER.get(), EntitySleepingPlayer.prepareAttributes().build());
    }


}
