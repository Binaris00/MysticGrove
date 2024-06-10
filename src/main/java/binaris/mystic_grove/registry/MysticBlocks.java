package binaris.mystic_grove.registry;

import binaris.mystic_grove.MysticGroveMod;
import binaris.mystic_grove.block.GlowAir;
import binaris.mystic_grove.block.GlowShroom;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.PillarBlock;
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

    public static Block MYSTIC_LOG = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(4f));
    public static Block MYSTIC_WOOD = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(4f));
    public static Block STRIPPED_MYSTIC_LOG = new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).strength(4f));
    public static Block STRIPPED_MYSTIC_WOOD = new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(4f));
    public static Block MYSTIC_PLANKS = new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f));
    public static Block MYSTIC_LEAVES = new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).strength(4f).nonOpaque());
    public static Block LUMINITE_ORE = new Block(FabricBlockSettings.copyOf(Blocks.GOLD_ORE).hardness(3.0f).resistance(3.0f).luminance(40).requiresTool());
    public static Block GLOW_SHROOM = new GlowShroom();
    public static Block GLOW_AIR = new GlowAir();
    public static void register() {
        registerBlockItem("luminite_ore", LUMINITE_ORE);
        registerBlockItem("mystic_log", MYSTIC_LOG);
        registerBlockItem("mystic_wood", MYSTIC_WOOD);
        registerBlockItem("stripped_mystic_log", STRIPPED_MYSTIC_LOG);
        registerBlockItem("stripped_mystic_wood", STRIPPED_MYSTIC_WOOD);
        registerBlockItem("mystic_planks", MYSTIC_PLANKS);
        registerBlockItem("mystic_leaves", MYSTIC_LEAVES);
        registerBlockItem("glowshroom", GLOW_SHROOM);
        registerBlock("glow_air", GLOW_AIR);

        StrippableBlockRegistry.register(MYSTIC_LOG, STRIPPED_MYSTIC_LOG);
        StrippableBlockRegistry.register(MYSTIC_WOOD, STRIPPED_MYSTIC_WOOD);

        FlammableBlockRegistry.getDefaultInstance().add(MYSTIC_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(MYSTIC_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_MYSTIC_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_MYSTIC_WOOD, 5, 5);

        FlammableBlockRegistry.getDefaultInstance().add(MYSTIC_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(MYSTIC_LEAVES, 30, 60);
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
     * Registers a block item with the given name and block.
     *
     * @param name  The name of the block item.
     * @param block The block item to register.
     */
    private static void registerBlockItem(String name, Block block) {
        registerBlock(name, block);
        Registry.register(Registries.ITEM, MysticGroveMod.id(name), new BlockItem(block, new Item.Settings()));
        ItemGroupEvents.modifyEntriesEvent(MysticItemGroup.ITEM_GROUP).register(entries -> entries.add(block));
    }
}
