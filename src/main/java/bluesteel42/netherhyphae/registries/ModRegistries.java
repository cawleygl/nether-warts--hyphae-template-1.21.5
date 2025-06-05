package bluesteel42.netherhyphae.registries;

import bluesteel42.netherhyphae.block.ModBlocks;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;

public class ModRegistries {
    public static void registerCompostables() {
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.CRIMSON_FUNGUS_BLOCK, 0.85F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.WARPED_FUNGUS_BLOCK, 0.85F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.WARPED_NETHER_WART, 0.65F);
    }
}
