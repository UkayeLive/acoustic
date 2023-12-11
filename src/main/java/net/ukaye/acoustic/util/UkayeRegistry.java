package net.ukaye.acoustic.util;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class UkayeRegistry {


    public static void registerBlock(String id, Block block) {
        Registry.register(Registries.BLOCK, new Identifier("acoustic", id), block);
        Registry.register(Registries.ITEM, new Identifier("acoustic", id), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerItem(String id, Item item) {
        Registry.register(Registries.ITEM, new Identifier("acoustic", id), item);
    }
}
