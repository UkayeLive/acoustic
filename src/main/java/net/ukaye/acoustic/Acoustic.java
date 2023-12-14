package net.ukaye.acoustic;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.ukaye.acoustic.blocks.EchoBlock;
import net.ukaye.acoustic.enchantments.AmplifyingEnchantment;
import net.ukaye.acoustic.enchantments.DampeningEnchantment;
import net.ukaye.acoustic.entity.SonicArrowEntity;
import net.ukaye.acoustic.items.ReinforcedCrossbowItem;
import net.ukaye.acoustic.items.SonicArrowItem;
import net.ukaye.acoustic.potions.AcousticPotions;
import net.ukaye.acoustic.potions.effects.AmplifyingEffect;
import net.ukaye.acoustic.util.ItemGroups;
import net.ukaye.acoustic.util.UkayeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Acoustic implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	public static final String MODID = "acoustic";
    public static final Logger LOGGER = LoggerFactory.getLogger("acoustic");

	public static final Item REINFORCED_CROSSBOW = new ReinforcedCrossbowItem(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC));
	public static final Item SONIC_ARROW = new SonicArrowItem(new FabricItemSettings().maxCount(64).rarity(Rarity.EPIC));

	public static final Identifier ADJUST_SOUND = new Identifier(Acoustic.MODID, "adjust_sound");

	public static Enchantment AMPLIFYING = new AmplifyingEnchantment();
	public static Enchantment DAMPENING = new DampeningEnchantment();

	public static final StatusEffect AMPLIFYING_EFFECT = new AmplifyingEffect();

	public static final Block ECHO_BLOCK = new EchoBlock(FabricBlockSettings.create().luminance(state -> 15).hardness(1.5f).resistance(6.0f).nonOpaque());


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

		AcousticPotions.registerPotions();
		AcousticPotions.registerPotionsRecipies();
		UkayeRegistry.registerItem("reinforced_crossbow", REINFORCED_CROSSBOW);
		UkayeRegistry.registerItem("sonic_arrow", SONIC_ARROW);

		UkayeRegistry.registerBlock("echo_block", ECHO_BLOCK);

		UkayeRegistry.registerEnchantment("amplifying", AMPLIFYING);
		UkayeRegistry.registerEnchantment("dampening", DAMPENING);

		UkayeRegistry.registerItemGroup("acoustic", ItemGroups.ACOUSTIC);

		UkayeRegistry.registerStatusEffect("amplifying", AMPLIFYING_EFFECT);
	}
}