package bluesteel42.netherhyphae.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class WarpedNetherWartBlock extends PlantBlock {
    public static final MapCodec<bluesteel42.netherhyphae.block.WarpedNetherWartBlock> CODEC = createCodec(bluesteel42.netherhyphae.block.WarpedNetherWartBlock::new);
    public static final int MAX_AGE = 3;
    public static final IntProperty AGE = Properties.AGE_3;
    private static final VoxelShape[] SHAPES_BY_AGE = Block.createShapeArray(3, age -> Block.createColumnShape(16.0, 0.0, 5 + age * 3));

    @Override
    public MapCodec<bluesteel42.netherhyphae.block.WarpedNetherWartBlock> getCodec() {
        return CODEC;
    }

    public WarpedNetherWartBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(AGE, 0));
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPES_BY_AGE[state.get(AGE)];
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.SOUL_SAND);
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return (Integer)state.get(AGE) < 3;
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int i = (Integer)state.get(AGE);
        if (i < 3 && random.nextInt(10) == 0) {
            state = state.with(AGE, i + 1);
            world.setBlockState(pos, state, Block.NOTIFY_LISTENERS);
        }
    }

    @Override
    protected ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state, boolean includeData) {
        return new ItemStack(ModBlocks.WARPED_NETHER_WART.asItem());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
