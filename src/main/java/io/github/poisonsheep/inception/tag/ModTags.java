package io.github.poisonsheep.inception.tag;

import io.github.poisonsheep.inception.Inception;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static final TagKey<Item> SEDATIVE = ItemTags.create(new ResourceLocation(Inception.MODID, "sedative"));
}
