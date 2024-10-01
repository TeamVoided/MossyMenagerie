package org.teamvoided.mossy_menagerie.data

import net.minecraft.block.AzaleaBlock
import net.minecraft.block.Block
import net.minecraft.block.Blocks.pottedVariant
import net.minecraft.block.LeavesBlock
import net.minecraft.block.MapColor
import net.minecraft.item.Item
import net.minecraft.item.ItemConvertible
import net.minecraft.registry.RegistryKey
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.world.gen.feature.ConfiguredFeature
import net.minecraft.world.gen.feature.UndergroundConfiguredFeatures
import org.teamvoided.mossy_menagerie.block.MossyBlock
import org.teamvoided.mossy_menagerie.block.ParentedCarpetBlock
import org.teamvoided.mossy_menagerie.init.MossyBlocks.copy
import org.teamvoided.mossy_menagerie.init.MossyBlocks.leaves
import org.teamvoided.mossy_menagerie.init.MossyBlocks.moss
import java.util.function.Supplier

typealias registryFn = (name: String, block: Block) -> Block

data class Moss(
    val name: String,
    val block: MossyBlock, val carpet: ParentedCarpetBlock,
    val floweringBlock: MossyBlock, val floweringCarpet: ParentedCarpetBlock,
    val azalea: AzaleaBlock, val floweringAzalea: AzaleaBlock,
    val azaleaLeaves: LeavesBlock, val floweringAzaleaLeaves: LeavesBlock,
    val pottedAzalea: Block, val pottedFloweringAzalea: Block,
) : Supplier<Block>, ItemConvertible {
    override fun get(): Block = block
    override fun asItem(): Item = block.asItem()
    fun forEach(consumer: (Block) -> Unit) = getAll().forEach(consumer)
    fun getAll(): List<Block> = listOf(
        block, carpet,
        floweringBlock, floweringCarpet,
        azalea, floweringAzalea,
        azaleaLeaves, floweringAzaleaLeaves,
        pottedAzalea, pottedFloweringAzalea
    )

    companion object {
        fun create(name: String) = Builder(name)
        val ALL_MOSS = mutableSetOf<Moss>()
    }

    private fun register(creator: registryFn, creatorNoItem: registryFn, add: Boolean): Moss {
        val moss = "${name}_moss"
        creator(moss, block)
        creator("${moss}_carpet", carpet)
        creator("${name}_azalea", azalea)
        creatorNoItem("potted_${name}_azalea", pottedAzalea)
        creator("${name}_azalea_leaves", azaleaLeaves)

        creator("flowering_$moss", floweringBlock)
        creator("flowering_${moss}_carpet", floweringCarpet)
        creator("flowering_${name}_azalea", floweringAzalea)
        creatorNoItem("potted_flowering_${name}_azalea", pottedFloweringAzalea)
        creator("flowering_${name}_azalea_leaves", floweringAzaleaLeaves)

        if (add) ALL_MOSS.add(this)
        return this
    }


    class Builder(
        val name: String,
        private var mossFeature: RegistryKey<ConfiguredFeature<*, *>> = UndergroundConfiguredFeatures.MOSS_PATCH_BONE_MEAL,
        private var mapColor: MapColor = MapColor.GREEN
    ) {
        fun mapColor(mapColor: MapColor): Builder = apply { this.mapColor = mapColor }
        fun mossFeature(mossFeature: RegistryKey<ConfiguredFeature<*, *>>): Builder =
            apply { this.mossFeature = mossFeature }

        fun build(creator: registryFn, creatorNoItem: registryFn, add: Boolean = true): Moss {
            val mossBlock = MossyBlock(mossFeature, moss(mapColor))
            val floweringMossBlock = MossyBlock(mossFeature, moss(mapColor))
            val azaleaSettings = copy(mossBlock)
                .nonSolid().nonOpaque()
                .breakInstantly().sounds(BlockSoundGroup.AZALEA)
            val azalea = AzaleaBlock(azaleaSettings)
            val floweringAzalea = AzaleaBlock(azaleaSettings.sounds(BlockSoundGroup.FLOWERING_AZALEA))

            return Moss(
                name,
                mossBlock, ParentedCarpetBlock(mossBlock),
                floweringMossBlock, ParentedCarpetBlock(floweringMossBlock),
                azalea, floweringAzalea,
                leaves(BlockSoundGroup.AZALEA_LEAVES), leaves(BlockSoundGroup.AZALEA_LEAVES),
                pottedVariant(azalea), pottedVariant(floweringAzalea),
            ).register(creator, creatorNoItem, add)
        }
    }
}

