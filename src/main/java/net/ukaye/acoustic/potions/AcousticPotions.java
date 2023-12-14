package net.ukaye.acoustic.potions;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.ukaye.acoustic.Acoustic;

public class AcousticPotions {

    public static final Potion AMPLIFING =
            Registry.register(Registries.POTION, new Identifier("acoustic", "amplifying"),
                    new Potion(new StatusEffectInstance(Acoustic.AMPLIFYING_EFFECT, 3600, 0)));

    public static void registerPotions() {
    }

    public static void registerPotionsRecipies() {
        BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, Items.ECHO_SHARD, AcousticPotions.AMPLIFING);
    }
}
