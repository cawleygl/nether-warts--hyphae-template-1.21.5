package bluesteel42.netherhyphae.datagen;

import bluesteel42.netherhyphae.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ItemTags.WART_BLOCKS).add(ModBlocks.CRIMSON_FUNGUS_BLOCK.asItem());
        valueLookupBuilder(ItemTags.WART_BLOCKS).add(ModBlocks.WARPED_FUNGUS_BLOCK.asItem());

        valueLookupBuilder(ItemTags.SLABS).add(ModBlocks.BLUE_NETHER_BRICK_SLAB.asItem());
        valueLookupBuilder(ItemTags.STAIRS).add(ModBlocks.BLUE_NETHER_BRICK_STAIRS.asItem());
        valueLookupBuilder(ItemTags.WALLS).add(ModBlocks.BLUE_NETHER_BRICK_WALL.asItem());
        valueLookupBuilder(ItemTags.FENCES).add(ModBlocks.BLUE_NETHER_BRICK_FENCE.asItem());
        valueLookupBuilder(ItemTags.SLABS).add(ModBlocks.BLACK_NETHER_BRICK_SLAB.asItem());
        valueLookupBuilder(ItemTags.STAIRS).add(ModBlocks.BLACK_NETHER_BRICK_STAIRS.asItem());
        valueLookupBuilder(ItemTags.WALLS).add(ModBlocks.BLACK_NETHER_BRICK_WALL.asItem());
        valueLookupBuilder(ItemTags.FENCES).add(ModBlocks.BLACK_NETHER_BRICK_FENCE.asItem());
        valueLookupBuilder(ItemTags.SLABS).add(ModBlocks.GLOW_NETHER_BRICK_SLAB.asItem());
        valueLookupBuilder(ItemTags.STAIRS).add(ModBlocks.GLOW_NETHER_BRICK_STAIRS.asItem());
        valueLookupBuilder(ItemTags.WALLS).add(ModBlocks.GLOW_NETHER_BRICK_WALL.asItem());
        valueLookupBuilder(ItemTags.FENCES).add(ModBlocks.GLOW_NETHER_BRICK_FENCE.asItem());
        valueLookupBuilder(ItemTags.FENCES).add(ModBlocks.RED_NETHER_BRICK_FENCE.asItem());
    }
}
