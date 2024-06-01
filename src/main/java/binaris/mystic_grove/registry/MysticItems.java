package binaris.mystic_grove.registry;

import binaris.mystic_grove.MysticGroveMod;
import binaris.mystic_grove.item.MagicWand;
import binaris.mystic_grove.item.MysticMirror;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

/**
 * The class that holds all the items in the mod.
 *
 * @author Binaris
 */
public final class MysticItems {
    public static Item LUMINITE = new Item(new Item.Settings());
    public static Item MYSTIC_MIRROR = new MysticMirror();
    public static Item MAGIC_WAND = new MagicWand();

    public static void register(){
        registerItem("luminite", LUMINITE);
        registerItem("mystic_mirror", MYSTIC_MIRROR);
        registerItem("magic_wand", MAGIC_WAND);
    }

    /**
     * Registers an item with the given name.
     *
     * @param name The name of the item.
     * @param item The item to register.
     */
    private static void registerItem(String name, Item item){
        Registry.register(Registries.ITEM, MysticGroveMod.id(name), item);
        ItemGroupEvents.modifyEntriesEvent(MysticItemGroup.ITEM_GROUP).register(entries -> entries.add(item));
    }
}
