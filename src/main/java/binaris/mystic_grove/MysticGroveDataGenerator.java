package binaris.mystic_grove;

import binaris.mystic_grove.datagen.BlockTagGenerator;
import binaris.mystic_grove.datagen.LootTableGenerator;
import binaris.mystic_grove.datagen.ModelGenerator;
import binaris.mystic_grove.datagen.RecipeGenerator;
import binaris.mystic_grove.world.biome.MysticGroveBiome;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
/**
 * The entrypoint for the data generator.
 * This class is referenced in src/main/resources/fabric.mod.json.
 */
public class MysticGroveDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModelGenerator::new);
		pack.addProvider(RecipeGenerator::new);
		pack.addProvider(LootTableGenerator::new);
		pack.addProvider(BlockTagGenerator::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.BIOME, MysticGroveBiome::boostrap);
	}
}
