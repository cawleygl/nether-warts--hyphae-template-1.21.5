package bluesteel42.netherhyphae;

import bluesteel42.netherhyphae.block.ModBlocks;
import bluesteel42.netherhyphae.potion.ModPotions;
import bluesteel42.netherhyphae.registries.ModRegistries;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetherWartsHyphae implements ModInitializer {
	public static final String MOD_ID = "nether-hyphae";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModBlocks.initialize();
		ModPotions.registerPotions();
		ModPotions.registerPotionsRecipes();
		ModRegistries.registerCompostables();

		LOGGER.info("Hello Fabric world!");
	}
}