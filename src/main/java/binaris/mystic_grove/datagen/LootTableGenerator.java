package binaris.mystic_grove.datagen;

import binaris.mystic_grove.registry.MysticBlocks;
import binaris.mystic_grove.registry.MysticItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class LootTableGenerator extends FabricBlockLootTableProvider {
    public LootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(MysticBlocks.LUMINITE_ORE, MysticItems.LUMINITE);
    }
}
