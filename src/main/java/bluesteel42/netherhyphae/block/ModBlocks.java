package bluesteel42.netherhyphae.block;

import bluesteel42.netherhyphae.NetherWartsHyphae;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {
    public static final Block CRIMSON_FUNGUS_BLOCK = register(
            "crimson_fungus_block",
            MushroomBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.RED)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(1.0F)
                    .sounds(BlockSoundGroup.NETHER_STEM)
                    .luminance(state -> 1),
            true,
            false);
    public static final Block WARPED_FUNGUS_BLOCK = register("warped_fungus_block", MushroomBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.BRIGHT_TEAL).instrument(NoteBlockInstrument.BASS).strength(1.0F).sounds(BlockSoundGroup.NETHER_STEM), true, false);

    public static final Block WARPED_NETHER_WART = register("warped_nether_wart", WarpedNetherWartBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.BRIGHT_TEAL).noCollision().ticksRandomly().sounds(BlockSoundGroup.NETHER_WART).pistonBehavior(PistonBehavior.DESTROY), true, true);

    public static final Block BLUE_NETHER_BRICKS = register(
            "blue_nether_bricks",
            Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_AQUA)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(2.0F, 6.0F)
                    .sounds(BlockSoundGroup.NETHER_BRICKS),
            true, false);
    public static final Block BLUE_NETHER_BRICK_STAIRS = register("blue_nether_brick_stairs", settings -> new StairsBlock(ModBlocks.BLUE_NETHER_BRICKS.getDefaultState(), settings), AbstractBlock.Settings.copy(ModBlocks.BLUE_NETHER_BRICKS), true, false);
    public static final Block BLUE_NETHER_BRICK_SLAB = register("blue_nether_brick_slab", SlabBlock::new, AbstractBlock.Settings.copy(ModBlocks.BLUE_NETHER_BRICKS), true, false);
    public static final Block BLUE_NETHER_BRICK_WALL = register(
            "blue_nether_brick_wall", WallBlock::new, AbstractBlock.Settings.copy(ModBlocks.BLUE_NETHER_BRICKS).solid(), true, true
    );
    public static final Block BLUE_NETHER_BRICK_FENCE = register(
            "blue_nether_brick_fence",
            FenceBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_AQUA)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(2.0F, 6.0F)
                    .sounds(BlockSoundGroup.NETHER_BRICKS),
            true,
            false
    );
    public static final Block RED_NETHER_BRICK_FENCE = register(
            "red_nether_brick_fence",
            FenceBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_RED)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(2.0F, 6.0F)
                    .sounds(BlockSoundGroup.NETHER_BRICKS),
            true,
            false
    );
    public static final Block BLACK_NETHER_BRICKS = register(
            "black_nether_bricks",
            Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.BLACK)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(2.0F, 6.0F)
                    .sounds(BlockSoundGroup.NETHER_BRICKS),
            true, false);
    public static final Block BLACK_NETHER_BRICK_STAIRS = register("black_nether_brick_stairs", settings -> new StairsBlock(ModBlocks.BLACK_NETHER_BRICKS.getDefaultState(), settings), AbstractBlock.Settings.copy(ModBlocks.BLACK_NETHER_BRICKS), true, false);
    public static final Block BLACK_NETHER_BRICK_SLAB = register("black_nether_brick_slab", SlabBlock::new, AbstractBlock.Settings.copy(ModBlocks.BLACK_NETHER_BRICKS), true, false);
    public static final Block BLACK_NETHER_BRICK_WALL = register(
            "black_nether_brick_wall", WallBlock::new, AbstractBlock.Settings.copy(ModBlocks.BLACK_NETHER_BRICKS).solid(), true, true
    );
    public static final Block BLACK_NETHER_BRICK_FENCE = register(
            "black_nether_brick_fence",
            FenceBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.BLACK)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(2.0F, 6.0F)
                    .sounds(BlockSoundGroup.NETHER_BRICKS),
            true,
            false
    );
    public static final Block GLOW_NETHER_BRICKS = register(
            "glow_nether_bricks",
            Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.YELLOW)
                    .luminance(state -> 15)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(2.0F, 6.0F)
                    .sounds(BlockSoundGroup.NETHER_BRICKS),
            true, false);
    public static final Block GLOW_NETHER_BRICK_STAIRS = register("glow_nether_brick_stairs", settings -> new StairsBlock(ModBlocks.GLOW_NETHER_BRICKS.getDefaultState(), settings), AbstractBlock.Settings.copy(ModBlocks.GLOW_NETHER_BRICKS), true, false);
    public static final Block GLOW_NETHER_BRICK_SLAB = register("glow_nether_brick_slab", SlabBlock::new, AbstractBlock.Settings.copy(ModBlocks.GLOW_NETHER_BRICKS), true, false);
    public static final Block GLOW_NETHER_BRICK_WALL = register(
            "glow_nether_brick_wall", WallBlock::new, AbstractBlock.Settings.copy(ModBlocks.GLOW_NETHER_BRICKS).solid(), true, true
    );
    public static final Block GLOW_NETHER_BRICK_FENCE = register(
            "glow_nether_brick_fence",
            FenceBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.YELLOW)
                    .luminance(state -> 15)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(2.0F, 6.0F)
                    .sounds(BlockSoundGroup.NETHER_BRICKS),
            true,
            false
    );

    private static Block register(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings, boolean registerItem, boolean nonOpaqueBlock) {
        final Identifier identifier = Identifier.of(NetherWartsHyphae.MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        final Block block = Blocks.register(registryKey, factory, settings);

        if (registerItem) {
            Items.register(block);
        }

        if (nonOpaqueBlock) {
            BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        }

        return block;
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.GLOW_NETHER_BRICK_FENCE);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.GLOW_NETHER_BRICK_WALL);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.GLOW_NETHER_BRICK_SLAB);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.GLOW_NETHER_BRICK_STAIRS);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.GLOW_NETHER_BRICKS);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.BLACK_NETHER_BRICK_FENCE);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.BLACK_NETHER_BRICK_WALL);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.BLACK_NETHER_BRICK_SLAB);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.BLACK_NETHER_BRICK_STAIRS);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.BLACK_NETHER_BRICKS);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.BLUE_NETHER_BRICK_FENCE);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.BLUE_NETHER_BRICK_WALL);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.BLUE_NETHER_BRICK_SLAB);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.BLUE_NETHER_BRICK_STAIRS);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.BLUE_NETHER_BRICKS);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.RED_NETHER_BRICK_FENCE);
                });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> {
                    itemGroup.addBefore(Items.NETHER_WART_BLOCK, ModBlocks.CRIMSON_FUNGUS_BLOCK);
                    itemGroup.addBefore(Items.NETHER_WART_BLOCK, ModBlocks.WARPED_FUNGUS_BLOCK);
                    itemGroup.addAfter(Items.NETHER_WART, ModBlocks.WARPED_NETHER_WART);
                });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.NETHER_WART, ModBlocks.WARPED_NETHER_WART);
                });

    }
}

