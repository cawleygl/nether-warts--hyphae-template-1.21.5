package bluesteel42.netherhyphae.mixin;

import bluesteel42.netherhyphae.NetherWartsHyphae;
import bluesteel42.netherhyphae.block.ModBlocks;
import bluesteel42.netherhyphae.block.WarpedNetherWartBlock;
import net.minecraft.block.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
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

@Mixin(NetherWartBlock.class)
public class WarpGrowingNetherWartMixin {
    @Inject(method = "randomTick", at = @At("HEAD"), cancellable = true)
    private void injected(BlockState state,
                          ServerWorld world,
                          BlockPos pos,
                          Random random,
                          CallbackInfo ci
    ) {
        int i = (Integer)state.get(NetherWartBlock.AGE);
        if (i < 3 && random.nextInt(25) == 0 &&
            (world.getBlockState(pos.north()).isOf(Blocks.WARPED_STEM) || world.getBlockState(pos.north()).isOf(Blocks.WARPED_HYPHAE) || world.getBlockState(pos.north()).isOf(ModBlocks.WARPED_FUNGUS_BLOCK) || world.getBlockState(pos.north()).isOf(Blocks.WARPED_WART_BLOCK))
            && (world.getBlockState(pos.south()).isOf(Blocks.WARPED_STEM) || world.getBlockState(pos.south()).isOf(Blocks.WARPED_HYPHAE) || world.getBlockState(pos.south()).isOf(ModBlocks.WARPED_FUNGUS_BLOCK) || world.getBlockState(pos.south()).isOf(Blocks.WARPED_WART_BLOCK))
            && (world.getBlockState(pos.east()).isOf(Blocks.WARPED_STEM) || world.getBlockState(pos.east()).isOf(Blocks.WARPED_HYPHAE) || world.getBlockState(pos.east()).isOf(ModBlocks.WARPED_FUNGUS_BLOCK) || world.getBlockState(pos.east()).isOf(Blocks.WARPED_WART_BLOCK))
            && (world.getBlockState(pos.west()).isOf(Blocks.WARPED_STEM) || world.getBlockState(pos.west()).isOf(Blocks.WARPED_HYPHAE) || world.getBlockState(pos.west()).isOf(ModBlocks.WARPED_FUNGUS_BLOCK) || world.getBlockState(pos.west()).isOf(Blocks.WARPED_WART_BLOCK))
            && (world.getBlockState(pos.up()).isOf(Blocks.WARPED_STEM) || world.getBlockState(pos.up()).isOf(Blocks.WARPED_HYPHAE) || world.getBlockState(pos.up()).isOf(ModBlocks.WARPED_FUNGUS_BLOCK) || world.getBlockState(pos.up()).isOf(Blocks.WARPED_WART_BLOCK))
        ) {
            state = ModBlocks.WARPED_NETHER_WART.getDefaultState().with(WarpedNetherWartBlock.AGE, i);
            world.setBlockState(pos, state, Block.NOTIFY_LISTENERS);
            ci.cancel();
        }
    }

}

