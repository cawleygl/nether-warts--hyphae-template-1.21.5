package bluesteel42.netherhyphae.datagen;

import bluesteel42.netherhyphae.NetherWartsHyphae;
import bluesteel42.netherhyphae.block.ModBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    private void deprecateBlock(BlockStateModelGenerator blockStateModelGenerator, ItemConvertible block) {
        Identifier deprecatedBlock = Identifier.of(NetherWartsHyphae.MOD_ID, "item/deprecated");
        blockStateModelGenerator.itemModelOutput.accept(block.asItem(), ItemModels.basic(deprecatedBlock));
    }

    private void generateFungusBlocks(BlockStateModelGenerator blockStateModelGenerator) {
        Identifier netherMushroomBlock = Identifier.of(NetherWartsHyphae.MOD_ID, "block/fungus_block_inside");
        Models.TEMPLATE_SINGLE_FACE.upload(netherMushroomBlock, TextureMap.texture(netherMushroomBlock), blockStateModelGenerator.modelCollector);
        generateFungusBlock(blockStateModelGenerator, ModBlocks.CRIMSON_FUNGUS_BLOCK, netherMushroomBlock);
        generateFungusBlock(blockStateModelGenerator, ModBlocks.WARPED_FUNGUS_BLOCK, netherMushroomBlock);
    }
    private void generateFungusBlock(BlockStateModelGenerator blockStateModelGenerator, Block block, Identifier netherMushroomBlock) {
        WeightedVariant weightedVariant7 = BlockStateModelGenerator.createWeightedVariant(
                Models.TEMPLATE_SINGLE_FACE.upload(block, TextureMap.texture(block), blockStateModelGenerator.modelCollector)
        );
        WeightedVariant weightedVariant8 = BlockStateModelGenerator.createWeightedVariant(netherMushroomBlock);
        blockStateModelGenerator.blockStateCollector
                .accept(
                        MultipartBlockModelDefinitionCreator.create(block)
                                .with(BlockStateModelGenerator.createMultipartConditionBuilder().put(Properties.NORTH, true), weightedVariant7)
                                .with(BlockStateModelGenerator.createMultipartConditionBuilder().put(Properties.EAST, true), weightedVariant7.apply(BlockStateModelGenerator.ROTATE_Y_90).apply(BlockStateModelGenerator.UV_LOCK))
                                .with(BlockStateModelGenerator.createMultipartConditionBuilder().put(Properties.SOUTH, true), weightedVariant7.apply(BlockStateModelGenerator.ROTATE_Y_180).apply(BlockStateModelGenerator.UV_LOCK))
                                .with(BlockStateModelGenerator.createMultipartConditionBuilder().put(Properties.WEST, true), weightedVariant7.apply(BlockStateModelGenerator.ROTATE_Y_270).apply(BlockStateModelGenerator.UV_LOCK))
                                .with(BlockStateModelGenerator.createMultipartConditionBuilder().put(Properties.UP, true), weightedVariant7.apply(BlockStateModelGenerator.ROTATE_X_270).apply(BlockStateModelGenerator.UV_LOCK))
                                .with(BlockStateModelGenerator.createMultipartConditionBuilder().put(Properties.DOWN, true), weightedVariant7.apply(BlockStateModelGenerator.ROTATE_X_90).apply(BlockStateModelGenerator.UV_LOCK))
                                .with(BlockStateModelGenerator.createMultipartConditionBuilder().put(Properties.NORTH, false), weightedVariant8)
                                .with(BlockStateModelGenerator.createMultipartConditionBuilder().put(Properties.EAST, false), weightedVariant8.apply(BlockStateModelGenerator.ROTATE_Y_90))
                                .with(BlockStateModelGenerator.createMultipartConditionBuilder().put(Properties.SOUTH, false), weightedVariant8.apply(BlockStateModelGenerator.ROTATE_Y_180))
                                .with(BlockStateModelGenerator.createMultipartConditionBuilder().put(Properties.WEST, false), weightedVariant8.apply(BlockStateModelGenerator.ROTATE_Y_270))
                                .with(BlockStateModelGenerator.createMultipartConditionBuilder().put(Properties.UP, false), weightedVariant8.apply(BlockStateModelGenerator.ROTATE_X_270))
                                .with(BlockStateModelGenerator.createMultipartConditionBuilder().put(Properties.DOWN, false), weightedVariant8.apply(BlockStateModelGenerator.ROTATE_X_90))
                );
        blockStateModelGenerator.registerParentedItemModel(block, TexturedModel.CUBE_ALL.upload(block, "_inventory", blockStateModelGenerator.modelCollector));

    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        deprecateBlock(blockStateModelGenerator, Blocks.RED_NETHER_BRICKS);
        deprecateBlock(blockStateModelGenerator, Blocks.RED_NETHER_BRICK_STAIRS);
        deprecateBlock(blockStateModelGenerator, Blocks.RED_NETHER_BRICK_SLAB);
        deprecateBlock(blockStateModelGenerator, Blocks.RED_NETHER_BRICK_WALL);
        generateFungusBlocks(blockStateModelGenerator);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RED_NETHER_BRICK.getBaseBlock()).family(ModBlocks.RED_NETHER_BRICK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BLUE_NETHER_BRICK.getBaseBlock()).family(ModBlocks.BLUE_NETHER_BRICK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BLACK_NETHER_BRICK.getBaseBlock()).family(ModBlocks.BLACK_NETHER_BRICK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GLOW_NETHER_BRICK.getBaseBlock()).family(ModBlocks.GLOW_NETHER_BRICK);
        blockStateModelGenerator.registerCrop(ModBlocks.WARPED_NETHER_WART, Properties.AGE_3, 0, 1, 1, 2);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
