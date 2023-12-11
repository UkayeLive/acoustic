package net.ukaye.acoustic.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.ukaye.acoustic.Acoustic;
import net.ukaye.acoustic.util.ModDamageTypes;

public class SonicArrowEntity extends PersistentProjectileEntity {

    private static final ItemStack DEFAULT_STACK;

    public SonicArrowEntity(EntityType<? extends SonicArrowEntity> entityType, World world) {
        super(entityType, world, DEFAULT_STACK);
    }

    public SonicArrowEntity(World world, double x, double y, double z, ItemStack stack) {
        super(Acoustic.SonicArrowEntityType, x, y, z, world, stack);
    }

    public SonicArrowEntity(World world, LivingEntity owner, ItemStack stack) {
        super(Acoustic.SonicArrowEntityType, owner, world, stack);
    }

    @Override
    protected SoundEvent getHitSound() {
        return SoundEvents.ENTITY_WARDEN_SONIC_BOOM;
    }

    public void setSound(SoundEvent sound) {
        getHitSound();
    }

    protected void onHit(LivingEntity target) {
        super.onHit(target);
        target.damage(ModDamageTypes.of(this.getWorld(), ModDamageTypes.SONIC_DAMAGE), 6.0F);
    }

    public void tick() {
        super.tick();
        int cooldown = 0;
        if (this.getWorld().isClient && !this.inGround) {
            this.getWorld().addParticle(ParticleTypes.SONIC_BOOM, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
            if (cooldown % 10 == 1 && cooldown <= 100) {
                this.getWorld().playSound(this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_WARDEN_SONIC_CHARGE, this.getSoundCategory(), 0.5F, 0.5F + this.random.nextFloat() * 0.2F, false);
            }
            cooldown++;
            }

    }

    static {
        DEFAULT_STACK = new ItemStack(Items.ARROW);
    }


}
