package binaris.mystic_grove;

import binaris.mystic_grove.MysticGrove;
import binaris.mystic_grove.world.biome.MysticGroveRegion;
import binaris.mystic_grove.world.biome.MysticGroveRules;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

import static binaris.mystic_grove.MysticGrove.id;

public class MysticTerraBlender implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new MysticGroveRegion(id("overworld_1"), 4));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MysticGrove.MODID, MysticGroveRules.makeRules());
    }
}
