package org.teamvoided.mossy_menagerie.init

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.Item
import net.minecraft.item.ItemConvertible
import net.minecraft.item.ItemGroup
import net.minecraft.registry.Holder
import net.minecraft.registry.Registries
import org.teamvoided.mossy_menagerie.MossyMenagerie.MODID
import org.teamvoided.mossy_menagerie.utils.registerHolder
import org.teamvoided.mossy_menagerie.utils.text

object MossyTabs {
    val MOSSY_TAB = register("mossy_tab", FabricItemGroup.builder()
        .icon(MossyBlocks.GLOOMING_MOSS.floweringBlock)
        .name("itemGroup.$MODID.mossy_tab")
        .tabBuilder { addStacks(MossyItems.ITEMS.map(Item::getDefaultStack)) }
    )

    fun init() = Unit

    @Suppress("SameParameterValue")
    private fun register(name: String, builder: ItemGroup.Builder): Holder<ItemGroup> =
        Registries.ITEM_GROUP.registerHolder(name, builder.build())

    private fun ItemGroup.Builder.icon(item: ItemConvertible): ItemGroup.Builder = icon { item.asItem().defaultStack }
    private fun ItemGroup.Builder.name(name: String): ItemGroup.Builder = name(name.text())
    private fun ItemGroup.Builder.tabBuilder(fn: ItemGroup.ItemStackCollector.() -> Unit): ItemGroup.Builder =
        entries { _, entries -> fn(entries) }
}
