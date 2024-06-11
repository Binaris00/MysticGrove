package binaris.mystic_grove.item;

import binaris.mystic_grove.entities.MysticDeer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MagicWand extends Item {
    public MagicWand() {
        super(new FabricItemSettings().maxCount(1).maxDamage(64).rarity(Rarity.RARE));
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            final double ATTRACTION_FORCE = 2D;
            final int COOLDOWN_TIME = 80;
            double radius = 10.0D;
            Vec3d playerPos = user.getPos();
            List<Entity> entities = world.getOtherEntities(user, new Box(playerPos.x - radius, playerPos.y - radius, playerPos.z - radius, playerPos.x + radius, playerPos.y + radius, playerPos.z + radius));

            for (Entity entity : entities) {
                if(entity instanceof MysticDeer) {
                    entity.dropStack(new ItemStack(MysticDeer.goodItems.get(world.random.nextInt(MysticDeer.goodItems.size()))));
                    user.sendMessage(Text.literal("The Mystic Deer dropped a gift!").formatted(Formatting.AQUA), true);
                }

                Vec3d entityPos = entity.getPos();
                Vec3d direction = playerPos.subtract(entityPos).normalize();
                entity.addVelocity(direction.x * ATTRACTION_FORCE, direction.y * ATTRACTION_FORCE, direction.z * ATTRACTION_FORCE);
            }

            user.getItemCooldownManager().set(this, COOLDOWN_TIME);
            user.getStackInHand(hand).damage(1, user, (player) -> player.sendToolBreakStatus(hand));
        }

        return TypedActionResult.success(user.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.mystic_grove.magic_wand.tooltip").formatted(Formatting.GRAY));
    }
}
