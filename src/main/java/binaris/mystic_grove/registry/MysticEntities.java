package binaris.mystic_grove.registry;

import binaris.mystic_grove.MysticGroveMod;
import binaris.mystic_grove.entities.MysticDeer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class MysticEntities {
    public static EntityType<MysticDeer> MYSTIC_DEER = Registry.register(
    Registries.ENTITY_TYPE,
            new Identifier(MysticGroveMod.MODID, "mystic_deer"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MysticDeer::new).dimensions(EntityDimensions.fixed(0.50f, 1.2f)).build()
    );
    private MysticEntities() {
    }

    public static void register() {
        FabricDefaultAttributeRegistry.register(MYSTIC_DEER, AnimalEntity.createMobAttributes());
    }
}
