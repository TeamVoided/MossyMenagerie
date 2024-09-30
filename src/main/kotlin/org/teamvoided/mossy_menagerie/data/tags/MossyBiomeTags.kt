package org.teamvoided.mossy_menagerie.data.tags

import net.minecraft.registry.RegistryKeys
import org.teamvoided.mossy_menagerie.MossyMenagerie.id
import org.teamvoided.mossy_menagerie.utils.tag

object MossyBiomeTags {
    val HAS_DARK_MOSS = has("dark_moss")


    private fun has(name: String) = create("has/$name")
    private fun create(name: String) = RegistryKeys.BIOME.tag(id(name))
}