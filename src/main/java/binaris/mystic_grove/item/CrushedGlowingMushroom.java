package binaris.mystic_grove.item;

import binaris.mystic_grove.registry.MysticBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Rarity;
public class CrushedGlowingMushroom extends BlockItem {
    public CrushedGlowingMushroom() {
        super(MysticBlocks.GLOW_AIR, new FabricItemSettings().rarity(Rarity.RARE));
    }


}
