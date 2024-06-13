package binaris.mystic_grove.datagen;

import binaris.mystic_grove.registry.MysticBlocks;
import binaris.mystic_grove.registry.MysticKeys;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends FabricTagProvider.ItemTagProvider{
    public ItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(MysticBlocks.MYSTIC_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(MysticBlocks.MYSTIC_LOG.asItem())
                .add(MysticBlocks.MYSTIC_WOOD.asItem())
                .add(MysticBlocks.STRIPPED_MYSTIC_LOG.asItem())
                .add(MysticBlocks.STRIPPED_MYSTIC_WOOD.asItem());

        getOrCreateTagBuilder(MysticKeys.LOGS)
                .add(MysticBlocks.MYSTIC_LOG.asItem())
                .add(MysticBlocks.MYSTIC_WOOD.asItem())
                .add(MysticBlocks.STRIPPED_MYSTIC_LOG.asItem())
                .add(MysticBlocks.STRIPPED_MYSTIC_WOOD.asItem());
    }
}
