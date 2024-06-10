package binaris.mystic_grove.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AirBlock;
import net.minecraft.block.Blocks;

public class GlowAir extends AirBlock {
    public GlowAir() {
        super(FabricBlockSettings.copyOf(Blocks.AIR).luminance(15).nonOpaque());
    }


}
