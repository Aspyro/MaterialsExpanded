package dev.advaluti.matex.world.feature;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import dev.advaluti.matex.util.Registration;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class RubberTreeFeature extends TreeFeature {
    public RubberTreeFeature(Codec<BaseTreeFeatureConfig> codec) {
        super(codec);
    }

    public ConfiguredFeature<?, ?> configure() {
        return this.setConfiguration().withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1)).square());
    }

    public ConfiguredFeature<BaseTreeFeatureConfig, ?> setConfiguration() {
        return this.withConfiguration(
                new BaseTreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(Registration.RUBBERLOG.get().getDefaultState()),
                        new SimpleBlockStateProvider(Registration.RUBBERLEAVES.get().getDefaultState()),
                        new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3),
                        new StraightTrunkPlacer(5, 2, 0),
                        new TwoLayerFeature(1, 0, 1)
                ).setIgnoreVines().setDecorators(ImmutableList.of(new BeehiveTreeDecorator(0.002F))).build());
    }
}