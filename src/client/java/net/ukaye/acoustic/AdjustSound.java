package net.ukaye.acoustic;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.client.sound.SoundSystem;
import net.minecraft.client.sound.Source;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.ukaye.acoustic.network.AdjustSoundPacket;

public class AdjustSound {


    public AdjustSound() {
    ClientPlayNetworking.registerGlobalReceiver(Acoustic.ADJUST_SOUND, (client, handler, buf, responseSender) -> {
        float volume = buf.readFloat();
        SoundManager soundManager = client.getSoundManager();

        client.execute(() -> {
            soundManager.updateSoundVolume(SoundCategory.MASTER, volume);
            Acoustic.LOGGER.info("Sound volume adjusted to " + volume);
        });
    });
    }

}
