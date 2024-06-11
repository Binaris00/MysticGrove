package binaris.mystic_grove.entities;

import binaris.mystic_grove.registry.MysticBlocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class MysticDeer extends AnimalEntity {
    // List of good items
    public static List<Item> goodItems = Arrays.asList(
            Items.DIAMOND,
            Items.GOLDEN_APPLE,
            Items.EMERALD,
            Items.ENCHANTED_BOOK,
            Items.NETHER_STAR
    );

    // List of good status effects
    public static List<StatusEffect> goodEffects = Arrays.asList(
            StatusEffects.REGENERATION,
            StatusEffects.RESISTANCE,
            StatusEffects.FIRE_RESISTANCE,
            StatusEffects.WATER_BREATHING,
            StatusEffects.INVISIBILITY
    );

    // List of bad status effects
    public static List<StatusEffect> badEffects = Arrays.asList(
            StatusEffects.POISON,
            StatusEffects.HUNGER,
            StatusEffects.WEAKNESS,
            StatusEffects.SLOWNESS,
            StatusEffects.MINING_FATIGUE
    );
    public MysticDeer(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        if(source.getAttacker() instanceof LivingEntity livingEntity){
            livingEntity.addStatusEffect(new StatusEffectInstance(badEffects.get(livingEntity.getEntityWorld().random.nextInt(goodEffects.size())), 200));
        }
        return super.damage(source, amount);
    }

    @Override
    public ActionResult interactAt(PlayerEntity player, Vec3d hitPos, Hand hand) {
        // if player has a glow mushroom in hand, remove it and give the player a random good effect
        if(player.getStackInHand(hand).getItem() == MysticBlocks.GLOW_SHROOM.asItem()){
            player.getStackInHand(hand).decrement(1);
            player.addStatusEffect(new StatusEffectInstance(goodEffects.get(player.getEntityWorld().random.nextInt(goodEffects.size())), 200));
        }
        return super.interactAt(player, hitPos, hand);
    }
}
