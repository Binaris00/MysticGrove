package binaris.mystic_grove.world.biome;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class MysticGroveRules {
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule GOLD_BLOCK = makeStateRule(Blocks.GOLD_BLOCK);
    private static final MaterialRules.MaterialRule GOLD_ORE = makeStateRule(Blocks.GOLD_ORE);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(MysticGroveBiome.MYSTIC_GROVE),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, GOLD_ORE)),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, GOLD_BLOCK)),

                // Default to a grass and dirt surface
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
