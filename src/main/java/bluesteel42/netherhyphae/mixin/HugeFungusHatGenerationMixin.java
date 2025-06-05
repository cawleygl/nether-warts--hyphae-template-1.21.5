package bluesteel42.netherhyphae.mixin;

import bluesteel42.netherhyphae.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.HugeFungusFeature;
import net.minecraft.world.gen.feature.HugeFungusFeatureConfig;
import net.minecraft.world.gen.feature.WeepingVinesFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HugeFungusFeature.class)
public class HugeFungusHatGenerationMixin {
    @Unique
    private static boolean isReplaceable(StructureWorldAccess world, BlockPos pos, HugeFungusFeatureConfig config, boolean checkConfig) {
        if (world.testBlockState(pos, AbstractBlock.AbstractBlockState::isReplaceable)) {
            return true;
        } else {
            return checkConfig ? config.replaceableBlocks.test(world, pos) : false;
        }
    }

    private static void generateVines(BlockPos pos, WorldAccess world, Random random) {
        BlockPos.Mutable mutable = pos.mutableCopy().move(Direction.DOWN);
        if (world.isAir(mutable)) {
            int i = MathHelper.nextInt(random, 1, 5);
            if (random.nextInt(7) == 0) {
                i *= 2;
            }

            int j = 23;
            int k = 25;
            WeepingVinesFeature.generateVineColumn(world, random, mutable, i, 23, 25);
        }
    }

    private void replaceFungusBlock(WorldAccess world, HugeFungusFeatureConfig config, BlockPos.Mutable pos, BlockState state) {
        boolean up = true, down = true, north = true, south = true, east = true, west = true;
        if (world.getBlockState(pos.down()).isOf(state.getBlock()) || world.getBlockState(pos.down()).isOf(config.decorationState.getBlock()) || world.getBlockState(pos.down()).isOf(config.stemState.getBlock())) {
            down = false;
        }
        if (world.getBlockState(pos.up()).isOf(state.getBlock()) || world.getBlockState(pos.up()).isOf(config.decorationState.getBlock()) || world.getBlockState(pos.up()).isOf(config.stemState.getBlock())) {
            up = false;
        }
        if (world.getBlockState(pos.north()).isOf(state.getBlock()) || world.getBlockState(pos.north()).isOf(config.decorationState.getBlock()) || world.getBlockState(pos.north()).isOf(config.stemState.getBlock())) {
            north = false;
        }
        if (world.getBlockState(pos.south()).isOf(state.getBlock()) || world.getBlockState(pos.south()).isOf(config.decorationState.getBlock()) || world.getBlockState(pos.south()).isOf(config.stemState.getBlock())) {
            south = false;
        }
        if (world.getBlockState(pos.east()).isOf(state.getBlock()) || world.getBlockState(pos.east()).isOf(config.decorationState.getBlock()) || world.getBlockState(pos.east()).isOf(config.stemState.getBlock())) {
            east = false;
        }
        if (world.getBlockState(pos.west()).isOf(state.getBlock()) || world.getBlockState(pos.west()).isOf(config.decorationState.getBlock()) || world.getBlockState(pos.west()).isOf(config.stemState.getBlock())) {
            west = false;
        }
        state = state.with(MushroomBlock.DOWN, down)
                .with(MushroomBlock.UP, up)
                .with(MushroomBlock.NORTH, north)
                .with(MushroomBlock.SOUTH, south)
                .with(MushroomBlock.EAST, east)
                .with(MushroomBlock.WEST, west);

        world.setBlockState(pos, state, Block.NOTIFY_ALL);
    }

    @Unique
    private void placeWithOptionalVines(WorldAccess world, Random random, HugeFungusFeatureConfig config, BlockPos.Mutable pos, boolean vines) {
        if (world.getBlockState(pos.down()).isOf(config.hatState.getBlock())) {
            world.setBlockState(pos, config.hatState, Block.NOTIFY_ALL);
        } else if (random.nextFloat() < 0.15) {
            world.setBlockState(pos, config.hatState, Block.NOTIFY_ALL);
            if (vines && random.nextInt(11) == 0) {
                generateVines(pos, world, random);
            }
        }
    }

    @Unique
    private void placeHatBlock(
            WorldAccess world, Random random, HugeFungusFeatureConfig config, BlockPos.Mutable pos, float decorationChance, float generationChance, float vineChance
    ) {
        if (random.nextFloat() < decorationChance) {
            world.setBlockState(pos, config.decorationState, Block.NOTIFY_ALL);
        } else if (random.nextFloat() < generationChance) {
            world.setBlockState(pos, config.hatState, Block.NOTIFY_ALL);
            if (random.nextFloat() < vineChance) {
                generateVines(pos, world, random);
            }
        }
    }

    @Inject(at = @At("HEAD"), method = "generateHat", cancellable = true)
    private void init(StructureWorldAccess world, Random random, HugeFungusFeatureConfig config, BlockPos pos, int hatHeight, boolean thickStem, CallbackInfo info) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        boolean crimson = config.hatState.isOf(ModBlocks.CRIMSON_FUNGUS_BLOCK);
        int i = Math.min(random.nextInt(1 + hatHeight / 3) + 5, hatHeight);
        int j = hatHeight - i;
        int o = random.nextInt(3);

        for (int k = j; k <= hatHeight; k++) {
            int l = k < hatHeight - o ? 2 : 1;
            if (i > 8 && k < j + 4) {
                l = 3;
            }

            if (thickStem) {
                l++;
            }

            for (int m = -l; m <= l; m++) {
                for (int n = -l; n <= l; n++) {
                    boolean bl2 = m == -l || m == l;
                    boolean bl3 = n == -l || n == l;
                    boolean bl4 = !bl2 && !bl3 && k != hatHeight;
                    boolean bl5 = bl2 && bl3;
                    boolean bl6 = k < j + 3;
                    mutable.set(pos, m, k, n);
                    if (isReplaceable(world, mutable, config, false)) {
                        if (config.planted && !world.getBlockState(mutable.down()).isAir()) {
                            world.breakBlock(mutable, true);
                        }

                        if (bl6) {
                            if (!bl4) {
                                this.placeWithOptionalVines(world, random, config, mutable, crimson);
                            }
                        } else if (bl4) {
                            this.placeHatBlock(world, random, config, mutable, 0.1F, 0.2F, crimson ? 0.1F : 0.0F);
                        } else if (bl5) {
                            this.placeHatBlock(world, random, config, mutable, 0.01F, 0.7F, crimson ? 0.083F : 0.0F);
                        } else {
                            this.placeHatBlock(world, random, config, mutable, 5.0E-4F, 0.98F, crimson ? 0.07F : 0.0F);
                        }
                    }
                }
            }
        }
        mutable = new BlockPos.Mutable();

        for (int k = j; k <= hatHeight; k++) {
            int l = k < hatHeight - o ? 2 : 1;
            if (i > 8 && k < j + 4) {
                l = 3;
            }

            if (thickStem) {
                l++;
            }

            for (int m = -l; m <= l; m++) {
                for (int n = -l; n <= l; n++) {
                    boolean bl2 = m == -l || m == l;
                    boolean bl3 = n == -l || n == l;
                    boolean bl4 = !bl2 && !bl3 && k != hatHeight;
                    boolean bl5 = bl2 && bl3;
                    boolean bl6 = k < j + 3;
                    mutable.set(pos, m, k, n);
                    if (world.getBlockState(mutable).isOf(config.hatState.getBlock())) {
                        replaceFungusBlock(world, config, mutable, config.hatState);
                    }

                }
            }
        }

        info.cancel();
    }
}