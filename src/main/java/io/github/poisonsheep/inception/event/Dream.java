package io.github.poisonsheep.inception.event;

import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class Dream {
    private Player player;
    public ResourceKey<Level> destinationType;
    public ServerLevel nextLevel ;

    public Dream(Player player, ResourceKey<Level> destinationType) {
        this.player = player;
        this.destinationType = destinationType;
        this.nextLevel = player.getServer().getLevel(destinationType);
    }

    public void execute() {
        if (player instanceof ServerPlayer player && !player.level.isClientSide()) {
            if (player.level.dimension() == destinationType){
                return;
            }
            if (nextLevel != null) {
                player.stopSleepInBed(true,true);
            }
        }
    }
}