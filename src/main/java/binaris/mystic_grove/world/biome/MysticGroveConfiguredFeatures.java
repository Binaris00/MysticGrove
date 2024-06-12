package binaris.mystic_grove.world.biome;

import binaris.mystic_grove.MysticGroveMod;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;

public class MysticGroveConfiguredFeatures {
    public static final RegistryKey<PlacedFeature> LUMINITE_ORE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MysticGroveMod.MODID,"luminite_ore"));
    public static final RegistryKey<PlacedFeature> MYSTIC_TREE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MysticGroveMod.MODID,"mystic_tree"));
    public static final RegistryKey<Biome> MYSTIC_GROVE = RegistryKey.of(RegistryKeys.BIOME, new Identifier(MysticGroveMod.MODID,"mystic_grove"));


    public static void init(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(MYSTIC_GROVE), GenerationStep.Feature.UNDERGROUND_ORES, LUMINITE_ORE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(MYSTIC_GROVE), GenerationStep.Feature.VEGETAL_DECORATION, MYSTIC_TREE);
    }
}
