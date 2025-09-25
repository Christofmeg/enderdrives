package com.sts15.enderdrives.datagen.data;

import appeng.core.definitions.ItemDefinition;
import appeng.items.materials.MaterialItem;
import net.minecraft.data.recipes.*;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import net.pedroksl.advanced_ae.common.definitions.AAEItems;

import com.glodblock.github.extendedae.common.EAESingletons;
import com.sts15.enderdrives.items.ItemInit;

import org.jetbrains.annotations.NotNull;

import appeng.api.util.AEColor;
import appeng.core.definitions.AEBlocks;
import appeng.core.definitions.AEItems;
import gripe._90.megacells.definition.MEGAItems;

import java.util.concurrent.*;

public class EDRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public EDRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {

        // Misc
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.TAPE_DISK.get())
                .pattern("aba")
                .pattern("bcb")
                .pattern("ded")
                .define('a', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .define('b', AEItems.SKY_DUST)
                .define('c', AEItems.CELL_COMPONENT_256K)
                .define('d', Items.NETHERITE_INGOT)
                .define('e', AEItems.COLORED_PAINT_BALL.item(AEColor.LIGHT_BLUE))
                .unlockedBy(String.format("has_%s", AEItems.CELL_COMPONENT_256K.id().getPath()), has(AEItems.CELL_COMPONENT_256K))
                .save(recipeOutput, ItemInit.TAPE_DISK.getId());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.ENDER_STORAGE_COMPONENT_1K.get())
                .pattern("aba")
                .pattern("bcb")
                .pattern("aba")
                .define('a', AEItems.SINGULARITY)
                .define('b', Items.ENDER_PEARL)
                .define('c', AEItems.SPATIAL_128_CELL_COMPONENT)
                .unlockedBy(String.format("has_%s", AEItems.SPATIAL_128_CELL_COMPONENT.id().getPath()), has(AEItems.SPATIAL_128_CELL_COMPONENT))
                .save(recipeOutput.withConditions(
                        not(modLoaded("megacells")),
                        not(modLoaded("advanced_ae"))
                ), String.format("%s_vanilla", ItemInit.ENDER_STORAGE_COMPONENT_1K.getId()));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.ENDER_STORAGE_COMPONENT_1K.get())
                .pattern("aba")
                .pattern("bcb")
                .pattern("aba")
                .define('a', AAEItems.SHATTERED_SINGULARITY)
                .define('b', Items.ENDER_PEARL)
                .define('c', AAEItems.QUANTUM_STORAGE_COMPONENT)
                .unlockedBy(String.format("has_%s", AEItems.SPATIAL_128_CELL_COMPONENT.id().getPath()), has(AEItems.SPATIAL_128_CELL_COMPONENT))
                .save(recipeOutput.withConditions(
                        modLoaded("advanced_ae")
                ), String.format("%s_advanced", ItemInit.ENDER_STORAGE_COMPONENT_1K.getId()));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.ENDER_STORAGE_COMPONENT_1K.get())
                .pattern("aba")
                .pattern("bcb")
                .pattern("aba")
                .define('a', AEItems.SINGULARITY)
                .define('b', Items.ENDER_PEARL)
                .define('c', MEGAItems.CELL_COMPONENT_256M)
                .unlockedBy(String.format("has_%s", AEItems.SPATIAL_128_CELL_COMPONENT.id().getPath()), has(AEItems.SPATIAL_128_CELL_COMPONENT))
                .save(recipeOutput.withConditions(
                        modLoaded("megacells"),
                        not(modLoaded("advanced_ae"))
                ), String.format("%s_mega", ItemInit.ENDER_STORAGE_COMPONENT_1K.getId()));

        makeComponent(ItemInit.ENDER_STORAGE_COMPONENT_4K, ItemInit.ENDER_STORAGE_COMPONENT_1K, recipeOutput);
        makeComponent(ItemInit.ENDER_STORAGE_COMPONENT_16K, ItemInit.ENDER_STORAGE_COMPONENT_4K, recipeOutput);
        makeComponent(ItemInit.ENDER_STORAGE_COMPONENT_64K, ItemInit.ENDER_STORAGE_COMPONENT_16K, recipeOutput);
        makeComponent(ItemInit.ENDER_STORAGE_COMPONENT_256K, ItemInit.ENDER_STORAGE_COMPONENT_64K, recipeOutput);

        makeEnderCell(ItemInit.ENDER_DISK_1K, ItemInit.ENDER_STORAGE_COMPONENT_1K, recipeOutput);
        makeEnderCell(ItemInit.ENDER_DISK_4K, ItemInit.ENDER_STORAGE_COMPONENT_4K, recipeOutput);
        makeEnderCell(ItemInit.ENDER_DISK_16K, ItemInit.ENDER_STORAGE_COMPONENT_16K, recipeOutput);
        makeEnderCell(ItemInit.ENDER_DISK_64K, ItemInit.ENDER_STORAGE_COMPONENT_64K, recipeOutput);
        makeEnderCell(ItemInit.ENDER_DISK_256K, ItemInit.ENDER_STORAGE_COMPONENT_256K, recipeOutput);

        // MEGA Ender Disk
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.ENDER_STORAGE_COMPONENT_1M.get())
                .pattern("aba")
                .pattern("cdc")
                .pattern("aca")
                .define('a', AEItems.SKY_DUST)
                .define('b', MEGAItems.ACCUMULATION_PROCESSOR)
                .define('c', ItemInit.ENDER_STORAGE_COMPONENT_256K.get())
                .define('d', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .unlockedBy(String.format("has_%s", MEGAItems.ACCUMULATION_PROCESSOR.id().getPath()), has(MEGAItems.ACCUMULATION_PROCESSOR))
                .save(recipeOutput.withConditions(
                        modLoaded("megacells")
                ), String.format("%s_mega", ItemInit.ENDER_STORAGE_COMPONENT_1M.getId()));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.ENDER_STORAGE_COMPONENT_1M.get())
                .pattern("aba")
                .pattern("cdc")
                .pattern("aca")
                .define('a', AEItems.SKY_DUST)
                .define('b', AEItems.SPATIAL_128_CELL_COMPONENT)
                .define('c', ItemInit.ENDER_STORAGE_COMPONENT_256K.get())
                .define('d', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .unlockedBy(String.format("has_%s", AEItems.SPATIAL_128_CELL_COMPONENT.id().getPath()), has(AEItems.SPATIAL_128_CELL_COMPONENT))
                .save(recipeOutput.withConditions(
                        not(modLoaded("megacells"))
                ), String.format("%s_vanilla", ItemInit.ENDER_STORAGE_COMPONENT_1M.getId()));

        makeMEGAEnderCell(ItemInit.ENDER_DISK_1M, ItemInit.ENDER_STORAGE_COMPONENT_1M, recipeOutput);
        makeMEGAEnderCell(ItemInit.ENDER_DISK_4M, ItemInit.ENDER_STORAGE_COMPONENT_4M, recipeOutput);
        makeMEGAEnderCell(ItemInit.ENDER_DISK_16M, ItemInit.ENDER_STORAGE_COMPONENT_16M, recipeOutput);
        makeMEGAEnderCell(ItemInit.ENDER_DISK_64M, ItemInit.ENDER_STORAGE_COMPONENT_64M, recipeOutput);
        makeMEGAEnderCell(ItemInit.ENDER_DISK_256M, ItemInit.ENDER_STORAGE_COMPONENT_256M, recipeOutput);

        makeEnderCellHousing(ItemInit.ENDER_ITEM_CELL_HOUSING, AEItems.SKY_DUST, recipeOutput);
    }
    private void makeEnderCellHousing(DeferredHolder<Item, ? extends Item> housing,
                                      ItemDefinition<MaterialItem> hasItem,
                                      RecipeOutput output
    ) {
        // Vanilla
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, housing.get())
                .pattern("aba")
                .pattern("c c")
                .pattern("ded")
                .define('a', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .define('b', AEItems.CALCULATION_PROCESSOR)
                .define('c', AEItems.SKY_DUST)
                .define('d', Items.NETHERITE_INGOT)
                .define('e', Items.ENDER_CHEST)
                .unlockedBy(String.format("has_%s", hasItem.id().getPath()), has(hasItem.get()))
                .save(output.withConditions(
                                not(modLoaded("megacells")),
                                not(modLoaded("extendedae")),
                                not(modLoaded("advanced_ae"))
                        ), String.format("%s_vanilla", housing.getId())
                );

        // Mega
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, housing.get())
                .pattern("aba")
                .pattern("c c")
                .pattern("ded")
                .define('a', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .define('b', MEGAItems.ACCUMULATION_PROCESSOR)
                .define('c', AEItems.SKY_DUST)
                .define('d', MEGAItems.SKY_STEEL_INGOT)
                .define('e', Items.ENDER_CHEST)
                .unlockedBy(String.format("has_%s", hasItem.id().getPath()), has(hasItem.get()))
                .save(output.withConditions(
                                modLoaded("megacells"),
                                not(modLoaded("advanced_ae"))
                        ), String.format("%s_mega", housing.getId())
                );

        // Extended
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, housing.get())
                .pattern("aba")
                .pattern("c c")
                .pattern("ded")
                .define('a', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .define('b', EAESingletons.CONCURRENT_PROCESSOR)
                .define('c', AEItems.SKY_DUST)
                .define('d', EAESingletons.ENTRO_BLOCK)
                .define('e', Items.ENDER_CHEST)
                .unlockedBy(String.format("has_%s", hasItem.id().getPath()), has(hasItem.get()))
                .save(output.withConditions(
                                modLoaded("extendedae"),
                                not(modLoaded("megacells")),
                                not(modLoaded("advanced_ae"))
                        ), String.format("%s_extended", housing.getId())
                );

        // Advanced
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, housing.get())
                .pattern("aba")
                .pattern("c c")
                .pattern("ded")
                .define('a', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .define('b', AAEItems.QUANTUM_PROCESSOR)
                .define('c', AEItems.SKY_DUST)
                .define('d', AAEItems.QUANTUM_ALLOY_PLATE)
                .define('e', Items.ENDER_CHEST)
                .unlockedBy(String.format("has_%s", hasItem.id().getPath()), has(hasItem.get()))
                .save(output.withConditions(
                                modLoaded("advanced_ae")
                        ), String.format("%s_advanced", housing.getId())
                );
    }

    private void makeMEGAEnderCell(DeferredHolder<Item, ? extends Item> disk,
                               DeferredHolder<Item, ? extends Item> component,
                               RecipeOutput output
    ) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, disk.get())
                .pattern("aba")
                .pattern("bcb")
                .pattern("ddd")
                .define('a', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .define('b', AEItems.SKY_DUST)
                .define('c', component.get())
                .define('d', MEGAItems.SKY_STEEL_INGOT)
                .unlockedBy(String.format("has_%s", component.getId().getPath()), has(component.get()))
                .save(output.withConditions(
                                modLoaded("megacells")
                        ), String.format("%s_mega", disk.getId())
                );

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, disk.get())
                .pattern("aba")
                .pattern("cdc")
                .pattern("efe")
                .define('a', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .define('b', AAEItems.QUANTUM_PROCESSOR)
                .define('c', AEItems.SKY_DUST)
                .define('d', component.get())
                .define('e', AAEItems.QUANTUM_ALLOY_PLATE)
                .define('f', Items.ENDER_CHEST)
                .unlockedBy(String.format("has_%s", component.getId().getPath()), has(component.get()))
                .save(output.withConditions(
                                modLoaded("advanced_ae"),
                                not(modLoaded("megacells"))
                        ), String.format("%s_advanced_ae", disk.getId())
                );

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, disk.get())
                .pattern("aba")
                .pattern("cdc")
                .pattern("efe")
                .define('a', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .define('b', AEItems.SPATIAL_128_CELL_COMPONENT)
                .define('c', AEItems.SKY_DUST)
                .define('d', component.get())
                .define('e', AEItems.SINGULARITY)
                .define('f', Items.ENDER_CHEST)
                .unlockedBy(String.format("has_%s", component.getId().getPath()), has(component.get()))
                .save(output.withConditions(
                                not(modLoaded("advanced_ae")),
                                not(modLoaded("megacells"))
                        ), String.format("%s_vanilla", disk.getId())
                );

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, disk.get())
                .requires(MEGAItems.MEGA_ITEM_CELL_HOUSING)
                .requires(component.get())
                .unlockedBy(String.format("has_%s", component.getId().getPath()), has(component.get()))
                .save(output.withConditions(
                                modLoaded("megacells")
                        ), String.format("%s_housing_mega", disk.getId())
                );

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, disk.get())
                .requires(ItemInit.ENDER_ITEM_CELL_HOUSING.get())
                .requires(component.get())
                .unlockedBy(String.format("has_%s", component.getId().getPath()), has(component.get()))
                .save(output.withConditions(
                                not(modLoaded("megacells"))
                        ), String.format("%s_housing_vanilla", disk.getId())
                );
    }

    private void makeEnderCell(DeferredHolder<Item, ? extends Item> disk,
                               DeferredHolder<Item, ? extends Item> component,
                               RecipeOutput output
    ) {

        // Vanilla
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, disk.get())
                .pattern("aba")
                .pattern("cdc")
                .pattern("efe")
                .define('a', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .define('b', AEItems.CALCULATION_PROCESSOR)
                .define('c', AEItems.SKY_DUST)
                .define('d', component.get())
                .define('e', Items.NETHERITE_INGOT)
                .define('f', Items.ENDER_CHEST)
                .unlockedBy(String.format("has_%s", component.getId().getPath()), has(component.get()))
                .save(output.withConditions(
                        not(modLoaded("megacells")),
                        not(modLoaded("extendedae")),
                        not(modLoaded("advanced_ae"))
                        ), String.format("%s_vanilla", disk.getId())
                );

        // Mega
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, disk.get())
                .pattern("aba")
                .pattern("cdc")
                .pattern("efe")
                .define('a', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .define('b', MEGAItems.ACCUMULATION_PROCESSOR)
                .define('c', AEItems.SKY_DUST)
                .define('d', component.get())
                .define('e', MEGAItems.SKY_STEEL_INGOT)
                .define('f', Items.ENDER_CHEST)
                .unlockedBy(String.format("has_%s", component.getId().getPath()), has(component.get()))
                .save(output.withConditions(
                        modLoaded("megacells"),
                        not(modLoaded("advanced_ae"))
                        ), String.format("%s_mega", disk.getId())
                );

        // Extended
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, disk.get())
                .pattern("aba")
                .pattern("cdc")
                .pattern("efe")
                .define('a', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .define('b', EAESingletons.CONCURRENT_PROCESSOR)
                .define('c', AEItems.SKY_DUST)
                .define('d', component.get())
                .define('e', EAESingletons.ENTRO_BLOCK)
                .define('f', Items.ENDER_CHEST)
                .unlockedBy(String.format("has_%s", component.getId().getPath()), has(component.get()))
                .save(output.withConditions(
                        modLoaded("extendedae"),
                        not(modLoaded("megacells")),
                        not(modLoaded("advanced_ae"))
                        ), String.format("%s_extended", disk.getId())
                );

        // Advanced
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, disk.get())
                .pattern("aba")
                .pattern("cdc")
                .pattern("efe")
                .define('a', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .define('b', AAEItems.QUANTUM_PROCESSOR)
                .define('c', AEItems.SKY_DUST)
                .define('d', component.get())
                .define('e', AAEItems.QUANTUM_ALLOY_PLATE)
                .define('f', Items.ENDER_CHEST)
                .unlockedBy(String.format("has_%s", component.getId().getPath()), has(component.get()))
                .save(output.withConditions(
                        modLoaded("advanced_ae")
                        ), String.format("%s_advanced", disk.getId())
                );

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, disk.get())
                .requires(ItemInit.ENDER_ITEM_CELL_HOUSING.get())
                .requires(component.get())
                .unlockedBy(String.format("has_%s", component.getId().getPath()), has(component.get()))
                .save(output, String.format("%s_housing_vanilla", disk.getId())
                );
    }

    private void makeComponent(DeferredHolder<Item, ? extends Item> component,
                               DeferredHolder<Item, ? extends Item> prev,
                               RecipeOutput output
    ) {
        // Vanilla
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, component.get())
                .pattern("aba")
                .pattern("cdc")
                .pattern("aca")
                .define('a', AEItems.SINGULARITY)
                .define('b', AEItems.CALCULATION_PROCESSOR)
                .define('c', prev.get())
                .define('d', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .unlockedBy(String.format("has_%s", prev.getId().getPath()), has(prev.get()))
                .save(output.withConditions(
                        not(modLoaded("megacells")),
                        not(modLoaded("advanced_ae"))
                ), String.format("%s_vanilla", component.getId()));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, component.get())
                .pattern("aba")
                .pattern("cdc")
                .pattern("aca")
                .define('a', AAEItems.SHATTERED_SINGULARITY)
                .define('b', AAEItems.QUANTUM_PROCESSOR)
                .define('c', prev.get())
                .define('d', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .unlockedBy(String.format("has_%s", prev.getId().getPath()), has(prev.get()))
                .save(output.withConditions(
                        modLoaded("advanced_ae")
                ), String.format("%s_advanced", component.getId()));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, component.get())
                .pattern("aba")
                .pattern("cdc")
                .pattern("aca")
                .define('a', AEItems.SINGULARITY)
                .define('b', MEGAItems.ACCUMULATION_PROCESSOR)
                .define('c', prev.get())
                .define('d', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .unlockedBy(String.format("has_%s", prev.getId().getPath()), has(prev.get()))
                .save(output.withConditions(
                        modLoaded("megacells"),
                        not(modLoaded("advanced_ae"))
                ), String.format("%s_mega", component.getId()));
    }
}
