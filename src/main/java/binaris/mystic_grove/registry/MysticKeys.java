package binaris.mystic_grove.registry;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public final class MysticKeys {
    public static final TagKey<Item> LOGS = MysticKeys.of("mystic_logs");

    MysticKeys() {
        // Private constructor to prevent instantiation.
    }

    public static void register() {
        // No-op
    }

    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(id));
    }
}
