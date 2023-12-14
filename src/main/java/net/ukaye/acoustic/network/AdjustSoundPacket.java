package net.ukaye.acoustic.network;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.TypedActionResult;
import net.ukaye.acoustic.Acoustic;

public class AdjustSoundPacket {




    public static TypedActionResult adjustSound(ServerPlayerEntity player, float volume) {
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeFloat(volume);
        ServerPlayNetworking.send(player, Acoustic.ADJUST_SOUND, buf);
        Acoustic.LOGGER.info("Sending sound adjustment packet to " + player.getName().toString() + " with volume " + volume + ".");
        return TypedActionResult.success(volume);
    }
}
