package io.github.poisonsheep.inception.util;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

import java.lang.reflect.Field;

public class PlayerUtils {
    public static byte getModel(Player player){
        try {
            Field dataPlayerModelCustomization = ObfuscationReflectionHelper.findField(Player.class, "f_36089_");
            return player.getEntityData().get((EntityDataAccessor<Byte>) dataPlayerModelCustomization.get(null));
        }catch (IllegalAccessException e){
            e.printStackTrace();
            return  0;
        }
    }
}
