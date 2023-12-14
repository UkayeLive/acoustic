package net.ukaye.acoustic.util;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.ukaye.acoustic.Acoustic;

public class ItemGroups {

    public static final ItemGroup ACOUSTIC = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Acoustic.SONIC_ARROW))
            .displayName(Text.translatable("itemGroup.acoustic.acoustic"))
            .entries((context, entries) -> {
                entries.add(Acoustic.REINFORCED_CROSSBOW);
                entries.add(Acoustic.SONIC_ARROW);
                entries.add(Acoustic.ECHO_BLOCK);
            })
            .build();

}
