package bluesteel42.netherhyphae.mixin;

import bluesteel42.netherhyphae.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.structure.NetherFortressGenerator;
import net.minecraft.structure.StructureContext;
import net.minecraft.structure.StructurePiece;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetherFortressGenerator.CorridorNetherWartsRoom.class)
public class WarpedNetherWartsInFortressesMixin extends StructurePiece {
    protected WarpedNetherWartsInFortressesMixin(StructurePieceType structurePieceType, int i, BlockBox blockBox) {
        super(structurePieceType, i, blockBox);
    }

    @Override
    protected void writeNbt(StructureContext context, NbtCompound nbt) {

    }

    @Inject(method = "generate", at = @At("HEAD"), cancellable = true)
    private void injected(StructureWorldAccess world,
                          StructureAccessor structureAccessor,
                          ChunkGenerator chunkGenerator,
                          Random random,
                          BlockBox chunkBox,
                          ChunkPos chunkPos,
                          BlockPos pivot,
                          CallbackInfo ci
    ) {
        this.fillWithOutline(world, chunkBox, 0, 3, 0, 12, 4, 12, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
        this.fillWithOutline(world, chunkBox, 0, 5, 0, 12, 13, 12, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
        this.fillWithOutline(world, chunkBox, 0, 5, 0, 1, 12, 12, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
        this.fillWithOutline(world, chunkBox, 11, 5, 0, 12, 12, 12, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
        this.fillWithOutline(world, chunkBox, 2, 5, 11, 4, 12, 12, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
        this.fillWithOutline(world, chunkBox, 8, 5, 11, 10, 12, 12, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
        this.fillWithOutline(world, chunkBox, 5, 9, 11, 7, 12, 12, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
        this.fillWithOutline(world, chunkBox, 2, 5, 0, 4, 12, 1, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
        this.fillWithOutline(world, chunkBox, 8, 5, 0, 10, 12, 1, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
        this.fillWithOutline(world, chunkBox, 5, 9, 0, 7, 12, 1, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
        this.fillWithOutline(world, chunkBox, 2, 11, 2, 10, 12, 10, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
        BlockState blockState = Blocks.NETHER_BRICK_FENCE.getDefaultState().with(FenceBlock.WEST, true).with(FenceBlock.EAST, true);
        BlockState blockState2 = Blocks.NETHER_BRICK_FENCE.getDefaultState().with(FenceBlock.NORTH, true).with(FenceBlock.SOUTH, true);
        BlockState blockState3 = blockState2.with(FenceBlock.WEST, true);
        BlockState blockState4 = blockState2.with(FenceBlock.EAST, true);

        for (int i = 1; i <= 11; i += 2) {
            this.fillWithOutline(world, chunkBox, i, 10, 0, i, 11, 0, blockState, blockState, false);
            this.fillWithOutline(world, chunkBox, i, 10, 12, i, 11, 12, blockState, blockState, false);
            this.fillWithOutline(world, chunkBox, 0, 10, i, 0, 11, i, blockState2, blockState2, false);
            this.fillWithOutline(world, chunkBox, 12, 10, i, 12, 11, i, blockState2, blockState2, false);
            this.addBlock(world, Blocks.NETHER_BRICKS.getDefaultState(), i, 13, 0, chunkBox);
            this.addBlock(world, Blocks.NETHER_BRICKS.getDefaultState(), i, 13, 12, chunkBox);
            this.addBlock(world, Blocks.NETHER_BRICKS.getDefaultState(), 0, 13, i, chunkBox);
            this.addBlock(world, Blocks.NETHER_BRICKS.getDefaultState(), 12, 13, i, chunkBox);
            if (i != 11) {
                this.addBlock(world, blockState, i + 1, 13, 0, chunkBox);
                this.addBlock(world, blockState, i + 1, 13, 12, chunkBox);
                this.addBlock(world, blockState2, 0, 13, i + 1, chunkBox);
                this.addBlock(world, blockState2, 12, 13, i + 1, chunkBox);
            }
        }

        this.addBlock(world, Blocks.NETHER_BRICK_FENCE.getDefaultState().with(FenceBlock.NORTH, true).with(FenceBlock.EAST, true), 0, 13, 0, chunkBox);
        this.addBlock(world, Blocks.NETHER_BRICK_FENCE.getDefaultState().with(FenceBlock.SOUTH, true).with(FenceBlock.EAST, true), 0, 13, 12, chunkBox);
        this.addBlock(world, Blocks.NETHER_BRICK_FENCE.getDefaultState().with(FenceBlock.SOUTH, true).with(FenceBlock.WEST, true), 12, 13, 12, chunkBox);
        this.addBlock(world, Blocks.NETHER_BRICK_FENCE.getDefaultState().with(FenceBlock.NORTH, true).with(FenceBlock.WEST, true), 12, 13, 0, chunkBox);

        for (int ix = 3; ix <= 9; ix += 2) {
            this.fillWithOutline(world, chunkBox, 1, 7, ix, 1, 8, ix, blockState3, blockState3, false);
            this.fillWithOutline(world, chunkBox, 11, 7, ix, 11, 8, ix, blockState4, blockState4, false);
        }

        BlockState blockState5 = Blocks.NETHER_BRICK_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.NORTH);

        for (int j = 0; j <= 6; j++) {
            int k = j + 4;

            for (int l = 5; l <= 7; l++) {
                this.addBlock(world, blockState5, l, 5 + j, k, chunkBox);
            }

            if (k >= 5 && k <= 8) {
                this.fillWithOutline(world, chunkBox, 5, 5, k, 7, j + 4, k, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
            } else if (k >= 9 && k <= 10) {
                this.fillWithOutline(world, chunkBox, 5, 8, k, 7, j + 4, k, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
            }

            if (j >= 1) {
                this.fillWithOutline(world, chunkBox, 5, 6 + j, k, 7, 9 + j, k, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
        }

        for (int j = 5; j <= 7; j++) {
            this.addBlock(world, blockState5, j, 12, 11, chunkBox);
        }

        this.fillWithOutline(world, chunkBox, 5, 6, 7, 5, 7, 7, blockState4, blockState4, false);
        this.fillWithOutline(world, chunkBox, 7, 6, 7, 7, 7, 7, blockState3, blockState3, false);
        this.fillWithOutline(world, chunkBox, 5, 13, 12, 7, 13, 12, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
        this.fillWithOutline(world, chunkBox, 2, 5, 2, 3, 5, 3, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
        this.fillWithOutline(world, chunkBox, 2, 5, 9, 3, 5, 10, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
        this.fillWithOutline(world, chunkBox, 2, 5, 4, 2, 5, 8, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
        this.fillWithOutline(world, chunkBox, 9, 5, 2, 10, 5, 3, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
        this.fillWithOutline(world, chunkBox, 9, 5, 9, 10, 5, 10, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
        this.fillWithOutline(world, chunkBox, 10, 5, 4, 10, 5, 8, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
        BlockState blockState6 = blockState5.with(StairsBlock.FACING, Direction.EAST);
        BlockState blockState7 = blockState5.with(StairsBlock.FACING, Direction.WEST);
        this.addBlock(world, blockState7, 4, 5, 2, chunkBox);
        this.addBlock(world, blockState7, 4, 5, 3, chunkBox);
        this.addBlock(world, blockState7, 4, 5, 9, chunkBox);
        this.addBlock(world, blockState7, 4, 5, 10, chunkBox);
        this.addBlock(world, blockState6, 8, 5, 2, chunkBox);
        this.addBlock(world, blockState6, 8, 5, 3, chunkBox);
        this.addBlock(world, blockState6, 8, 5, 9, chunkBox);
        this.addBlock(world, blockState6, 8, 5, 10, chunkBox);
        this.fillWithOutline(world, chunkBox, 3, 4, 4, 4, 4, 8, Blocks.SOUL_SAND.getDefaultState(), Blocks.SOUL_SAND.getDefaultState(), false);
        this.fillWithOutline(world, chunkBox, 8, 4, 4, 9, 4, 8, Blocks.SOUL_SAND.getDefaultState(), Blocks.SOUL_SAND.getDefaultState(), false);
        this.fillWithOutline(world, chunkBox, 3, 5, 4, 4, 5, 8, Blocks.NETHER_WART.getDefaultState(), Blocks.NETHER_WART.getDefaultState(), false);
        this.fillWithOutline(world, chunkBox, 8, 5, 4, 9, 5, 8, ModBlocks.WARPED_NETHER_WART.getDefaultState(), ModBlocks.WARPED_NETHER_WART.getDefaultState(), false);
        this.fillWithOutline(world, chunkBox, 4, 2, 0, 8, 2, 12, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
        this.fillWithOutline(world, chunkBox, 0, 2, 4, 12, 2, 8, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
        this.fillWithOutline(world, chunkBox, 4, 0, 0, 8, 1, 3, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
        this.fillWithOutline(world, chunkBox, 4, 0, 9, 8, 1, 12, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
        this.fillWithOutline(world, chunkBox, 0, 0, 4, 3, 1, 8, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
        this.fillWithOutline(world, chunkBox, 9, 0, 4, 12, 1, 8, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);

        for (int l = 4; l <= 8; l++) {
            for (int m = 0; m <= 2; m++) {
                this.fillDownwards(world, Blocks.NETHER_BRICKS.getDefaultState(), l, -1, m, chunkBox);
                this.fillDownwards(world, Blocks.NETHER_BRICKS.getDefaultState(), l, -1, 12 - m, chunkBox);
            }
        }

        for (int l = 0; l <= 2; l++) {
            for (int m = 4; m <= 8; m++) {
                this.fillDownwards(world, Blocks.NETHER_BRICKS.getDefaultState(), l, -1, m, chunkBox);
                this.fillDownwards(world, Blocks.NETHER_BRICKS.getDefaultState(), 12 - l, -1, m, chunkBox);
            }
        }
            ci.cancel();
        }

    @Override
    public void generate(StructureWorldAccess world, StructureAccessor structureAccessor, ChunkGenerator chunkGenerator, Random random, BlockBox chunkBox, ChunkPos chunkPos, BlockPos pivot) {

    }
}

