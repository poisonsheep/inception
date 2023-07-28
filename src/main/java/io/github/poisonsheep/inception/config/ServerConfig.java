package io.github.poisonsheep.inception.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ServerConfig {
    public static ForgeConfigSpec SPEC;
    public static ForgeConfigSpec.ConfigValue<String> DREAM_DIMENSION;

    public static ForgeConfigSpec.ConfigValue<String> LIMBO_DIMENSION;


    static {
        ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
        BUILDER.push("configs for inception");
        DREAM_DIMENSION = BUILDER.comment("设置睡着后梦到的维度，默认末地").define("dream_dimension", "minecraft:the_end");
        LIMBO_DIMENSION = BUILDER.comment("设置死后后坠落的维度，默认地狱").define("limbo_dimension", "minecraft:the_nether");
        BUILDER.pop();
        SPEC= BUILDER.build();
    }
}
