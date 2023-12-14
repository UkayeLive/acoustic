package net.ukaye.acoustic.potions.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.network.ServerPlayerEntity;
import net.ukaye.acoustic.Acoustic;
import net.ukaye.acoustic.network.AdjustSoundPacket;

public class AmplifyingEffect extends StatusEffect {
    public AmplifyingEffect() {
        super(
                StatusEffectCategory.HARMFUL,
                0x800020);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        super.onApplied(entity, amplifier);
        if (entity instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity) entity;
            AdjustSoundPacket.adjustSound(serverPlayerEntity, 1.5f);
            Acoustic.LOGGER.info("Applied Amplifying Effect to " + serverPlayerEntity.getName().toString() + " with volume 1.5.");
        }
    }


    @Override
    public void onRemoved(AttributeContainer attributeContainer) {
        //LivingEntity entity =
    }
}
