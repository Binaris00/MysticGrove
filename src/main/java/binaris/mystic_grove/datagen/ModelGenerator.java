package binaris.mystic_grove.datagen;

import binaris.mystic_grove.registry.MysticBlocks;
import binaris.mystic_grove.registry.MysticItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModelGenerator extends FabricModelProvider {
    public ModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(MysticBlocks.LUMINITE_ORE);
        blockStateModelGenerator.registerLog(MysticBlocks.MYSTIC_LOG).log(MysticBlocks.MYSTIC_LOG).wood(MysticBlocks.MYSTIC_WOOD);
        blockStateModelGenerator.registerLog(MysticBlocks.STRIPPED_MYSTIC_LOG).log(MysticBlocks.STRIPPED_MYSTIC_LOG).wood(MysticBlocks.STRIPPED_MYSTIC_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(MysticBlocks.MYSTIC_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(MysticBlocks.MYSTIC_LEAVES);

        blockStateModelGenerator.registerFlowerPotPlant(MysticBlocks.ETHER_BLOSSOM, MysticBlocks.POTTED_ETHER_BLOSSOM, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(MysticItems.LUMINITE, Models.GENERATED);
        itemModelGenerator.register(MysticItems.MYSTIC_MIRROR, Models.HANDHELD);
        itemModelGenerator.register(MysticItems.MAGIC_WAND, Models.HANDHELD);
        itemModelGenerator.register(MysticItems.CRUSHED_GLOW_MUSHROOM, Models.GENERATED);

    }
}
