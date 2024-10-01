package org.teamvoided.mossy_menagerie.data

import net.minecraft.block.Block
import net.minecraft.block.MapColor
import net.minecraft.item.Item
import net.minecraft.item.ItemConvertible
import net.minecraft.registry.RegistryKey
import net.minecraft.world.gen.feature.ConfiguredFeature
import net.minecraft.world.gen.feature.UndergroundConfiguredFeatures
import org.teamvoided.mossy_menagerie.block.MossyBlock
import org.teamvoided.mossy_menagerie.block.ParentedCarpetBlock
import org.teamvoided.mossy_menagerie.init.MossyBlocks.moss
import java.util.function.Supplier

data class Moss(
    val name: String,
    val block: MossyBlock, val carpet: ParentedCarpetBlock,
    val floweringBlock: MossyBlock, val floweringCarpet: ParentedCarpetBlock
) : Supplier<Block>, ItemConvertible {
    override fun get(): Block = block
    override fun asItem(): Item = block.asItem()
    fun forEach(consumer: (Block) -> Unit) = getAll().forEach(consumer)
    fun getAll(): List<Block> = listOf(block, carpet, floweringBlock, floweringCarpet)
    companion object {
        fun create(name: String) = Builder(name)
        val ALL_MOSS = mutableSetOf<Moss>()
    }

    private fun register(creator: ((name: String, block: Block) -> Block), add: Boolean): Moss {
        val moss = "${name}_moss"
        creator(moss, block)
        creator("${moss}_carpet", carpet)
        creator("flowering_$moss", floweringBlock)
        creator("flowering_${moss}_carpet", floweringCarpet)

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

        fun build(creator: (name: String, block: Block) -> Block, add: Boolean = true): Moss {
            val mossBlock = MossyBlock(mossFeature, moss(mapColor))
            val floweringMossBlock = MossyBlock(mossFeature, moss(mapColor))
            return Moss(
                name,
                mossBlock, ParentedCarpetBlock(mossBlock),
                floweringMossBlock, ParentedCarpetBlock(floweringMossBlock)
            ).register(creator, add)
        }
    }


}
