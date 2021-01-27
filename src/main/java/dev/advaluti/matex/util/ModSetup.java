package dev.advaluti.matex.util;

import dev.advaluti.matex.world.gen.TreeGenerator;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;

public class ModSetup {

    public static final ItemGroup MATEX_GROUP = new ItemGroup("matexgeneral") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Registration.GEARCOPPER.get());
        }
    };

    public static final ItemGroup MATEXTOOLS_GROUP = new ItemGroup("matextools") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Registration.TOOLMORTAR.get());
        }
    };

    public static void init(final FMLCommonSetupEvent event) {
        //Generates trees
        //TreeGenerator.init();
    }

    @SubscribeEvent
    public static void serverLoad(FMLServerStartingEvent event) {

    }
}
