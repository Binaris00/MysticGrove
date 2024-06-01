package binaris.mystic_grove.registry;

import binaris.mystic_grove.MysticGroveMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

/**
 * This class is used to register all the blocks in the mod.
 *
 * @author Binaris
 */
public final class MysticBlocks {
    MysticBlocks() {
        // Private constructor to prevent instantiation.
    }

    public static Block LUMINITE_ORE = new Block(FabricBlockSettings.copyOf(Blocks.GOLD_ORE).hardness(3.0f).resistance(3.0f).luminance(40).requiresTool());
    public static BlockItem LUMINITE_ORE_ITEM = new BlockItem(LUMINITE_ORE, new Item.Settings());

    public static void register() {
        registerBlock("luminite_ore", LUMINITE_ORE);
        registerBlockItem("luminite_ore", LUMINITE_ORE_ITEM);
    }


    /**
     * Registers a block with the given name.
     *
     * @param name  The name of the block.
     * @param block The block to register.
     */
    private static void registerBlock(String name, Block block) {
        Registry.register(Registries.BLOCK, MysticGroveMod.id(name), block);
    }

    /**
     * Registers a block item with the given name.
     *
     * @param name  The name of the block item.
     * @param block The block item to register.
     */
    private static void registerBlockItem(String name, BlockItem block) {
        Registry.register(Registries.ITEM, MysticGroveMod.id(name), block);
        ItemGroupEvents.modifyEntriesEvent(MysticItemGroup.ITEM_GROUP).register(entries -> entries.add(block));
    }
}
