package dev.advaluti.matex.items;

import dev.advaluti.matex.util.ModSetup;
import net.minecraft.item.Item;

public class DustBase extends Item {
    public DustBase() {
        super(new Item.Properties()
                .maxStackSize(64)
                .group(ModSetup.MATEX_GROUP)
        );
    }
}
