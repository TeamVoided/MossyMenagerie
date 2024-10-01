package org.teamvoided.mossy_menagerie.data.world.gen

import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.world.gen.feature.PlacedFeature
import org.teamvoided.mossy_menagerie.MossyMenagerie.id
import org.teamvoided.mossy_menagerie.utils.key

object MossyPlacedFeatures {
    val CRIMSON_MOSS_PATCH = create("crimson_moss_patch")
    val MAGMATIC_MOSS_PATCH = create("magmatic_moss_patch")
//    val ROYAL_MOSS_PATCH = create("royal_moss_patch")
    val GLOWING_MOSS_PATCH = create("glowing_moss_patch")
    val GLOOMING_MOSS_PATCH = create("glooming_moss_patch")
    val MARITIME_MOSS_PATCH = create("maritime_moss_patch")
    val WARPED_MOSS_PATCH = create("warped_moss_patch")
    val AZURE_MOSS_PATCH = create("azure_moss_patch")
    val ARCANE_MOSS_PATCH = create("arcane_moss_patch")
    val TWISTED_MOSS_PATCH = create("twisted_moss_patch")
    val ROSY_MOSS_PATCH = create("rosy_moss_patch")
    val ANCIENT_MOSS_PATCH = create("ancient_moss_patch")
    val ASHEN_MOSS_PATCH = create("ashen_moss_patch")
    val CHROME_MOSS_PATCH = create("chrome_moss_patch")
    val DUSKY_MOSS_PATCH = create("pale_moss_patch")
    val BONE_MOSS_PATCH = create("bone_moss_patch")

    private fun create(id: String): RegistryKey<PlacedFeature> = RegistryKeys.PLACED_FEATURE.key(id(id))
}