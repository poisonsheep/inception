package io.github.poisonsheep.inception.item;

import io.github.poisonsheep.inception.Inception;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Inception.MODID);

    public static final RegistryObject<Item> SEDATIVE = ITEMS.register("sedative",()->new Sedative());
}
