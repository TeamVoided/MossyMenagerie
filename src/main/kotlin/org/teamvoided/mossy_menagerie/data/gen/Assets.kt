package org.teamvoided.mossy_menagerie.data.gen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.block.Block
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.model.*
import net.minecraft.registry.HolderLookup
import net.minecraft.util.Identifier
import org.teamvoided.mossy_menagerie.data.Moss
import org.teamvoided.mossy_menagerie.init.MossyBlocks
import org.teamvoided.mossy_menagerie.init.MossyItems
import org.teamvoided.mossy_menagerie.init.MossyTabs
import org.teamvoided.mossy_menagerie.utils.lang
import org.teamvoided.mossy_menagerie.utils.toId
import java.util.*
import java.util.concurrent.CompletableFuture

class EnLangProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) :
    FabricLanguageProvider(o, r) {
    override fun generateTranslations(lookup: HolderLookup.Provider, gen: TranslationBuilder) {
        MossyItems.ITEMS.forEach { gen.add(it.translationKey, it.toId().lang()) }
        MossyTabs.MOSSY_TAB.key.ifPresent { gen.add(it, "Mossy Menagerie") }
    }
}

class ModelProvider(o: FabricDataOutput) : FabricModelProvider(o) {
    override fun generateBlockStateModels(gen: BlockStateModelGenerator) {
        gen.registerCarpet(MossyBlocks.FLOWERING_MOSS, MossyBlocks.FLOWERING_MOSS_CARPET)
        Moss.ALL_MOSS.forEach(gen::registerMoss)
    }

    override fun generateItemModels(gen: ItemModelGenerator) = Unit
    //private val SINGLE_LAYER = listOf<Item>()
    /*SINGLE_LAYER.forEach { gen.register(it, Models.SINGLE_LAYER_ITEM) }*/
}

fun BlockStateModelGenerator.registerMoss(moss: Moss) {
    this.registerCarpet(moss.block, moss.carpet)
    this.registerCarpet(moss.floweringBlock, moss.floweringCarpet)
    this.registerCustomAzalea(moss.azalea)
    this.registerCustomAzalea(moss.floweringAzalea)
    this.registerSimpleCubeAll(moss.azaleaLeaves)
    this.registerSimpleCubeAll(moss.floweringAzaleaLeaves)
    this.registerPottedAzaleaBush(moss.pottedAzalea)
    this.registerPottedAzaleaBush(moss.pottedFloweringAzalea)
}

fun BlockStateModelGenerator.registerCustomAzalea(block: Block) {
    val model = TEMPLATE_AZALEA.upload(block, Texture.pottedAzalea(block), this.modelCollector)
    this.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(block, model))
}
val TEMPLATE_AZALEA = block("template_azalea", TextureKey.PLANT, TextureKey.TOP, TextureKey.SIDE)
private fun block(parent: String, vararg requiredTextures: TextureKey): Model {
    return Model(Optional.of(Identifier.ofDefault("block/$parent")), Optional.empty(), *requiredTextures)
}
