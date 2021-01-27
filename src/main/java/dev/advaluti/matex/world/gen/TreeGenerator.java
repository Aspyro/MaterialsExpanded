package dev.advaluti.matex.world.gen;

import com.google.common.collect.Lists;
import dev.advaluti.matex.world.feature.RubberTreeFeature;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class TreeGenerator {
    public static RubberTreeFeature RUBBERTREE;
    public static ConfiguredFeature<?, ?> CONFIGURED_RUBBERTREE;

    public static void init() {
        RUBBERTREE = Registry.register(Registry.FEATURE, "matex:rubbertree", new RubberTreeFeature(BaseTreeFeatureConfig.CODEC));
        CONFIGURED_RUBBERTREE = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "matex:rubbertree", RUBBERTREE.configure());
    }

    public static void setup() {
        addTreeToOverworld(CONFIGURED_RUBBERTREE);
    }

    private static void addTreeToOverworld(ConfiguredFeature<?, ?> featureIn){
        for(Map.Entry<RegistryKey<Biome>, Biome> biome : WorldGenRegistries.BIOME.getEntries()) {
            if(!biome.getValue().getCategory().equals(Biome.Category.NETHER) && !biome.getValue().getCategory().equals(Biome.Category.THEEND)) {
                addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.VEGETAL_DECORATION, featureIn);
            }
        }
    }

    public static void addFeatureToBiome(Biome biome, GenerationStage.Decoration decoration, ConfiguredFeature<?, ?> configuredFeature) {
        List<List<Supplier<ConfiguredFeature<?, ?>>>> biomeFeatures = new ArrayList<>(biome.getGenerationSettings().getFeatures());
        while (biomeFeatures.size() <= decoration.ordinal()) {
            biomeFeatures.add(Lists.newArrayList());
        }
        List<Supplier<ConfiguredFeature<?, ?>>> features = new ArrayList<>(biomeFeatures.get(decoration.ordinal()));
        features.add(() -> configuredFeature);
        biomeFeatures.set(decoration.ordinal(), features);

        ObfuscationReflectionHelper.setPrivateValue(BiomeGenerationSettings.class, biome.getGenerationSettings(), biomeFeatures, "field_242484_f");
    }
}