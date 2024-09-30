package org.teamvoided.mossy_menagerie.data.gen

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.*
import net.minecraft.block.Blocks
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.model.BlockStateModelGenerator
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.registry.HolderLookup
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistrySetBuilder
import net.minecraft.registry.tag.BlockTags
import net.minecraft.registry.tag.ItemTags
import org.teamvoided.mossy_menagerie.MossyMenagerie.log
import org.teamvoided.mossy_menagerie.block.ParentedCarpetBlock
import org.teamvoided.mossy_menagerie.data.MossyBlockTags
import org.teamvoided.mossy_menagerie.init.MossyBlocks
import org.teamvoided.mossy_menagerie.init.MossyItems
import org.teamvoided.mossy_menagerie.init.MossyTabs
import org.teamvoided.mossy_menagerie.utils.lang
import org.teamvoided.mossy_menagerie.utils.toId
import java.util.concurrent.CompletableFuture

@Suppress("unused")
object MossyMenagerieData : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(gen: FabricDataGenerator) {
        log.info("Hello from DataGen")
        val pack = gen.createPack()
        // Assets
        pack.addProvider(::EnLangProvider)
        pack.addProvider(::ModelProvider)
        // Data
        pack.addProvider(::BlockLootTableProvider)
        pack.addProvider(::RecipeProvider)
        // Tags
        val blocks = pack.addProvider(::BlockTagProvider)
        pack.addProvider { o, r -> ItemTagProvider(o, r, blocks) }
        // World Gen
        pack.addProvider(::DynRegProvider)
    }

    override fun buildRegistry(gen: RegistrySetBuilder) {
        gen.add(RegistryKeys.CONFIGURED_FEATURE, ::bootstrapConfiguredFeatures)
        gen.add(RegistryKeys.PLACED_FEATURE, ::bootstrapPlacedFeatures)
    }

    //Assets
    class EnLangProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) :
        FabricLanguageProvider(o, r) {
        override fun generateTranslations(lookup: HolderLookup.Provider, gen: TranslationBuilder) {
            MossyItems.ITEMS.forEach { gen.add(it.translationKey, it.toId().lang()) }
            MossyTabs.MOSSY_TAB.key.ifPresent { gen.add(it, "Mossy Menagerie") }
        }
    }

    class ModelProvider(o: FabricDataOutput) : FabricModelProvider(o) {
        override fun generateBlockStateModels(gen: BlockStateModelGenerator) {
            MossyBlocks.BLOCKS.filterIsInstance<ParentedCarpetBlock>().forEach { gen.registerCarpet(it.parent, it) }
        }

        //private val SINGLE_LAYER = listOf<Item>()
        override fun generateItemModels(gen: ItemModelGenerator) = Unit
        /*SINGLE_LAYER.forEach { gen.register(it, Models.SINGLE_LAYER_ITEM) }*/
    }

    //Data
    class BlockLootTableProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) :
        FabricBlockLootTableProvider(o, r) {
        override fun generate() = MossyBlocks.BLOCKS.forEach(::addDrop)
    }

    class RecipeProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) :
        FabricRecipeProvider(o, r) {
        override fun generateRecipes(gen: RecipeExporter) {
            MossyBlocks.BLOCKS.filterIsInstance<ParentedCarpetBlock>().forEach { offerCarpetRecipe(gen, it, it.parent) }
        }
    }

    // Tags
    class BlockTagProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) :
        FabricTagProvider.BlockTagProvider(o, r) {
        override fun configure(wrapperLookup: HolderLookup.Provider) {
            val mineableHoe = getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
            MossyBlocks.BLOCKS.filterIsInstance<ParentedCarpetBlock>().forEach {
                mineableHoe.add(it)
                getOrCreateTagBuilder(BlockTags.COMBINATION_STEP_SOUND_BLOCKS).add(it)
                getOrCreateTagBuilder(BlockTags.SWORD_EFFICIENT).add(it)
                getOrCreateTagBuilder(MossyBlockTags.MOSSY_CARPETS).add(it)

                mineableHoe.add(it.parent)
                getOrCreateTagBuilder(BlockTags.DIRT).add(it.parent)
                getOrCreateTagBuilder(BlockTags.SMALL_DRIPLEAF_PLACEABLE).add(it.parent)
                getOrCreateTagBuilder(BlockTags.SNIFFER_EGG_HATCH_BOOST).add(it.parent)
                getOrCreateTagBuilder(BlockTags.SNIFFER_DIGGABLE_BLOCK).add(it.parent)
                getOrCreateTagBuilder(MossyBlockTags.MOSS).add(it.parent)
            }
            getOrCreateTagBuilder(MossyBlockTags.MOSS).add(Blocks.MOSS_BLOCK)
            getOrCreateTagBuilder(MossyBlockTags.MOSS_CARPETS)
                .add(Blocks.MOSS_CARPET)
                .forceAddTag(MossyBlockTags.MOSSY_CARPETS)

            getOrCreateTagBuilder(MossyBlockTags.MOSS_CAN_GROW_UNDER)
                .forceAddTag(BlockTags.REPLACEABLE)
                .forceAddTag(BlockTags.REPLACEABLE_BY_TREES)
                .forceAddTag(BlockTags.FLOWERS)
                .forceAddTag(BlockTags.SAPLINGS)
                .forceAddTag(MossyBlockTags.MOSS_CARPETS)
                .add(Blocks.TORCH, Blocks.REDSTONE_TORCH, Blocks.SOUL_TORCH)
                .add(Blocks.WALL_TORCH, Blocks.REDSTONE_WALL_TORCH, Blocks.SOUL_WALL_TORCH)
        }
    }

    class ItemTagProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>, p: BlockTagProvider) :
        FabricTagProvider.ItemTagProvider(o, r, p) {
        override fun configure(wrapperLookup: HolderLookup.Provider) {
            copy(BlockTags.DIRT, ItemTags.DIRT)
        }
    }

}
