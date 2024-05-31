package binaris.mystic_grove;

import binaris.mystic_grove.datagen.ModelGenerator;
import binaris.mystic_grove.datagen.WorldGenerator;
import binaris.mystic_grove.world.biome.MysticGroveBiome;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class MysticGroveDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(WorldGenerator::new);
		pack.addProvider(ModelGenerator::new);

	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.BIOME, MysticGroveBiome::boostrap);
	}
}
