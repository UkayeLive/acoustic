package net.ukaye.acoustic.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.ukaye.acoustic.entity.SonicArrowEntity;

public class SonicArrowItem extends ArrowItem {
    public SonicArrowItem(Settings settings) {
        super(settings);
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        return new SonicArrowEntity(world, shooter, stack.copyWithCount(1));
    }
}
