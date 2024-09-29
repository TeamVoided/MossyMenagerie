package org.teamvoided.mossy_menagerie.init

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemGroup
import net.minecraft.registry.Holder
import net.minecraft.registry.Registries
import org.teamvoided.mossy_menagerie.MossyMenagerie.MODID
import org.teamvoided.mossy_menagerie.utils.registerHolder
import org.teamvoided.mossy_menagerie.utils.text

object MossyTabs {
    val MOSSY_TAB = register("mossy_tab",
        FabricItemGroup.builder()
            .icon { MossyBlocks.DARK_MOSS.asItem().defaultStack }
            .name("itemGroup.$MODID.mossy_tab".text())
            .entries { _, entries ->

                entries.addStacks(MossyItems.ITEMS.map { it.defaultStack })

            }
    )

    fun init() = Unit


    @Suppress("SameParameterValue")
    private fun register(name: String, builder: ItemGroup.Builder): Holder<ItemGroup> =
        Registries.ITEM_GROUP.registerHolder(name, builder.build())
}