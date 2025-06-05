package bluesteel42.netherhyphae.datagen;

import bluesteel42.netherhyphae.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).add(ModBlocks.CRIMSON_FUNGUS_BLOCK);
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).add(ModBlocks.WARPED_FUNGUS_BLOCK);
        getOrCreateTagBuilder(BlockTags.WART_BLOCKS).add(ModBlocks.CRIMSON_FUNGUS_BLOCK);
        getOrCreateTagBuilder(BlockTags.WART_BLOCKS).add(ModBlocks.WARPED_FUNGUS_BLOCK);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.BLUE_NETHER_BRICKS);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.BLUE_NETHER_BRICK_SLAB);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.BLUE_NETHER_BRICK_STAIRS);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.BLUE_NETHER_BRICK_FENCE);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.RED_NETHER_BRICK_FENCE);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.BLACK_NETHER_BRICKS);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.BLACK_NETHER_BRICK_SLAB);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.BLACK_NETHER_BRICK_STAIRS);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.BLACK_NETHER_BRICK_FENCE);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.GLOW_NETHER_BRICKS);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.GLOW_NETHER_BRICK_SLAB);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.GLOW_NETHER_BRICK_STAIRS);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.GLOW_NETHER_BRICK_FENCE);
        getOrCreateTagBuilder(BlockTags.SLABS).add(ModBlocks.BLUE_NETHER_BRICK_SLAB);
        getOrCreateTagBuilder(BlockTags.SLABS).add(ModBlocks.BLACK_NETHER_BRICK_SLAB);
        getOrCreateTagBuilder(BlockTags.SLABS).add(ModBlocks.GLOW_NETHER_BRICK_SLAB);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(ModBlocks.BLUE_NETHER_BRICK_STAIRS);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(ModBlocks.BLACK_NETHER_BRICK_STAIRS);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(ModBlocks.GLOW_NETHER_BRICK_STAIRS);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.BLUE_NETHER_BRICK_WALL);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.BLACK_NETHER_BRICK_WALL);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.GLOW_NETHER_BRICK_WALL);
        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.BLUE_NETHER_BRICK_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.BLACK_NETHER_BRICK_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.GLOW_NETHER_BRICK_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.RED_NETHER_BRICK_FENCE);
    }
}
