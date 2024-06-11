package binaris.mystic_grove.registry;

import binaris.mystic_grove.MysticGroveMod;
import binaris.mystic_grove.mixin.BrewingRecipeRegistryMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public final class MysticPotions {
    public static Potion HEALTH_BOOST;
    public static Potion LONG_HEALTH_BOOST;
    private MysticPotions() {
    }

    public static void init(){
        HEALTH_BOOST = registerPotion("health_boost", new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 3600, 0));
        registerRecipe(Potions.AWKWARD, Item.fromBlock(MysticBlocks.ETHER_BLOSSOM), HEALTH_BOOST);

        LONG_HEALTH_BOOST = registerPotion("long_health_boost", new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 9600, 0));
        registerRecipe(HEALTH_BOOST, Items.REDSTONE, LONG_HEALTH_BOOST);
    }


    private static void registerRecipe(Potion input, Item item, Potion output){
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(input, item, output);
    }
    private static Potion registerPotion(String name, StatusEffectInstance statusEffectInstance) {
        return Registry.register(Registries.POTION, MysticGroveMod.id(name), new Potion(statusEffectInstance));
    }
}
