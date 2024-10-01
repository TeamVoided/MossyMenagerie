package org.teamvoided.mossy_menagerie.data.gen

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.block.Block
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.registry.HolderLookup
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistrySetBuilder
import org.teamvoided.mossy_menagerie.MossyMenagerie.log
import org.teamvoided.mossy_menagerie.data.Moss
import org.teamvoided.mossy_menagerie.init.MossyBlocks
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
        pack.addProvider(::BiomeTagProvider)
        // World Gen
        pack.addProvider(::DynRegProvider)
    }

    override fun buildRegistry(gen: RegistrySetBuilder) {
        gen.add(RegistryKeys.CONFIGURED_FEATURE, ::bootstrapConfiguredFeatures)
        gen.add(RegistryKeys.PLACED_FEATURE, ::bootstrapPlacedFeatures)
    }

    //Data
    class BlockLootTableProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) :
        FabricBlockLootTableProvider(o, r) {
            val dropSelf = listOf(MossyBlocks.FLOWERING_MOSS, MossyBlocks.FLOWERING_MOSS_CARPET)
        override fun generate() {
            Moss.ALL_MOSS.forEach(::mossDrops)
            dropSelf.forEach(::addDrop)
        }

        private fun mossDrops(moss: Moss) {
            listOf(moss.block, moss.carpet, moss.floweringBlock, moss.floweringCarpet).forEach(::addDrop)
        }
    }

    class RecipeProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) :
        FabricRecipeProvider(o, r) {
        override fun generateRecipes(gen: RecipeExporter) {
            gen.offerCarpetRecipe(MossyBlocks.FLOWERING_MOSS_CARPET, MossyBlocks.FLOWERING_MOSS)
            Moss.ALL_MOSS.forEach { gen.mossRecipes(it) }
        }

        private fun RecipeExporter.mossRecipes(moss: Moss) {
            this.offerCarpetRecipe(moss.carpet, moss.block)
            this.offerCarpetRecipe(moss.floweringCarpet, moss.floweringBlock)
        }

        private fun RecipeExporter.offerCarpetRecipe(carpet: Block, block: Block) =
            offerCarpetRecipe(this, carpet, block)
    }
}

