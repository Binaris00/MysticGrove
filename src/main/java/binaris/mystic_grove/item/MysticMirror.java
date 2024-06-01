package binaris.mystic_grove.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MysticMirror extends Item {
    private BlockPos savedPos;

    public MysticMirror() {
        super(new FabricItemSettings().maxCount(1).maxDamage(64).rarity(Rarity.RARE));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if(stack.getOrCreateNbt().contains("savedPos_x")) {
            int x = stack.getOrCreateNbt().getInt("savedPos_x");
            int y = stack.getOrCreateNbt().getInt("savedPos_y");
            int z = stack.getOrCreateNbt().getInt("savedPos_z");

            user.teleport(x, y + 1, z);
            user.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
            user.getItemCooldownManager().set(this, 180);
        } else {
            user.sendMessage(Text.translatable("item.mystic_grove.mystic_mirror.no_saved_pos").formatted(Formatting.RED), true);
        }


        return super.use(world, user, hand);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        ItemStack stack = context.getStack();

        stack.damage(1, context.getPlayer(), (player) -> player.sendToolBreakStatus(context.getHand()));

        context.getPlayer().getItemCooldownManager().set(this, 180);
        savedPos = context.getBlockPos();

        if(stack.getOrCreateNbt().contains("savedPos_x")) {
            stack.getOrCreateNbt().remove("savedPos_x");
            stack.getOrCreateNbt().remove("savedPos_y");
            stack.getOrCreateNbt().remove("savedPos_z");
        }

        stack.getOrCreateNbt().putInt("savedPos_x", savedPos.getX());
        stack.getOrCreateNbt().putInt("savedPos_y", savedPos.getY());
        stack.getOrCreateNbt().putInt("savedPos_z", savedPos.getZ());

        if(context.getWorld().isClient) context.getPlayer().sendMessage(Text.translatable("item.mystic_grove.mystic_mirror.use", context.getBlockPos().getX(), context.getBlockPos().getY(), context.getBlockPos().getZ()).formatted(Formatting.AQUA), true);

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(stack.getOrCreateNbt().contains("savedPos_x")) {
            tooltip.add(Text.translatable("item.mystic_grove.mystic_mirror.tooltip_1").formatted(Formatting.GRAY));
            tooltip.add(Text.translatable("item.mystic_grove.mystic_mirror.tooltip_2").formatted(Formatting.GRAY));
            tooltip.add(Text.translatable("item.mystic_grove.mystic_mirror.tooltip_save", stack.getOrCreateNbt().getInt("savedPos_x"), stack.getOrCreateNbt().getInt("savedPos_y"), stack.getOrCreateNbt().getInt("savedPos_z")).formatted(Formatting.GRAY));
        } else {
            tooltip.add(Text.translatable("item.mystic_grove.mystic_mirror.tooltip_1").formatted(Formatting.GRAY));
            tooltip.add(Text.translatable("item.mystic_grove.mystic_mirror.tooltip_2").formatted(Formatting.GRAY));
            tooltip.add(Text.translatable("item.mystic_grove.mystic_mirror.no_saved_pos").formatted(Formatting.RED));
        }
    }
}
