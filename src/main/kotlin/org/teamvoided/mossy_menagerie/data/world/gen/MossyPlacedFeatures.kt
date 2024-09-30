package org.teamvoided.mossy_menagerie.data.world.gen

import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.world.gen.feature.PlacedFeature
import org.teamvoided.mossy_menagerie.MossyMenagerie.id
import org.teamvoided.mossy_menagerie.utils.key

object MossyPlacedFeatures {
    val FIRE_MOSS_PATCH = create("fire_moss_patch")
    val RUSTY_MOSS_PATCH = create("rusty_moss_patch")
    val RICH_MOSS_PATCH = create("rich_moss_patch")
    val DARK_MOSS_PATCH = create("dark_moss_patch")
    val BRIGHT_MOSS_PATCH = create("bright_moss_patch")
    val MARITIME_MOSS_PATCH = create("maritime_moss_patch")
    val FROST_MOSS_PATCH = create("frost_moss_patch")
    val AZURE_MOSS_PATCH = create("azure_moss_patch")
    val ARCANE_MOSS_PATCH = create("arcane_moss_patch")
    val TWISTED_MOSS_PATCH = create("twisted_moss_patch")
    val ROSY_MOSS_PATCH = create("rosy_moss_patch")
    val WOODED_MOSS_PATCH = create("wooded_moss_patch")
    val ASHEN_MOSS_PATCH = create("ashen_moss_patch")
    val CHROME_MOSS_PATCH = create("chrome_moss_patch")
    val DUSKY_MOSS_PATCH = create("pale_moss_patch")
    val BONE_MOSS_PATCH = create("bone_moss_patch")

    private fun create(id: String): RegistryKey<PlacedFeature> = RegistryKeys.PLACED_FEATURE.key(id(id))
}