package bluesteel42.netherhyphae.potion;

import bluesteel42.netherhyphae.NetherWartsHyphae;
import bluesteel42.netherhyphae.block.ModBlocks;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;

public class ModPotions {
    public static final RegistryEntry<Potion> MELANCHOLIC = registerPotion("melancholic");

    public static final RegistryEntry<Potion> HASTE = registerPotion("haste", StatusEffects.HASTE, 3600, 0);
    public static final RegistryEntry<Potion> LONG_HASTE = registerPotion("long_haste", StatusEffects.HASTE, 9600, 0);
    public static final RegistryEntry<Potion> STRONG_HASTE = registerPotion("strong_haste", StatusEffects.HASTE, 1800, 1);

    public static final RegistryEntry<Potion> MINING_FATIGUE = registerPotion("mining_fatigue", StatusEffects.MINING_FATIGUE, 1800, 0);
    public static final RegistryEntry<Potion> LONG_MINING_FATIGUE = registerPotion("long_mining_fatigue", StatusEffects.MINING_FATIGUE, 4800, 0);
    public static final RegistryEntry<Potion> STRONG_MINING_FATIGUE = registerPotion("strong_mining_fatigue", StatusEffects.MINING_FATIGUE, 400, 1);

    public static final RegistryEntry<Potion> NAUSEA = registerPotion("nausea", StatusEffects.NAUSEA, 900, 0);
    public static final RegistryEntry<Potion> LONG_NAUSEA = registerPotion("long_nausea", StatusEffects.NAUSEA, 1800, 0);
    public static final RegistryEntry<Potion> STRONG_NAUSEA = registerPotion("strong_nausea", StatusEffects.NAUSEA, 432, 1);

    public static final RegistryEntry<Potion> BLINDNESS = registerPotion("blindness", StatusEffects.BLINDNESS, 1800, 0);
    public static final RegistryEntry<Potion> LONG_BLINDNESS = registerPotion("long_blindness", StatusEffects.BLINDNESS, 4800, 0);

    public static final RegistryEntry<Potion> HUNGER = registerPotion("hunger", StatusEffects.HUNGER, 900, 0);
    public static final RegistryEntry<Potion> LONG_HUNGER = registerPotion("long_hunger", StatusEffects.HUNGER, 1800, 0);
    public static final RegistryEntry<Potion> STRONG_HUNGER = registerPotion("strong_hunger", StatusEffects.HUNGER, 432, 2);

    public static final RegistryEntry<Potion> DECAY = registerPotion("decay", StatusEffects.WITHER, 800, 1);

    public static final RegistryEntry<Potion> ABSORPTION = registerPotion("absorption", StatusEffects.ABSORPTION, 600, 0);
    public static final RegistryEntry<Potion> LONG_ABSORPTION = registerPotion("long_absorption", StatusEffects.ABSORPTION, 1200, 0);

    public static final RegistryEntry<Potion> GLOWING = registerPotion("glowing", StatusEffects.GLOWING, 1200, 0);
    public static final RegistryEntry<Potion> LONG_GLOWING = registerPotion("long_glowing", StatusEffects.GLOWING, 1800, 0);

    public static final RegistryEntry<Potion> DARKNESS = registerPotion("darkness", StatusEffects.DARKNESS, 1800, 0);
    public static final RegistryEntry<Potion> LONG_DARKNESS = registerPotion("long_darkness", StatusEffects.DARKNESS, 4800, 0);

    public static final RegistryEntry<Potion> LEVITATION = registerPotion("levitation", StatusEffects.LEVITATION, 1200, 0);
    public static final RegistryEntry<Potion> LONG_LEVITATION = registerPotion("long_levitation", StatusEffects.LEVITATION, 1800, 0);
    public static final RegistryEntry<Potion> STRONG_LEVITATION = registerPotion("strong_levitation", StatusEffects.LEVITATION, 600, 2);

    public static RegistryEntry<Potion> registerPotion(String path){
        return Registry.registerReference(Registries.POTION, Identifier.of(NetherWartsHyphae.MOD_ID, path), new Potion(path));
    }

    public static RegistryEntry<Potion> registerPotion(String path, RegistryEntry<StatusEffect> effect, int duration, int amplifier){
        return Registry.registerReference(Registries.POTION, Identifier.of(NetherWartsHyphae.MOD_ID, path), new Potion(path, new StatusEffectInstance(effect, duration, amplifier)));
    }

    public static void registerPotions(){}

    public static void registerPotionsRecipes(){
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            // Input Potion + Ingredient = Output Potion
            builder.registerPotionRecipe(Potions.WATER, ModBlocks.WARPED_NETHER_WART.asItem(), ModPotions.MELANCHOLIC);

            builder.registerPotionRecipe(ModPotions.MELANCHOLIC, Items.BLAZE_POWDER, ModPotions.HASTE);
            builder.registerPotionRecipe(ModPotions.HASTE, Items.REDSTONE, ModPotions.LONG_HASTE);
            builder.registerPotionRecipe(ModPotions.HASTE, Items.GLOWSTONE_DUST, ModPotions.STRONG_HASTE);

            builder.registerPotionRecipe(ModPotions.HASTE, Items.FERMENTED_SPIDER_EYE, ModPotions.MINING_FATIGUE);
            builder.registerPotionRecipe(ModPotions.MINING_FATIGUE, Items.REDSTONE, ModPotions.LONG_MINING_FATIGUE);
            builder.registerPotionRecipe(ModPotions.MINING_FATIGUE, Items.GLOWSTONE_DUST, ModPotions.STRONG_MINING_FATIGUE);
            builder.registerPotionRecipe(ModPotions.LONG_HASTE, Items.FERMENTED_SPIDER_EYE, ModPotions.LONG_MINING_FATIGUE);

            builder.registerPotionRecipe(ModPotions.MELANCHOLIC, Items.SPIDER_EYE, ModPotions.BLINDNESS);
            builder.registerPotionRecipe(ModPotions.BLINDNESS, Items.REDSTONE, ModPotions.LONG_BLINDNESS);

            builder.registerPotionRecipe(ModPotions.BLINDNESS, Items.FERMENTED_SPIDER_EYE, ModPotions.NAUSEA);
            builder.registerPotionRecipe(ModPotions.NAUSEA, Items.REDSTONE, ModPotions.LONG_NAUSEA);
            builder.registerPotionRecipe(ModPotions.NAUSEA, Items.GLOWSTONE_DUST, ModPotions.STRONG_NAUSEA);
            builder.registerPotionRecipe(ModPotions.LONG_BLINDNESS, Items.FERMENTED_SPIDER_EYE, ModPotions.LONG_NAUSEA);

            builder.registerPotionRecipe(ModPotions.MELANCHOLIC, Items.SUGAR, ModPotions.HUNGER);
            builder.registerPotionRecipe(ModPotions.HUNGER, Items.REDSTONE, ModPotions.LONG_HUNGER);
            builder.registerPotionRecipe(ModPotions.HUNGER, Items.GLOWSTONE_DUST, ModPotions.STRONG_HUNGER);

            builder.registerPotionRecipe(ModPotions.MELANCHOLIC, Items.WITHER_ROSE, ModPotions.DECAY);

            builder.registerPotionRecipe(ModPotions.MELANCHOLIC, Items.GOLDEN_CARROT, ModPotions.ABSORPTION);
            builder.registerPotionRecipe(ModPotions.ABSORPTION, Items.REDSTONE, ModPotions.LONG_ABSORPTION);

            builder.registerPotionRecipe(ModPotions.MELANCHOLIC, Items.MAGMA_CREAM, ModPotions.GLOWING);
            builder.registerPotionRecipe(ModPotions.GLOWING, Items.REDSTONE, ModPotions.LONG_GLOWING);

            builder.registerPotionRecipe(ModPotions.GLOWING, Items.FERMENTED_SPIDER_EYE, ModPotions.DARKNESS);
            builder.registerPotionRecipe(ModPotions.DARKNESS, Items.REDSTONE, ModPotions.LONG_DARKNESS);
            builder.registerPotionRecipe(ModPotions.LONG_GLOWING, Items.FERMENTED_SPIDER_EYE, ModPotions.LONG_DARKNESS);

            builder.registerPotionRecipe(ModPotions.MELANCHOLIC, Items.PHANTOM_MEMBRANE, ModPotions.LEVITATION);
            builder.registerPotionRecipe(ModPotions.LEVITATION, Items.REDSTONE, ModPotions.LONG_LEVITATION);
            builder.registerPotionRecipe(ModPotions.LEVITATION, Items.GLOWSTONE_DUST, ModPotions.STRONG_LEVITATION);

        });
    }
}
