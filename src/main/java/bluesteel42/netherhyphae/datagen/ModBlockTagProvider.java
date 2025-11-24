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
        valueLookupBuilder(BlockTags.AXE_MINEABLE).add(ModBlocks.CRIMSON_FUNGUS_BLOCK);
        valueLookupBuilder(BlockTags.AXE_MINEABLE).add(ModBlocks.WARPED_FUNGUS_BLOCK);
        valueLookupBuilder(BlockTags.WART_BLOCKS).add(ModBlocks.CRIMSON_FUNGUS_BLOCK);
        valueLookupBuilder(BlockTags.WART_BLOCKS).add(ModBlocks.WARPED_FUNGUS_BLOCK);

        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.BLUE_NETHER_BRICKS);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.BLUE_NETHER_BRICK_SLAB);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.BLUE_NETHER_BRICK_STAIRS);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.BLUE_NETHER_BRICK_FENCE);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.RED_NETHER_BRICK_FENCE);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.BLACK_NETHER_BRICKS);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.BLACK_NETHER_BRICK_SLAB);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.BLACK_NETHER_BRICK_STAIRS);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.BLACK_NETHER_BRICK_FENCE);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.GLOW_NETHER_BRICKS);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.GLOW_NETHER_BRICK_SLAB);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.GLOW_NETHER_BRICK_STAIRS);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.GLOW_NETHER_BRICK_FENCE);
        valueLookupBuilder(BlockTags.SLABS).add(ModBlocks.BLUE_NETHER_BRICK_SLAB);
        valueLookupBuilder(BlockTags.SLABS).add(ModBlocks.BLACK_NETHER_BRICK_SLAB);
        valueLookupBuilder(BlockTags.SLABS).add(ModBlocks.GLOW_NETHER_BRICK_SLAB);
        valueLookupBuilder(BlockTags.STAIRS).add(ModBlocks.BLUE_NETHER_BRICK_STAIRS);
        valueLookupBuilder(BlockTags.STAIRS).add(ModBlocks.BLACK_NETHER_BRICK_STAIRS);
        valueLookupBuilder(BlockTags.STAIRS).add(ModBlocks.GLOW_NETHER_BRICK_STAIRS);
        valueLookupBuilder(BlockTags.WALLS).add(ModBlocks.BLUE_NETHER_BRICK_WALL);
        valueLookupBuilder(BlockTags.WALLS).add(ModBlocks.BLACK_NETHER_BRICK_WALL);
        valueLookupBuilder(BlockTags.WALLS).add(ModBlocks.GLOW_NETHER_BRICK_WALL);
        valueLookupBuilder(BlockTags.FENCES).add(ModBlocks.BLUE_NETHER_BRICK_FENCE);
        valueLookupBuilder(BlockTags.FENCES).add(ModBlocks.BLACK_NETHER_BRICK_FENCE);
        valueLookupBuilder(BlockTags.FENCES).add(ModBlocks.GLOW_NETHER_BRICK_FENCE);
        valueLookupBuilder(BlockTags.FENCES).add(ModBlocks.RED_NETHER_BRICK_FENCE);
    }
}
