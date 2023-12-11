package net.ukaye.acoustic;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.ukaye.acoustic.blocks.EchoBlock;
import net.ukaye.acoustic.entity.SonicArrowEntity;
import net.ukaye.acoustic.items.ReinforcedCrossbowItem;
import net.ukaye.acoustic.items.SonicArrowItem;
import net.ukaye.acoustic.util.UkayeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Acoustic implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("acoustic");

	public static final Item REINFORCED_CROSSBOW = new ReinforcedCrossbowItem(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC));
	public static final Item SONIC_ARROW = new SonicArrowItem(new FabricItemSettings().maxCount(64).rarity(Rarity.EPIC));



	public static final Block ECHO_BLOCK = new EchoBlock(FabricBlockSettings.create().luminance(state -> 15));


	public static final EntityType<SonicArrowEntity> SonicArrowEntityType = Registry.register(
			Registries.ENTITY_TYPE,
			new Identifier("acoustic", "sonic_arrow"),
			FabricEntityTypeBuilder.<SonicArrowEntity>create(SpawnGroup.MISC, SonicArrowEntity::new)
					.dimensions(EntityDimensions.fixed(0.5f, 0.5f))
					.trackRangeBlocks(4).trackedUpdateRate(10)
					.build()
	);

	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		UkayeRegistry.registerItem("reinforced_crossbow", REINFORCED_CROSSBOW);
		UkayeRegistry.registerItem("sonic_arrow", SONIC_ARROW);

		UkayeRegistry.registerBlock("echo_block", ECHO_BLOCK);
	}
}