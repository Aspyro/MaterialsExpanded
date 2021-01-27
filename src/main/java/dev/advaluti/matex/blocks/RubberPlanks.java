package dev.advaluti.matex.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;

public class RubberPlanks extends Block {

    public RubberPlanks() {
        super(Properties.create(Material.WOOD, MaterialColor.WOOD)
                .sound(SoundType.WOOD)
                .hardnessAndResistance(1.5f)
                .harvestTool(ToolType.AXE)
                .harvestLevel(0)
        );
    }
}
