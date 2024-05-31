package binaris.mystic_grove.datagen;

import binaris.mystic_grove.MysticGrove;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModelGenerator extends FabricModelProvider {
    public static Block SIMPLE_BLOCK = Registry.register(Registries.BLOCK, new Identifier(MysticGrove.MODID, "simple_block"), new Block(Block.Settings.copy(Blocks.STONE)));
    public ModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(SIMPLE_BLOCK);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
