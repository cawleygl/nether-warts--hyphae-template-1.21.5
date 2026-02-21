package bluesteel42.netherhyphae.datagen;

import bluesteel42.netherhyphae.block.ModBlocks;
import bluesteel42.netherhyphae.block.WarpedNetherWartBlock;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CRIMSON_FUNGUS_BLOCK, block -> this.mushroomBlockDrops(block, ModBlocks.CRIMSON_FUNGUS_BLOCK));
        addDrop(ModBlocks.WARPED_FUNGUS_BLOCK, block -> this.mushroomBlockDrops(block, ModBlocks.WARPED_FUNGUS_BLOCK));

        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        addDrop(
                ModBlocks.WARPED_NETHER_WART,
                block -> LootTable.builder()
                        .pool(
                                this.applyExplosionDecay(
                                        block,
                                        LootPool.builder()
                                                .rolls(ConstantLootNumberProvider.create(1.0F))
                                                .with(
                                                        ItemEntry.builder(ModBlocks.WARPED_NETHER_WART.asItem())
                                                                .apply(
                                                                        SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 4.0F))
                                                                                .conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(WarpedNetherWartBlock.AGE, 3)))
                                                                )
                                                                .apply(
                                                                        ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))
                                                                                .conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(WarpedNetherWartBlock.AGE, 3)))
                                                                )
                                                )
                                )
                        )
        );

        addDrop(ModBlocks.RED_NETHER_BRICKS);
        addDrop(ModBlocks.CHISELED_RED_NETHER_BRICKS);
        addDrop(ModBlocks.CRACKED_RED_NETHER_BRICKS);
        addDrop(ModBlocks.RED_NETHER_BRICK_STAIRS);
        addDrop(ModBlocks.RED_NETHER_BRICK_SLAB, this::slabDrops);
        addDrop(ModBlocks.RED_NETHER_BRICK_WALL);
        addDrop(ModBlocks.RED_NETHER_BRICK_FENCE);
        addDrop(ModBlocks.BLUE_NETHER_BRICKS);
        addDrop(ModBlocks.CHISELED_BLUE_NETHER_BRICKS);
        addDrop(ModBlocks.CRACKED_BLUE_NETHER_BRICKS);
        addDrop(ModBlocks.BLUE_NETHER_BRICK_STAIRS);
        addDrop(ModBlocks.BLUE_NETHER_BRICK_SLAB, this::slabDrops);
        addDrop(ModBlocks.BLUE_NETHER_BRICK_WALL);
        addDrop(ModBlocks.BLUE_NETHER_BRICK_FENCE);
        addDrop(ModBlocks.BLACK_NETHER_BRICKS);
        addDrop(ModBlocks.CHISELED_BLACK_NETHER_BRICKS);
        addDrop(ModBlocks.CRACKED_BLACK_NETHER_BRICKS);
        addDrop(ModBlocks.BLACK_NETHER_BRICK_STAIRS);
        addDrop(ModBlocks.BLACK_NETHER_BRICK_SLAB, this::slabDrops);
        addDrop(ModBlocks.BLACK_NETHER_BRICK_WALL);
        addDrop(ModBlocks.BLACK_NETHER_BRICK_FENCE);
        addDrop(ModBlocks.GLOW_NETHER_BRICKS);
        addDrop(ModBlocks.CHISELED_GLOW_NETHER_BRICKS);
        addDrop(ModBlocks.CRACKED_GLOW_NETHER_BRICKS);
        addDrop(ModBlocks.GLOW_NETHER_BRICK_STAIRS);
        addDrop(ModBlocks.GLOW_NETHER_BRICK_SLAB, this::slabDrops);
        addDrop(ModBlocks.GLOW_NETHER_BRICK_WALL);
        addDrop(ModBlocks.GLOW_NETHER_BRICK_FENCE);

    }
}
