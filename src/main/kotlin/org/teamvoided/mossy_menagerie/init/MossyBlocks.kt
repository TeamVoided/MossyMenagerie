package org.teamvoided.mossy_menagerie.init

import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.block.MapColor
import net.minecraft.registry.Registries
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


    val CRIMSON_MOSS = Moss.create("crimson")
        .mapColor(MapColor.RED_TERRACOTTA)
        .mossFeature(Mcf.CRIMSON_MOSS_PATCH_BONE_MEAL)
        .build(::register)

//    val CRIMSON_MOSS =
//        register("crimson_moss", MossyBlock(Mcf.CRIMSON_MOSS_PATCH_BONE_MEAL, moss(MapColor.RED_TERRACOTTA)))
//    val CRIMSON_MOSS_CARPET = register("crimson_moss_carpet", ParentedCarpetBlock((CRIMSON_MOSS)))

    val MAGMATIC_MOSS =
        register("magmatic_moss", MossyBlock(Mcf.MAGMATIC_MOSS_PATCH_BONE_MEAL, moss(MapColor.ORANGE_TERRACOTTA)))
    val MAGMATIC_MOSS_CARPET = register("magmatic_moss_carpet", ParentedCarpetBlock((MAGMATIC_MOSS)))

    val ROYAL_MOSS = register("royal_moss", MossyBlock(Mcf.ROSY_MOSS_PATCH_BONE_MEAL, moss(MapColor.YELLOW_TERRACOTTA)))
    val ROYAL_MOSS_CARPET = register("royal_moss_carpet", ParentedCarpetBlock((ROYAL_MOSS)))

    val GLOWING_MOSS =
        register("glowing_moss", MossyBlock(Mcf.GLOWING_MOSS_PATCH_BONE_MEAL, moss(MapColor.LIME_TERRACOTTA)))
    val GLOWING_MOSS_CARPET = register("glowing_moss_carpet", ParentedCarpetBlock((GLOWING_MOSS)))

    val DARK_MOSS = register("dark_moss", MossyBlock(Mcf.DARK_MOSS_PATCH_BONE_MEAL, moss(MapColor.GREEN_TERRACOTTA)))
    val DARK_MOSS_CARPET = register("dark_moss_carpet", ParentedCarpetBlock((DARK_MOSS)))

    val MARITIME_MOSS =
        register("maritime_moss", MossyBlock(Mcf.MARITIME_MOSS_PATCH_BONE_MEAL, moss(MapColor.CYAN_TERRACOTTA)))
    val MARITIME_MOSS_CARPET = register("maritime_moss_carpet", ParentedCarpetBlock((MARITIME_MOSS)))

    val WARPED_MOSS =
        register("warped_moss", MossyBlock(Mcf.WARPED_MOSS_PATCH_BONE_MEAL, moss(MapColor.LIGHT_BLUE_TERRACOTTA)))
    val WARPED_MOSS_CARPET = register("warped_moss_carpet", ParentedCarpetBlock((WARPED_MOSS)))

    val AZURE_MOSS = register("azure_moss", MossyBlock(Mcf.AZURE_MOSS_PATCH_BONE_MEAL, moss(MapColor.BLUE_TERRACOTTA)))
    val AZURE_MOSS_CARPET = register("azure_moss_carpet", ParentedCarpetBlock((AZURE_MOSS)))

    val ARCANE_MOSS =
        register("arcane_moss", MossyBlock(Mcf.ARCANE_MOSS_PATCH_BONE_MEAL, moss(MapColor.PURPLE_TERRACOTTA)))
    val ARCANE_MOSS_CARPET = register("arcane_moss_carpet", ParentedCarpetBlock((ARCANE_MOSS)))

    val TWISTED_MOSS =
        register("twisted_moss", MossyBlock(Mcf.TWISTED_MOSS_PATCH_BONE_MEAL, moss(MapColor.MAGENTA_TERRACOTTA)))
    val TWISTED_MOSS_CARPET = register("twisted_moss_carpet", ParentedCarpetBlock((TWISTED_MOSS)))

    val ROSY_MOSS = register("rosy_moss", MossyBlock(Mcf.ROSY_MOSS_PATCH_BONE_MEAL, moss(MapColor.PINK_TERRACOTTA)))
    val ROSY_MOSS_CARPET = register("rosy_moss_carpet", ParentedCarpetBlock((ROSY_MOSS)))

    val ANCIENT_MOSS =
        register("ancient_moss", MossyBlock(Mcf.ANCIENT_MOSS_PATCH_BONE_MEAL, moss(MapColor.BROWN_TERRACOTTA)))
    val ANCIENT_MOSS_CARPET = register("ancient_moss_carpet", ParentedCarpetBlock((ANCIENT_MOSS)))

    val ASHEN_MOSS = register("ashen_moss", MossyBlock(Mcf.ASHEN_MOSS_PATCH_BONE_MEAL, moss(MapColor.BLACK_TERRACOTTA)))
    val ASHEN_MOSS_CARPET = register("ashen_moss_carpet", ParentedCarpetBlock((ASHEN_MOSS)))

    val CHROME_MOSS =
        register("chrome_moss", MossyBlock(Mcf.CHROME_MOSS_PATCH_BONE_MEAL, moss(MapColor.GRAY_TERRACOTTA)))
    val CHROME_MOSS_CARPET = register("chrome_moss_carpet", ParentedCarpetBlock((CHROME_MOSS)))

    val DUSKY_MOSS =
        register("dusky_moss", MossyBlock(Mcf.DUSKY_MOSS_PATCH_BONE_MEAL, moss(MapColor.LIGHT_GRAY_TERRACOTTA)))
    val DUSKY_MOSS_CARPET = register("dusky_moss_carpet", ParentedCarpetBlock((DUSKY_MOSS)))

    val BONE_MOSS = register("bone_moss", MossyBlock(Mcf.BONE_MOSS_PATCH_BONE_MEAL, moss(MapColor.WHITE_TERRACOTTA)))
    val BONE_MOSS_CARPET = register("bone_moss_carpet", ParentedCarpetBlock((BONE_MOSS)))


    fun moss(color: MapColor): AbstractBlock.Settings = copy(Blocks.MOSS_BLOCK).mapColor(color)
    fun copy(block: Block): AbstractBlock.Settings = AbstractBlock.Settings.copy(block)

    fun <T : Block> register(name: String, block: T): Block {
        val blockReg = registerNoItem(name, block)
        MossyItems.register(name, BlockItem(blockReg))
        return blockReg
    }

    private fun <T : Block> registerNoItem(name: String, item: T): Block =
        BLOCKS.addAndGet(Registries.BLOCK.register(name, item))
}