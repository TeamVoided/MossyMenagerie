package org.teamvoided.mossy_menagerie.data.tags

import net.minecraft.registry.RegistryKeys
import org.teamvoided.mossy_menagerie.MossyMenagerie.id
import org.teamvoided.mossy_menagerie.utils.tag

object MossyBlockTags {
    // Conventional
    val MOSS = conventional("moss")
    val MOSS_CARPETS = conventional("moss_carpets")
    // Mossy
    val MOSSY_CARPETS = create("mossy_carpets")
    val MOSS_CAN_GROW_UNDER = create("moss_can_grow_under")


    private fun create(name: String) = RegistryKeys.BLOCK.tag(id(name))
    private fun conventional(name: String) = RegistryKeys.BLOCK.tag(id("c", name))
}