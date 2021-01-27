package dev.advaluti.matex.items;

import dev.advaluti.matex.util.ModSetup;
import net.minecraft.item.Item;

public class GearBase extends Item {
    public GearBase() {
        super(new Properties()
                .maxStackSize(64)
                .group(ModSetup.MATEX_GROUP)
        );
    }
}
