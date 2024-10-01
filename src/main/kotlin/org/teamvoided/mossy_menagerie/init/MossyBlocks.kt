package org.teamvoided.mossy_menagerie.init

import net.minecraft.block.*
import net.minecraft.block.Blocks.leavesOf
import net.minecraft.registry.Registries
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.world.gen.feature.UndergroundConfiguredFeatures.MOSS_PATCH_BONE_MEAL
import org.teamvoided.mossy_menagerie.block.MossyBlock
import org.teamvoided.mossy_menagerie.block.ParentedCarpetBlock
import org.teamvoided.mossy_menagerie.data.Moss
import org.teamvoided.mossy_menagerie.utils.BlockItem
import org.teamvoided.mossy_menagerie.utils.addAndGet
import org.teamvoided.mossy_menagerie.utils.register
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures as Mcf

@Suppress("MemberVisibilityCanBePrivate")
object MossyBlocks {
    val BLOCKS = mutableSetOf<Block>()
    fun init() = Unit

    val FLOWERING_MOSS = register("flowering_moss", MossyBlock(MOSS_PATCH_BONE_MEAL, moss(MapColor.GREEN)))
    val FLOWERING_MOSS_CARPET = register("flowering_moss_carpet", ParentedCarpetBlock(FLOWERING_MOSS))

    val CRIMSON_MOSS = Moss.create("crimson")
        .mapColor(MapColor.RED_TERRACOTTA)
        .mossFeature(Mcf.CRIMSON_MOSS_PATCH_BONE_MEAL)
        .build(::register, ::registerNoItem)

    val MAGMATIC_MOSS = Moss.create("magmatic")
        .mapColor(MapColor.ORANGE_TERRACOTTA)
        .mossFeature(Mcf.MAGMATIC_MOSS_PATCH_BONE_MEAL)
        .build(::register, ::registerNoItem)

    val ROYAL_MOSS = Moss.create("royal")
        .mapColor(MapColor.YELLOW_TERRACOTTA)
        .mossFeature(Mcf.ROYAL_MOSS_PATCH_BONE_MEAL)
        .build(::register, ::registerNoItem)

    val GLOWING_MOSS = Moss.create("glowing")
        .mapColor(MapColor.LIME_TERRACOTTA)
        .mossFeature(Mcf.GLOWING_MOSS_PATCH_BONE_MEAL)
        .build(::register, ::registerNoItem)

    val DARK_MOSS = Moss.create("dark")
        .mapColor(MapColor.GREEN_TERRACOTTA)
        .mossFeature(Mcf.DARK_MOSS_PATCH_BONE_MEAL)
        .build(::register, ::registerNoItem)

    val MARITIME_MOSS = Moss.create("maritime")
        .mapColor(MapColor.CYAN_TERRACOTTA)
        .mossFeature(Mcf.MARITIME_MOSS_PATCH_BONE_MEAL)
        .build(::register, ::registerNoItem)

    val WARPED_MOSS = Moss.create("warped")
        .mapColor(MapColor.LIGHT_BLUE_TERRACOTTA)
        .mossFeature(Mcf.WARPED_MOSS_PATCH_BONE_MEAL)
        .build(::register, ::registerNoItem)

    val AZURE_MOSS = Moss.create("azure")
        .mapColor(MapColor.BLUE_TERRACOTTA)
        .mossFeature(Mcf.AZURE_MOSS_PATCH_BONE_MEAL)
        .build(::register, ::registerNoItem)

    val ARCANE_MOSS = Moss.create("arcane")
        .mapColor(MapColor.PURPLE_TERRACOTTA)
        .mossFeature(Mcf.ARCANE_MOSS_PATCH_BONE_MEAL)
        .build(::register, ::registerNoItem)

    val TWISTED_MOSS = Moss.create("twisted")
        .mapColor(MapColor.MAGENTA_TERRACOTTA)
        .mossFeature(Mcf.TWISTED_MOSS_PATCH_BONE_MEAL)
        .build(::register, ::registerNoItem)

    val ROSY_MOSS = Moss.create("rosy")
        .mapColor(MapColor.PINK_TERRACOTTA)
        .mossFeature(Mcf.ROSY_MOSS_PATCH_BONE_MEAL)
        .build(::register, ::registerNoItem)

    val ANCIENT_MOSS = Moss.create("ancient")
        .mapColor(MapColor.BROWN_TERRACOTTA)
        .mossFeature(Mcf.ANCIENT_MOSS_PATCH_BONE_MEAL)
        .build(::register, ::registerNoItem)

    val ASHEN_MOSS = Moss.create("ashen")
        .mapColor(MapColor.BLACK_TERRACOTTA)
        .mossFeature(Mcf.ASHEN_MOSS_PATCH_BONE_MEAL)
        .build(::register, ::registerNoItem)

    val CHROME_MOSS = Moss.create("chrome")
        .mapColor(MapColor.GRAY_TERRACOTTA)
        .mossFeature(Mcf.CHROME_MOSS_PATCH_BONE_MEAL)
        .build(::register, ::registerNoItem)

    val DUSKY_MOSS = Moss.create("dusky")
        .mapColor(MapColor.LIGHT_GRAY_TERRACOTTA)
        .mossFeature(Mcf.DUSKY_MOSS_PATCH_BONE_MEAL)
        .build(::register, ::registerNoItem)

    val BONE_MOSS = Moss.create("bone")
        .mapColor(MapColor.WHITE_TERRACOTTA)
        .mossFeature(Mcf.BONE_MOSS_PATCH_BONE_MEAL)
        .build(::register, ::registerNoItem)

    fun moss(color: MapColor): AbstractBlock.Settings = copy(Blocks.MOSS_BLOCK).mapColor(color)
    fun leaves(soundGroup: BlockSoundGroup) = leavesOf(soundGroup) as LeavesBlock
    fun copy(block: Block): AbstractBlock.Settings = AbstractBlock.Settings.copy(block)

    fun <T : Block> register(name: String, block: T): Block {
        val blockReg = registerNoItem(name, block)
        MossyItems.register(name, BlockItem(blockReg))
        return blockReg
    }

    private fun <T : Block> registerNoItem(name: String, item: T): Block =
        BLOCKS.addAndGet(Registries.BLOCK.register(name, item))
}