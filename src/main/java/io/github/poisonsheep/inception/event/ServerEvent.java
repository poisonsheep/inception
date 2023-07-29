package io.github.poisonsheep.inception.event;

import io.github.poisonsheep.inception.Inception;
import io.github.poisonsheep.inception.config.ServerConfig;
import io.github.poisonsheep.inception.entity.EntitySleepingPlayer;
import io.github.poisonsheep.inception.potion.MobEffectRegistry;
import io.github.poisonsheep.inception.tag.ModTags;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Timer;
import java.util.TimerTask;

@Mod.EventBusSubscriber(modid = Inception.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ServerEvent {
    //梦到理想国度
    @SubscribeEvent
    public static void onPlayerSleep(PlayerSleepInBedEvent event){
        Player player = event.getPlayer();
        if(player.hasEffect(MobEffectRegistry.DROWSY.get())){
            ResourceKey<Level> dreamType = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(ServerConfig.DREAM_DIMENSION.get()));
            Dream dream = new Dream(player, dreamType);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    dream.execute();
                }
            },1000);
            player.level.addFreshEntity(EntitySleepingPlayer.createWhenSleeping(player));
        }
    }
    //死后坠落迷失域
    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        LivingEntity entity = event.getEntityLiving();
        if(entity instanceof Player) {
            Player player = (Player) entity;
            if (player.hasEffect(MobEffectRegistry.DROWSY.get()) && player.getEffect(MobEffectRegistry.DROWSY.get()).getAmplifier() == 3) {
                ResourceKey<Level> limboType = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(ServerConfig.LIMBO_DIMENSION.get()));
                //创建一个Dream对象，传入玩家实例和目标维度的资源键
                Dream dream = new Dream(player, limboType);
                //调用execute方法，传送玩家到目标维度
                dream.execute();
                //给玩家设置一些属性，让玩家恢复到正常状态
                event.setCanceled(true);
                player.setHealth(player.getMaxHealth()); //设置生命值为最大值
                player.getFoodData().setFoodLevel(20); //设置饥饿值为20
                player.removeAllEffects(); //移除所有药水效果}
            }
        }
    }
    //吃下具有镇定剂标签的食物，玩家的昏昏欲睡效果追加
    @SubscribeEvent
    public static void onItemUseFinish(LivingEntityUseItemEvent.Finish event) {
        LivingEntity entity = event.getEntityLiving();
        ItemStack stack = event.getItem();
        if (stack.is(ModTags.SEDATIVE)) {
            // the item has the sedative tag
            int duration = 600;
            int amplifier = entity.getEffect(MobEffectRegistry.DROWSY.get()) == null ? 0 : entity.getEffect(MobEffectRegistry.DROWSY.get()).getAmplifier() + 1; // increase the amplifier by one
            if (amplifier < 4) { // if the amplifier is less than 4, increase it by one
                entity.addEffect(new MobEffectInstance(MobEffectRegistry.DROWSY.get(), duration, amplifier));
                amplifier++;
            } else { // if the amplifier is 4 or more, add a nausea effect
                entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0));
                entity.addEffect(new MobEffectInstance(MobEffectRegistry.DROWSY.get(), duration, 3));
            }
        }
    }
}
