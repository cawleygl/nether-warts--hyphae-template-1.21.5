package bluesteel42.netherhyphae.datagen;

import bluesteel42.netherhyphae.NetherWartsHyphae;
import bluesteel42.netherhyphae.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            private void offerRecipe(CraftingRecipeJsonBuilder recipe, ItemConvertible input) {
                recipe.criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);;
            }
            private void generateBrickBlockRecipe(ItemConvertible block, ItemConvertible ingredient) {
                offerRecipe(createShaped(RecipeCategory.BUILDING_BLOCKS, block)
                        .group("nether_bricks")
                        .input('W', ingredient)
                        .input('N', Items.NETHER_BRICK)
                        .pattern("NW")
                        .pattern("WN"), ingredient);
            }
            private void generateStairsRecipes(ItemConvertible stairsBlock, ItemConvertible brickBlock) {
                offerRecipe(createShaped(RecipeCategory.BUILDING_BLOCKS, stairsBlock, 4).group("nether_brick_stairs").input('#', Ingredient.ofItem(brickBlock)).pattern("#  ").pattern("## ").pattern("###"), brickBlock);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, stairsBlock, brickBlock);
            }
            private void generateSlabRecipes(ItemConvertible slabBlock, ItemConvertible brickBlock) {
                offerRecipe(createShaped(RecipeCategory.BUILDING_BLOCKS, slabBlock, 6).group("nether_brick_slab").input('#', Ingredient.ofItem(brickBlock)).pattern("###"), brickBlock);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, slabBlock, brickBlock, 2);
            }
            private void generateFenceRecipe(ItemConvertible fenceBlock, ItemConvertible brickBlock) {
                offerRecipe(createShaped(RecipeCategory.DECORATIONS, fenceBlock, 6)
                        .group("nether_brick_fence")
                        .input('#', Items.NETHER_BRICK)
                        .input('W', brickBlock)
                        .pattern("W#W")
                        .pattern("W#W"), brickBlock);
            }
            private void generateWallRecipes(ItemConvertible wallBlock, ItemConvertible brickBlock) {
                offerRecipe(createShaped(RecipeCategory.DECORATIONS, wallBlock, 6).group("nether_brick_wall").input('#', Ingredient.ofItem(brickBlock)).pattern("###").pattern("###"), brickBlock);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, wallBlock, brickBlock);
            }
            private void generateCrackedRecipe(ItemConvertible crackedBlock, ItemConvertible brickBlock) {
                offerRecipe(CookingRecipeJsonBuilder.createSmelting(
                                Ingredient.ofItem(brickBlock), RecipeCategory.BUILDING_BLOCKS, crackedBlock.asItem(), 0.1F, 200
                        ), brickBlock);
            }
            private void generateChiseledRecipes(ItemConvertible chiseledBlock, ItemConvertible brickBlock, ItemConvertible slabBlock) {
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, chiseledBlock, brickBlock);
                offerChiseledBlockRecipe(RecipeCategory.BUILDING_BLOCKS, chiseledBlock, slabBlock);
            }
            private void generateColorNetherBrickBlockRecipes(ItemConvertible ingredient, ItemConvertible brickBlock, ItemConvertible stairsBlock, ItemConvertible slabBlock, ItemConvertible wallBlock, ItemConvertible fenceBlock, ItemConvertible chiseledBlock, ItemConvertible crackedBlock) {
                generateBrickBlockRecipe(brickBlock, ingredient);
                generateColorNetherBrickBlockRecipes(brickBlock, stairsBlock, slabBlock, wallBlock, fenceBlock, chiseledBlock, crackedBlock);
            }
            private void generateColorNetherBrickBlockRecipes(ItemConvertible brickBlock, ItemConvertible stairsBlock, ItemConvertible slabBlock, ItemConvertible wallBlock, ItemConvertible fenceBlock, ItemConvertible chiseledBlock, ItemConvertible crackedBlock) {
                generateStairsRecipes(stairsBlock, brickBlock);
                generateSlabRecipes(slabBlock, brickBlock);
                generateWallRecipes(wallBlock, brickBlock);
                generateFenceRecipe(fenceBlock, brickBlock);
                generateChiseledRecipes(chiseledBlock, brickBlock, slabBlock);
                generateCrackedRecipe(crackedBlock, brickBlock);
            }

            @Override
            public void generate() {
                generateFenceRecipe(ModBlocks.RED_NETHER_BRICK_FENCE, ModBlocks.RED_NETHER_BRICKS);
                generateChiseledRecipes(ModBlocks.CHISELED_RED_NETHER_BRICKS, ModBlocks.RED_NETHER_BRICKS, ModBlocks.RED_NETHER_BRICK_SLAB);
                generateCrackedRecipe(ModBlocks.CRACKED_RED_NETHER_BRICKS, ModBlocks.RED_NETHER_BRICKS);
//                generateColorNetherBrickBlockRecipes(Items.NETHER_WART, ModBlocks.RED_NETHER_BRICKS, ModBlocks.RED_NETHER_BRICK_STAIRS, ModBlocks.RED_NETHER_BRICK_SLAB, ModBlocks.RED_NETHER_BRICK_WALL, ModBlocks.RED_NETHER_BRICK_FENCE, ModBlocks.CHISELED_RED_NETHER_BRICKS, ModBlocks.CRACKED_RED_NETHER_BRICKS);
                generateColorNetherBrickBlockRecipes(ModBlocks.WARPED_NETHER_WART, ModBlocks.BLUE_NETHER_BRICKS, ModBlocks.BLUE_NETHER_BRICK_STAIRS, ModBlocks.BLUE_NETHER_BRICK_SLAB, ModBlocks.BLUE_NETHER_BRICK_WALL, ModBlocks.BLUE_NETHER_BRICK_FENCE, ModBlocks.CHISELED_BLUE_NETHER_BRICKS, ModBlocks.CRACKED_BLUE_NETHER_BRICKS);
                generateColorNetherBrickBlockRecipes(Items.FLINT, ModBlocks.BLACK_NETHER_BRICKS, ModBlocks.BLACK_NETHER_BRICK_STAIRS, ModBlocks.BLACK_NETHER_BRICK_SLAB, ModBlocks.BLACK_NETHER_BRICK_WALL, ModBlocks.BLACK_NETHER_BRICK_FENCE, ModBlocks.CHISELED_BLACK_NETHER_BRICKS, ModBlocks.CRACKED_BLACK_NETHER_BRICKS);
                generateColorNetherBrickBlockRecipes(Items.GLOWSTONE_DUST, ModBlocks.GLOW_NETHER_BRICKS, ModBlocks.GLOW_NETHER_BRICK_STAIRS, ModBlocks.GLOW_NETHER_BRICK_SLAB, ModBlocks.GLOW_NETHER_BRICK_WALL, ModBlocks.GLOW_NETHER_BRICK_FENCE, ModBlocks.CHISELED_GLOW_NETHER_BRICKS, ModBlocks.CRACKED_GLOW_NETHER_BRICKS);
                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModBlocks.WARPED_NETHER_WART.asItem(), RecipeCategory.BUILDING_BLOCKS, Blocks.WARPED_WART_BLOCK);
                offerRecipe(createShapeless(RecipeCategory.MISC, Items.NETHER_WART, 9).input(Blocks.NETHER_WART_BLOCK), Blocks.NETHER_WART_BLOCK);
            }
        };
    }

    @Override
    public String getName() {
        return NetherWartsHyphae.MOD_ID + " recipes";
    }
}
