package org.teamvoided.mossy_menagerie.init

import net.minecraft.block.*
import net.minecraft.registry.Registries
import net.minecraft.world.gen.feature.UndergroundConfiguredFeatures
import org.teamvoided.mossy_menagerie.block.MossyBlock
import org.teamvoided.mossy_menagerie.block.ParentedCarpetBlock
import org.teamvoided.mossy_menagerie.utils.BlockItem
import org.teamvoided.mossy_menagerie.utils.addAndGet
import org.teamvoided.mossy_menagerie.utils.register

@Suppress("unused", "MemberVisibilityCanBePrivate")
object MossyBlocks {
    val BLOCKS = mutableSetOf<Block>()
    fun init() = Unit

    val x = UndergroundConfiguredFeatures.MOSS_PATCH_BONE_MEAL
    val FIRE_MOSS = register("fire_moss", MossyBlock(x, moss(MapColor.RED_TERRACOTTA)))
    val FIRE_MOSS_CARPET = register("fire_moss_carpet", ParentedCarpetBlock((FIRE_MOSS)))

    val RUSTY_MOSS = register("rusty_moss", MossyBlock(x, moss(MapColor.ORANGE_TERRACOTTA)))
    val RUSTY_MOSS_CARPET = register("rusty_moss_carpet", ParentedCarpetBlock((RUSTY_MOSS)))

    val RICH_MOSS = register("rich_moss", MossyBlock(x, moss(MapColor.YELLOW_TERRACOTTA)))
    val RICH_MOSS_CARPET = register("rich_moss_carpet", ParentedCarpetBlock((RICH_MOSS)))

    val DARK_MOSS = register("dark_moss", MossyBlock(x, moss(MapColor.GREEN_TERRACOTTA)))
    val DARK_MOSS_CARPET = register("dark_moss_carpet", ParentedCarpetBlock((DARK_MOSS)))

    val BRIGHT_MOSS = register("bright_moss", MossyBlock(x, moss(MapColor.LIME_TERRACOTTA)))
    val BRIGHT_MOSS_CARPET = register("bright_moss_carpet", ParentedCarpetBlock((BRIGHT_MOSS)))

    val MARITIME_MOSS = register("maritime_moss", MossyBlock(x, moss(MapColor.CYAN_TERRACOTTA)))
    val MARITIME_MOSS_CARPET = register("maritime_moss_carpet", ParentedCarpetBlock((MARITIME_MOSS)))

    val FROST_MOSS = register("frost_moss", MossyBlock(x, moss(MapColor.LIGHT_BLUE_TERRACOTTA)))
    val FROST_MOSS_CARPET = register("frost_moss_carpet", ParentedCarpetBlock((FROST_MOSS)))

    val AZURE_MOSS = register("azure_moss", MossyBlock(x, moss(MapColor.BLUE_TERRACOTTA)))
    val AZURE_MOSS_CARPET = register("azure_moss_carpet", ParentedCarpetBlock((AZURE_MOSS)))

    val ARCANE_MOSS = register("arcane_moss", MossyBlock(x, moss(MapColor.PURPLE_TERRACOTTA)))
    val ARCANE_MOSS_CARPET = register("arcane_moss_carpet", ParentedCarpetBlock((ARCANE_MOSS)))

    val TWISTED_MOSS = register("twisted_moss", MossyBlock(x, moss(MapColor.MAGENTA_TERRACOTTA)))
    val TWISTED_MOSS_CARPET = register("twisted_moss_carpet", ParentedCarpetBlock((TWISTED_MOSS)))

    val ROSY_MOSS = register("rosy_moss", MossyBlock(x, moss(MapColor.PINK_TERRACOTTA)))
    val ROSY_MOSS_CARPET = register("rosy_moss_carpet", ParentedCarpetBlock((ROSY_MOSS)))

    val WOODED_MOSS = register("wooded_moss", MossyBlock(x, moss(MapColor.BROWN_TERRACOTTA)))
    val WOODED_MOSS_CARPET = register("wooded_moss_carpet", ParentedCarpetBlock((WOODED_MOSS)))

    val ASHEN_MOSS = register("ashen_moss", MossyBlock(x, moss(MapColor.BLACK_TERRACOTTA)))
    val ASHEN_MOSS_CARPET = register("ashen_moss_carpet", ParentedCarpetBlock((ASHEN_MOSS)))

    val CHROME_MOSS = register("chrome_moss", MossyBlock(x, moss(MapColor.GRAY_TERRACOTTA)))
    val CHROME_MOSS_CARPET = register("chrome_moss_carpet", ParentedCarpetBlock((CHROME_MOSS)))

    val PALE_MOSS = register("pale_moss", MossyBlock(x, moss(MapColor.LIGHT_GRAY_TERRACOTTA)))
    val PALE_MOSS_CARPET = register("pale_moss_carpet", ParentedCarpetBlock((PALE_MOSS)))

    val BONE_MOSS = register("bone_moss", MossyBlock(x, moss(MapColor.WHITE_TERRACOTTA)))
    val BONE_MOSS_CARPET = register("bone_moss_carpet", ParentedCarpetBlock((BONE_MOSS)))


    fun moss(color: MapColor) = copy(Blocks.MOSS_BLOCK).mapColor(color)

    fun copy(block: Block): AbstractBlock.Settings = AbstractBlock.Settings.copy(block)

    fun <T : Block> register(name: String, block: T): Block {
        val blockReg = registerNoItem(name, block)
        MossyItems.register(name, BlockItem(blockReg))
        return blockReg
    }

    private fun <T : Block> registerNoItem(name: String, item: T): Block =
        BLOCKS.addAndGet(Registries.BLOCK.register(name, item))
}