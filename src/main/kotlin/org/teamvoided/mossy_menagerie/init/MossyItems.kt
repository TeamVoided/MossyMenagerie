package org.teamvoided.mossy_menagerie.init

import net.minecraft.item.Item
import net.minecraft.registry.Registries
import org.teamvoided.mossy_menagerie.utils.addAndGet
import org.teamvoided.mossy_menagerie.utils.register

object MossyItems {
    val ITEMS = mutableSetOf<Item>()
    fun init() = Unit


    fun <T : Item> register(name: String, item: T): Item = ITEMS.addAndGet(registerNoTab(name, item))
    private fun <T : Item> registerNoTab(name: String, item: T): Item = Registries.ITEM.register(name, item)
}