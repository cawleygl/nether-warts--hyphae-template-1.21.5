package bluesteel42.netherhyphae.block;

import bluesteel42.netherhyphae.NetherWartsHyphae;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {
    public static final Block CRIMSON_FUNGUS_BLOCK = register("crimson_fungus_block",MushroomBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.RED).instrument(NoteBlockInstrument.BASS).strength(1.0F).sounds(BlockSoundGroup.NETHER_STEM));
    public static final Block WARPED_FUNGUS_BLOCK = register("warped_fungus_block", MushroomBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.BRIGHT_TEAL).instrument(NoteBlockInstrument.BASS).strength(1.0F).sounds(BlockSoundGroup.NETHER_STEM));
    public static final Block WARPED_NETHER_WART = register("warped_nether_wart", WarpedNetherWartBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.BRIGHT_TEAL).noCollision().ticksRandomly().sounds(BlockSoundGroup.NETHER_WART).pistonBehavior(PistonBehavior.DESTROY), true, true);

    private static final String RED_COLOR_NAME = "red";
    private static final MapColor RED_MAP_COLOR = MapColor.RED;
    public static final Block RED_NETHER_BRICKS = registerNetherBrickBlock(RED_COLOR_NAME, RED_MAP_COLOR);
    public static final Block CHISELED_RED_NETHER_BRICKS = registerChiseledNetherBrickBlock(RED_COLOR_NAME, RED_MAP_COLOR);
    public static final Block CRACKED_RED_NETHER_BRICKS = registerCrackedNetherBrickBlock(RED_COLOR_NAME, RED_MAP_COLOR);
    public static final Block RED_NETHER_BRICK_STAIRS = registerNetherBrickStairsBlock(RED_COLOR_NAME, RED_NETHER_BRICKS);
    public static final Block RED_NETHER_BRICK_SLAB = registerNetherBrickSlabBlock(RED_COLOR_NAME, RED_NETHER_BRICKS);
    public static final Block RED_NETHER_BRICK_WALL = registerNetherBrickWallBlock(RED_COLOR_NAME, RED_NETHER_BRICKS);
    public static final Block RED_NETHER_BRICK_FENCE = registerNetherBrickFenceBlock(RED_COLOR_NAME, RED_NETHER_BRICKS);
    public static final BlockFamily RED_NETHER_BRICK = registerNetherBrickBlockFamily(RED_NETHER_BRICKS, RED_NETHER_BRICK_FENCE, RED_NETHER_BRICK_WALL, RED_NETHER_BRICK_STAIRS, RED_NETHER_BRICK_SLAB, CHISELED_RED_NETHER_BRICKS, CRACKED_RED_NETHER_BRICKS);

    private static final String BLUE_COLOR_NAME = "blue";
    private static final MapColor BLUE_MAP_COLOR = MapColor.DARK_AQUA;
    public static final Block BLUE_NETHER_BRICKS = registerNetherBrickBlock(BLUE_COLOR_NAME, BLUE_MAP_COLOR);
    public static final Block CHISELED_BLUE_NETHER_BRICKS = registerChiseledNetherBrickBlock(BLUE_COLOR_NAME, BLUE_MAP_COLOR);
    public static final Block CRACKED_BLUE_NETHER_BRICKS = registerCrackedNetherBrickBlock(BLUE_COLOR_NAME, BLUE_MAP_COLOR);
    public static final Block BLUE_NETHER_BRICK_STAIRS = registerNetherBrickStairsBlock(BLUE_COLOR_NAME, BLUE_NETHER_BRICKS);
    public static final Block BLUE_NETHER_BRICK_SLAB = registerNetherBrickSlabBlock(BLUE_COLOR_NAME, BLUE_NETHER_BRICKS);
    public static final Block BLUE_NETHER_BRICK_WALL = registerNetherBrickWallBlock(BLUE_COLOR_NAME, BLUE_NETHER_BRICKS);
    public static final Block BLUE_NETHER_BRICK_FENCE = registerNetherBrickFenceBlock(BLUE_COLOR_NAME, BLUE_NETHER_BRICKS);
    public static final BlockFamily BLUE_NETHER_BRICK = registerNetherBrickBlockFamily(BLUE_NETHER_BRICKS, BLUE_NETHER_BRICK_FENCE, BLUE_NETHER_BRICK_WALL, BLUE_NETHER_BRICK_STAIRS, BLUE_NETHER_BRICK_SLAB, CHISELED_BLUE_NETHER_BRICKS, CRACKED_BLUE_NETHER_BRICKS);

    private static final String BLACK_COLOR_NAME = "black";
    private static final MapColor BLACK_MAP_COLOR = MapColor.BLACK;
    public static final Block BLACK_NETHER_BRICKS = registerNetherBrickBlock(BLACK_COLOR_NAME, BLACK_MAP_COLOR);
    public static final Block CHISELED_BLACK_NETHER_BRICKS = registerChiseledNetherBrickBlock(BLACK_COLOR_NAME, BLACK_MAP_COLOR);
    public static final Block CRACKED_BLACK_NETHER_BRICKS = registerCrackedNetherBrickBlock(BLACK_COLOR_NAME, BLACK_MAP_COLOR);
    public static final Block BLACK_NETHER_BRICK_STAIRS = registerNetherBrickStairsBlock(BLACK_COLOR_NAME, BLACK_NETHER_BRICKS);
    public static final Block BLACK_NETHER_BRICK_SLAB = registerNetherBrickSlabBlock(BLACK_COLOR_NAME, BLACK_NETHER_BRICKS);
    public static final Block BLACK_NETHER_BRICK_WALL = registerNetherBrickWallBlock(BLACK_COLOR_NAME, BLACK_NETHER_BRICKS);
    public static final Block BLACK_NETHER_BRICK_FENCE = registerNetherBrickFenceBlock(BLACK_COLOR_NAME, BLACK_NETHER_BRICKS);
    public static final BlockFamily BLACK_NETHER_BRICK = registerNetherBrickBlockFamily(BLACK_NETHER_BRICKS, BLACK_NETHER_BRICK_FENCE, BLACK_NETHER_BRICK_WALL, BLACK_NETHER_BRICK_STAIRS, BLACK_NETHER_BRICK_SLAB, CHISELED_BLACK_NETHER_BRICKS, CRACKED_BLACK_NETHER_BRICKS);

    private static final String GLOW_COLOR_NAME = "glow";
    private static final MapColor GLOW_MAP_COLOR = MapColor.YELLOW;
    public static final Block GLOW_NETHER_BRICKS = registerNetherBrickBlock(GLOW_COLOR_NAME, GLOW_MAP_COLOR, true);
    public static final Block CHISELED_GLOW_NETHER_BRICKS = registerChiseledNetherBrickBlock(GLOW_COLOR_NAME, GLOW_MAP_COLOR, true);
    public static final Block CRACKED_GLOW_NETHER_BRICKS = registerCrackedNetherBrickBlock(GLOW_COLOR_NAME, GLOW_MAP_COLOR, true);
    public static final Block GLOW_NETHER_BRICK_STAIRS = registerNetherBrickStairsBlock(GLOW_COLOR_NAME, GLOW_NETHER_BRICKS);
    public static final Block GLOW_NETHER_BRICK_SLAB = registerNetherBrickSlabBlock(GLOW_COLOR_NAME, GLOW_NETHER_BRICKS);
    public static final Block GLOW_NETHER_BRICK_WALL = registerNetherBrickWallBlock(GLOW_COLOR_NAME, GLOW_NETHER_BRICKS);
    public static final Block GLOW_NETHER_BRICK_FENCE = registerNetherBrickFenceBlock(GLOW_COLOR_NAME, GLOW_NETHER_BRICKS);
    public static final BlockFamily GLOW_NETHER_BRICK = registerNetherBrickBlockFamily(GLOW_NETHER_BRICKS, GLOW_NETHER_BRICK_FENCE, GLOW_NETHER_BRICK_WALL, GLOW_NETHER_BRICK_STAIRS, GLOW_NETHER_BRICK_SLAB, CHISELED_GLOW_NETHER_BRICKS, CRACKED_GLOW_NETHER_BRICKS);

    private static Block registerNetherBrickBlock(String blockColorName, MapColor mapColor, boolean glow) {
        String name = blockColorName + "_nether_bricks";
        if (glow) {
            return register(name, AbstractBlock.Settings.create()
                    .mapColor(mapColor)
                    .luminance(state -> 15)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(2.0F, 6.0F)
                    .sounds(BlockSoundGroup.NETHER_BRICKS));
        } else {
            return register(name, AbstractBlock.Settings.create()
                    .mapColor(mapColor)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(2.0F, 6.0F)
                    .sounds(BlockSoundGroup.NETHER_BRICKS));
        }
    }
    private static Block registerNetherBrickBlock(String blockColorName, MapColor mapColor) {
        return registerNetherBrickBlock(blockColorName, mapColor, false);
    }
    private static Block registerCrackedNetherBrickBlock(String blockColorName, MapColor mapColor, boolean glow) {
        return registerNetherBrickBlock("cracked_" + blockColorName, mapColor, glow);
    }
    private static Block registerCrackedNetherBrickBlock(String blockColorName, MapColor mapColor) {
        return registerCrackedNetherBrickBlock(blockColorName, mapColor, false);
    }
    private static Block registerChiseledNetherBrickBlock(String blockColorName, MapColor mapColor, boolean glow) {
        return registerNetherBrickBlock("chiseled_" + blockColorName, mapColor, glow);
    }
    private static Block registerChiseledNetherBrickBlock(String blockColorName, MapColor mapColor) {
        return registerChiseledNetherBrickBlock(blockColorName, mapColor, false);
    }
    private static Block registerNetherBrickStairsBlock(String blockColorName, Block brickBlock) {
        return register(blockColorName + "_nether_brick_stairs", settings -> new StairsBlock(brickBlock.getDefaultState(), settings), AbstractBlock.Settings.copy(brickBlock));
    }
    private static Block registerNetherBrickSlabBlock(String blockColorName, Block brickBlock) {
        return register(blockColorName + "_nether_brick_slab", SlabBlock::new, AbstractBlock.Settings.copy(brickBlock));
    }
    private static Block registerNetherBrickWallBlock(String blockColorName, Block brickBlock) {
        return register(blockColorName + "_nether_brick_wall", WallBlock::new, AbstractBlock.Settings.copy(brickBlock).solid(), true, true);
    }
    private static Block registerNetherBrickFenceBlock(String blockColorName, Block brickBlock) {
        return register(blockColorName + "_nether_brick_fence", FenceBlock::new, AbstractBlock.Settings.copy(brickBlock));
    }
    public static BlockFamily registerNetherBrickBlockFamily(Block bricks, Block fence, Block wall, Block stairs, Block slab, Block chiseled, Block cracked) {
        return BlockFamilies.register(bricks).fence(fence).wall(wall).stairs(stairs).slab(slab).chiseled(chiseled).cracked(cracked).build();
    }

    public static Block register(String id, AbstractBlock.Settings settings) {
        return register(id, Block::new, settings, true, false);
    }
    public static Block register(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        return register(id, factory, settings, true, false);
    }
    public static Block register(
            String path,
            Function<AbstractBlock.Settings, Block> factory,
            AbstractBlock.Settings settings,
            boolean registerItem,
            boolean nonOpaqueBlock
    ) {
        final Identifier identifier = Identifier.of(NetherWartsHyphae.MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);
        final Block block = Blocks.register(registryKey, factory, settings);

        if (registerItem) {
            Items.register(block);
        }

        if (nonOpaqueBlock) {
            BlockRenderLayerMap.putBlock(block, BlockRenderLayer.CUTOUT);
        }

        if (block instanceof SignBlock || block instanceof WallSignBlock) {
            BlockEntityType.SIGN.addSupportedBlock(block);
        } else if (block instanceof HangingSignBlock || block instanceof WallHangingSignBlock) {
            BlockEntityType.HANGING_SIGN.addSupportedBlock(block);
        } else if (block instanceof ShelfBlock) {
            BlockEntityType.SHELF.addSupportedBlock(block);
        }

        return block;
    }


    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.CHISELED_GLOW_NETHER_BRICKS);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.GLOW_NETHER_BRICK_FENCE);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.GLOW_NETHER_BRICK_WALL);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.GLOW_NETHER_BRICK_SLAB);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.GLOW_NETHER_BRICK_STAIRS);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.CRACKED_GLOW_NETHER_BRICKS);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.GLOW_NETHER_BRICKS);

                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.CHISELED_BLACK_NETHER_BRICKS);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.BLACK_NETHER_BRICK_FENCE);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.BLACK_NETHER_BRICK_WALL);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.BLACK_NETHER_BRICK_SLAB);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.BLACK_NETHER_BRICK_STAIRS);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.CRACKED_BLACK_NETHER_BRICKS);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.BLACK_NETHER_BRICKS);

                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.CHISELED_BLUE_NETHER_BRICKS);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.BLUE_NETHER_BRICK_FENCE);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.BLUE_NETHER_BRICK_WALL);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.BLUE_NETHER_BRICK_SLAB);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.BLUE_NETHER_BRICK_STAIRS);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.CRACKED_BLUE_NETHER_BRICKS);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.BLUE_NETHER_BRICKS);

                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.CHISELED_RED_NETHER_BRICKS);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.RED_NETHER_BRICK_FENCE);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.RED_NETHER_BRICK_WALL);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.RED_NETHER_BRICK_SLAB);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.RED_NETHER_BRICK_STAIRS);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.CRACKED_RED_NETHER_BRICKS);
                    itemGroup.addAfter(Items.RED_NETHER_BRICK_WALL, ModBlocks.RED_NETHER_BRICKS);
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

