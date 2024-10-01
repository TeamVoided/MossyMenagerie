package org.teamvoided.mossy_menagerie.data.gen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.block.Blocks
import net.minecraft.registry.HolderLookup
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.BlockTags
import net.minecraft.registry.tag.ItemTags
import net.minecraft.world.biome.Biome
import net.minecraft.world.biome.Biomes
import org.teamvoided.mossy_menagerie.data.Moss
import org.teamvoided.mossy_menagerie.data.tags.MossyBiomeTags
import org.teamvoided.mossy_menagerie.data.tags.MossyBlockTags
import org.teamvoided.mossy_menagerie.init.MossyBlocks
import java.util.concurrent.CompletableFuture

// Tags
class BlockTagProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) :
    FabricTagProvider.BlockTagProvider(o, r) {
    override fun configure(wrapperLookup: HolderLookup.Provider) {
        Moss.ALL_MOSS.forEach(::addTags)

        floweringMoss()
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

    private fun floweringMoss() {
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).add(MossyBlocks.FLOWERING_MOSS, MossyBlocks.FLOWERING_MOSS_CARPET)

        getOrCreateTagBuilder(BlockTags.COMBINATION_STEP_SOUND_BLOCKS).add(MossyBlocks.FLOWERING_MOSS_CARPET)
        getOrCreateTagBuilder(BlockTags.SWORD_EFFICIENT).add(MossyBlocks.FLOWERING_MOSS_CARPET)
        getOrCreateTagBuilder(MossyBlockTags.MOSSY_CARPETS).add(MossyBlocks.FLOWERING_MOSS_CARPET)

        getOrCreateTagBuilder(BlockTags.DIRT).add(MossyBlocks.FLOWERING_MOSS)
        getOrCreateTagBuilder(BlockTags.SMALL_DRIPLEAF_PLACEABLE).add(MossyBlocks.FLOWERING_MOSS)
        getOrCreateTagBuilder(BlockTags.SNIFFER_EGG_HATCH_BOOST).add(MossyBlocks.FLOWERING_MOSS)
        getOrCreateTagBuilder(BlockTags.SNIFFER_DIGGABLE_BLOCK).add(MossyBlocks.FLOWERING_MOSS)
        getOrCreateTagBuilder(MossyBlockTags.MOSS).add(MossyBlocks.FLOWERING_MOSS)
    }

    private fun addTags(moss: Moss) {
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
            .add(moss.block, moss.carpet, moss.floweringBlock, moss.floweringCarpet)

        getOrCreateTagBuilder(BlockTags.COMBINATION_STEP_SOUND_BLOCKS).add(moss.carpet, moss.floweringCarpet)
        getOrCreateTagBuilder(BlockTags.SWORD_EFFICIENT).add(moss.carpet, moss.floweringCarpet)
        getOrCreateTagBuilder(MossyBlockTags.MOSSY_CARPETS).add(moss.carpet, moss.floweringCarpet)

        getOrCreateTagBuilder(BlockTags.DIRT).add(moss.block, moss.floweringBlock)
        getOrCreateTagBuilder(BlockTags.SMALL_DRIPLEAF_PLACEABLE).add(moss.block, moss.floweringBlock)
        getOrCreateTagBuilder(BlockTags.SNIFFER_EGG_HATCH_BOOST).add(moss.block, moss.floweringBlock)
        getOrCreateTagBuilder(BlockTags.SNIFFER_DIGGABLE_BLOCK).add(moss.block, moss.floweringBlock)
        getOrCreateTagBuilder(MossyBlockTags.MOSS).add(moss.block, moss.floweringBlock)
    }
}

class ItemTagProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>, p: BlockTagProvider) :
    FabricTagProvider.ItemTagProvider(o, r, p) {
    override fun configure(wrapperLookup: HolderLookup.Provider) {
        copy(BlockTags.DIRT, ItemTags.DIRT)
    }
}

class BiomeTagProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) :
    FabricTagProvider<Biome>(o, RegistryKeys.BIOME, r) {
    override fun configure(wrapperLookup: HolderLookup.Provider) {
        getOrCreateTagBuilder(MossyBiomeTags.HAS_GLOOMING_MOSS).add(Biomes.DARK_FOREST)
    }
}