package io.github.poisonsheep.inception.entity;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Optional;
import java.util.UUID;

public class EntitySleepingPlayer extends LivingEntity {

    private static final EntityDataAccessor<Optional<UUID>> ID = SynchedEntityData.defineId(EntitySleepingPlayer.class, EntityDataSerializers.OPTIONAL_UUID);
    private static final EntityDataAccessor<String> NAME = SynchedEntityData.defineId(EntitySleepingPlayer.class, EntityDataSerializers.STRING);
    private static final EntityDataAccessor<Byte> MODEL = SynchedEntityData.defineId(EntitySleepingPlayer.class, EntityDataSerializers.BYTE);


    public EntitySleepingPlayer(EntityType type, Level world) {
        super(type, world);
    }

    public EntitySleepingPlayer(Level world) {
        this(EntityRegistry.SLEEPING_PLAYER.get(), world);
    }


    public static AttributeSupplier.Builder prepareAttributes() {
        return LivingEntity.createLivingAttributes()
                .add(Attributes.ATTACK_DAMAGE, 3.0)
                .add(Attributes.MAX_HEALTH, 20.0)
                .add(Attributes.FOLLOW_RANGE, 40.0)
                .add(Attributes.MOVEMENT_SPEED, 0.3);
    }
    public void setEntityUUID(UUID uuid) {
        if (uuid == null) {
            entityData.set(ID, Optional.empty());
        } else {
            entityData.set(ID, Optional.of(uuid));
        }
    }


    public void setEntityName(String name) {
        entityData.set(NAME, name);
    }
    public String getEntityName() {
        return entityData.get(NAME);
    }


    public void setEntityModel(byte model) {
        entityData.set(MODEL, model);
    }
    public byte getEntityModel() {
        return entityData.get(MODEL);
    }


    public Optional<UUID> getEntityUUID() {
        return entityData.get(ID);
    }

    @Override
    protected void defineSynchedData() {

    }


    @Override
    public Iterable<ItemStack> getArmorSlots() {
        return null;
    }

    @Override
    public ItemStack getItemBySlot(EquipmentSlot pSlot) {
        return null;
    }

    @Override
    public void setItemSlot(EquipmentSlot pSlot, ItemStack pStack) {

    }

    @Override
    public HumanoidArm getMainArm() {
        return null;
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return null;
    }
}
