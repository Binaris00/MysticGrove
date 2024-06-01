package binaris.mystic_grove.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.stream.Stream;

public class GlowShroom extends Block {
    VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(7, 0, 7, 9, 8, 9),
            Block.createCuboidShape(1, 6, 3, 3, 8, 13),
            Block.createCuboidShape(3, 8, 3, 13, 10, 13),
            Block.createCuboidShape(3, 6, 1, 13, 8, 3),
            Block.createCuboidShape(13, 6, 3, 15, 8, 13),
            Block.createCuboidShape(3, 6, 13, 13, 8, 15)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public GlowShroom() {
        super(FabricBlockSettings.create().breakInstantly().luminance(7).burnable().nonOpaque());
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
