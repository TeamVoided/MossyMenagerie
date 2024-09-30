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
import org.teamvoided.mossy_menagerie.block.ParentedCarpetBlock
import org.teamvoided.mossy_menagerie.data.tags.MossyBiomeTags
import org.teamvoided.mossy_menagerie.data.tags.MossyBlockTags
import org.teamvoided.mossy_menagerie.init.MossyBlocks
import java.util.concurrent.CompletableFuture

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

class BiomeTagProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) :
    FabricTagProvider<Biome>(o, RegistryKeys.BIOME, r) {
    override fun configure(wrapperLookup: HolderLookup.Provider) {
        getOrCreateTagBuilder(MossyBiomeTags.HAS_DARK_MOSS)
            .add(Biomes.DARK_FOREST)
    }
}