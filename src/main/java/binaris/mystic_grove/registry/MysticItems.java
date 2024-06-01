package binaris.mystic_grove.registry;

import binaris.mystic_grove.MysticGroveMod;
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

    public static void register(){
        registerItem("luminite", LUMINITE);
    }

    /**
     * Registers an item with the given name.
     *
     * @param name The name of the item.
     * @param item The item to register.
     */
    private static void registerItem(String name, Item item){
        Registry.register(Registries.ITEM, MysticGroveMod.id(name), item);
    }
}
