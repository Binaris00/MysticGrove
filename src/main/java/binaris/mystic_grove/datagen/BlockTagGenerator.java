package binaris.mystic_grove.datagen;

import binaris.mystic_grove.registry.MysticBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class BlockTagGenerator extends FabricTagProvider.BlockTagProvider{
    public BlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(MysticBlocks.LUMINITE_BLOCK)
                .add(MysticBlocks.LUMINITE_ORE);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(MysticBlocks.MYSTIC_LOG)
                .add(MysticBlocks.MYSTIC_WOOD)
                .add(MysticBlocks.STRIPPED_MYSTIC_LOG)
                .add(MysticBlocks.STRIPPED_MYSTIC_WOOD);

        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(MysticBlocks.MYSTIC_LEAVES);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(MysticBlocks.LUMINITE_BLOCK)
                .add(MysticBlocks.LUMINITE_ORE);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(MysticBlocks.MYSTIC_LOG)
                .add(MysticBlocks.MYSTIC_WOOD)
                .add(MysticBlocks.STRIPPED_MYSTIC_LOG)
                .add(MysticBlocks.STRIPPED_MYSTIC_WOOD);
    }
}
