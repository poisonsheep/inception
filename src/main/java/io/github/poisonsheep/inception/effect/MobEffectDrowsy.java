package io.github.poisonsheep.inception.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class MobEffectDrowsy extends MobEffect {

    public MobEffectDrowsy() {
        super(MobEffectCategory.NEUTRAL, 0X9B59B6);
    }


    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        // 这个方法决定了药水效果是否在每个tick都执行
        //duration单位应该是tick,我的世界1s是20tick
        return duration < 200;
    }
    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        // 这个方法是药水效果的具体逻辑
        if(amplifier >= 3){
            if(!entity.isSleeping()){
                BlockPos pos = entity.blockPosition();
                entity.startSleeping(pos);
                entity.setPos((double)pos.getX() + 0.5D, (double)pos.getY() + 0.6875D, (double)pos.getZ() + 0.5D);}
        }
    }
    @Override
    public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributes, int amplifier) {
        // 这个方法会在药水效果结束后被调用
        super.removeAttributeModifiers(entity, attributes, amplifier);
        entity.refreshDimensions();
    }
}
