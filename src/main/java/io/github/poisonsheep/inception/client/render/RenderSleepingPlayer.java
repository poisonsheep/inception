package io.github.poisonsheep.inception.client.render;

import com.mojang.authlib.GameProfile;
import com.mojang.blaze3d.vertex.PoseStack;
import io.github.poisonsheep.inception.entity.DummyPlayer;
import io.github.poisonsheep.inception.entity.EntitySleepingPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class RenderSleepingPlayer extends EntityRenderer<EntitySleepingPlayer> {
    private static final Minecraft MC = Minecraft.getInstance();
    public RenderSleepingPlayer(EntityRendererProvider.Context render) {
        super(render);
    }


    @Override
    public ResourceLocation getTextureLocation(EntitySleepingPlayer pEntity) {
        return null;
    }

    @Override
    public void render(@NotNull EntitySleepingPlayer pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
        AbstractClientPlayer abstractClientPlayerEntity = new DummyPlayer((ClientLevel) pEntity.level, new GameProfile(pEntity.getEntityUUID().orElse(new UUID(0L, 0L)), pEntity.getEntityName()), pEntity.getEquipment(), pEntity.getEntityModel());
        MC.getEntityRenderDispatcher().getRenderer(abstractClientPlayerEntity).render(abstractClientPlayerEntity, 0F, 1F, pPoseStack, pBuffer, pPackedLight);
        pPoseStack.popPose();
    }
}
