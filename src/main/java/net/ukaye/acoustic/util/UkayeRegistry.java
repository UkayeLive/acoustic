package net.ukaye.acoustic.util;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.ukaye.acoustic.Acoustic;

public class UkayeRegistry {


    public static void registerBlock(String id, Block block) {
        Registry.register(Registries.BLOCK, new Identifier(Acoustic.MODID, id), block);
        Registry.register(Registries.ITEM, new Identifier(Acoustic.MODID, id), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerItem(String id, Item item) {
        Registry.register(Registries.ITEM, new Identifier(Acoustic.MODID, id), item);
    }

    public static void registerParticle(String id, DefaultParticleType particleType) {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(Acoustic.MODID, id), particleType);
    }

    public static void registerEnchantment(String id, Enchantment enchantment) {
        Registry.register(Registries.ENCHANTMENT, new Identifier(Acoustic.MODID, id), enchantment);
    }

    public static void registerItemGroup(String id, ItemGroup itemGroup) {
        Registry.register(Registries.ITEM_GROUP, new Identifier(Acoustic.MODID, id), itemGroup);
    }

    public static void registerStatusEffect(String id, StatusEffect statusEffect) {
        Registry.register(Registries.STATUS_EFFECT, new Identifier(Acoustic.MODID, id), statusEffect);
    }
}
