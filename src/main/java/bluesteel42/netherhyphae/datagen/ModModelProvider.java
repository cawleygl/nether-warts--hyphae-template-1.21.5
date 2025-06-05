package bluesteel42.netherhyphae.datagen;

import bluesteel42.netherhyphae.NetherWartsHyphae;
import bluesteel42.netherhyphae.block.ModBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        Identifier netherMushroomBlock = Identifier.of(NetherWartsHyphae.MOD_ID, "block/fungus_block_inside");
        WeightedVariant weightedVariant7 = BlockStateModelGenerator.createWeightedVariant(
                Models.TEMPLATE_SINGLE_FACE.upload(ModBlocks.CRIMSON_FUNGUS_BLOCK, TextureMap.texture(ModBlocks.CRIMSON_FUNGUS_BLOCK), blockStateModelGenerator.modelCollector)
        );
        WeightedVariant weightedVariant8 = BlockStateModelGenerator.createWeightedVariant(netherMushroomBlock);
        blockStateModelGenerator.blockStateCollector
                .accept(
                        MultipartBlockModelDefinitionCreator.create(ModBlocks.CRIMSON_FUNGUS_BLOCK)
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
        blockStateModelGenerator.registerParentedItemModel(ModBlocks.CRIMSON_FUNGUS_BLOCK, TexturedModel.CUBE_ALL.upload(ModBlocks.CRIMSON_FUNGUS_BLOCK, "_inventory", blockStateModelGenerator.modelCollector));

        WeightedVariant weightedVariant9 = BlockStateModelGenerator.createWeightedVariant(
                Models.TEMPLATE_SINGLE_FACE.upload(ModBlocks.WARPED_FUNGUS_BLOCK, TextureMap.texture(ModBlocks.WARPED_FUNGUS_BLOCK), blockStateModelGenerator.modelCollector)
        );
        WeightedVariant weightedVariant10 = BlockStateModelGenerator.createWeightedVariant(netherMushroomBlock);
        blockStateModelGenerator.blockStateCollector
                .accept(
                        MultipartBlockModelDefinitionCreator.create(ModBlocks.WARPED_FUNGUS_BLOCK)
                                .with(BlockStateModelGenerator.createMultipartConditionBuilder().put(Properties.NORTH, true), weightedVariant9)
                                .with(BlockStateModelGenerator.createMultipartConditionBuilder().put(Properties.EAST, true), weightedVariant9.apply(BlockStateModelGenerator.ROTATE_Y_90).apply(BlockStateModelGenerator.UV_LOCK))
                                .with(BlockStateModelGenerator.createMultipartConditionBuilder().put(Properties.SOUTH, true), weightedVariant9.apply(BlockStateModelGenerator.ROTATE_Y_180).apply(BlockStateModelGenerator.UV_LOCK))
                                .with(BlockStateModelGenerator.createMultipartConditionBuilder().put(Properties.WEST, true), weightedVariant9.apply(BlockStateModelGenerator.ROTATE_Y_270).apply(BlockStateModelGenerator.UV_LOCK))
                                .with(BlockStateModelGenerator.createMultipartConditionBuilder().put(Properties.UP, true), weightedVariant9.apply(BlockStateModelGenerator.ROTATE_X_270).apply(BlockStateModelGenerator.UV_LOCK))
                                .with(BlockStateModelGenerator.createMultipartConditionBuilder().put(Properties.DOWN, true), weightedVariant9.apply(BlockStateModelGenerator.ROTATE_X_90).apply(BlockStateModelGenerator.UV_LOCK))
                                .with(BlockStateModelGenerator.createMultipartConditionBuilder().put(Properties.NORTH, false), weightedVariant10)
                                .with(BlockStateModelGenerator.createMultipartConditionBuilder().put(Properties.EAST, false), weightedVariant10.apply(BlockStateModelGenerator.ROTATE_Y_90))
                                .with(BlockStateModelGenerator.createMultipartConditionBuilder().put(Properties.SOUTH, false), weightedVariant10.apply(BlockStateModelGenerator.ROTATE_Y_180))
                                .with(BlockStateModelGenerator.createMultipartConditionBuilder().put(Properties.WEST, false), weightedVariant10.apply(BlockStateModelGenerator.ROTATE_Y_270))
                                .with(BlockStateModelGenerator.createMultipartConditionBuilder().put(Properties.UP, false), weightedVariant10.apply(BlockStateModelGenerator.ROTATE_X_270))
                                .with(BlockStateModelGenerator.createMultipartConditionBuilder().put(Properties.DOWN, false), weightedVariant10.apply(BlockStateModelGenerator.ROTATE_X_90))
                );
        blockStateModelGenerator.registerParentedItemModel(ModBlocks.WARPED_FUNGUS_BLOCK, TexturedModel.CUBE_ALL.upload(ModBlocks.WARPED_FUNGUS_BLOCK, "_inventory", blockStateModelGenerator.modelCollector));

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
