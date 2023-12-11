package net.ukaye.acoustic.items;

import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.ukaye.acoustic.items.SonicArrowItem;

import java.util.function.Predicate;

public class ReinforcedCrossbowItem extends CrossbowItem {
    public ReinforcedCrossbowItem(Settings settings) {
        super(settings);
    }

    public Predicate<ItemStack> getHeldProjectiles() {
        return CROSSBOW_HELD_PROJECTILES.or(stack -> stack.getItem() instanceof SonicArrowItem);
    }
}
