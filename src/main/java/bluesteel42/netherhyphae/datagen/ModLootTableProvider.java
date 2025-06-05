package bluesteel42.netherhyphae.datagen;

import bluesteel42.netherhyphae.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
//        addDrop(ModBlocks.MOSSY_BRICKS);
//        addDrop(ModBlocks.MOSSY_BRICK_STAIRS);
//        addDrop(ModBlocks.MOSSY_BRICK_SLAB, slabDrops(ModBlocks.MOSSY_BRICK_SLAB));
//        addDrop(ModBlocks.MOSSY_BRICK_WALL);

    }
}
