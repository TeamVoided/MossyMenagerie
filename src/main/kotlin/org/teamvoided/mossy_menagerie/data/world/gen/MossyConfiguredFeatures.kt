package org.teamvoided.mossy_menagerie.data.world.gen

import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.world.gen.feature.ConfiguredFeature
import org.teamvoided.mossy_menagerie.MossyMenagerie.id
import org.teamvoided.mossy_menagerie.utils.key

object MossyConfiguredFeatures {
    val FIRE_MOSS_VEGETATION = create("fire_moss_vegetation")
    val FIRE_MOSS_PATCH_BONE_MEAL = create("fire_moss_patch_bone_meal")

    val RUSTY_MOSS_VEGETATION = create("rusty_moss_vegetation")
    val RUSTY_MOSS_PATCH_BONE_MEAL = create("rusty_moss_patch_bone_meal")

    val RICH_MOSS_VEGETATION = create("rich_moss_vegetation")
    val RICH_MOSS_PATCH_BONE_MEAL = create("rich_moss_patch_bone_meal")

    val DARK_MOSS_VEGETATION = create("dark_moss_vegetation")
    val DARK_MOSS_PATCH_BONE_MEAL = create("dark_moss_patch_bone_meal")

    val BRIGHT_MOSS_VEGETATION = create("bright_moss_vegetation")
    val BRIGHT_MOSS_PATCH_BONE_MEAL = create("bright_moss_patch_bone_meal")

    val MARITIME_MOSS_VEGETATION = create("maritime_moss_vegetation")
    val MARITIME_MOSS_PATCH_BONE_MEAL = create("maritime_moss_patch_bone_meal")

    val FROST_MOSS_VEGETATION = create("frost_moss_vegetation")
    val FROST_MOSS_PATCH_BONE_MEAL = create("frost_moss_patch_bone_meal")

    val AZURE_MOSS_VEGETATION = create("azure_moss_vegetation")
    val AZURE_MOSS_PATCH_BONE_MEAL = create("azure_moss_patch_bone_meal")

    val ARCANE_MOSS_VEGETATION = create("arcane_moss_vegetation")
    val ARCANE_MOSS_PATCH_BONE_MEAL = create("arcane_moss_patch_bone_meal")

    val TWISTED_MOSS_VEGETATION = create("twisted_moss_vegetation")
    val TWISTED_MOSS_PATCH_BONE_MEAL = create("twisted_moss_patch_bone_meal")

    val ROSY_MOSS_VEGETATION = create("rosy_moss_vegetation")
    val ROSY_MOSS_PATCH_BONE_MEAL = create("rosy_moss_patch_bone_meal")

    val WOODED_MOSS_VEGETATION = create("wooded_moss_vegetation")
    val WOODED_MOSS_PATCH_BONE_MEAL = create("wooded_moss_patch_bone_meal")

    val ASHEN_MOSS_VEGETATION = create("ashen_moss_vegetation")
    val ASHEN_MOSS_PATCH_BONE_MEAL = create("ashen_moss_patch_bone_meal")

    val CHROME_MOSS_VEGETATION = create("chrome_moss_vegetation")
    val CHROME_MOSS_PATCH_BONE_MEAL = create("chrome_moss_patch_bone_meal")

    val DUSKY_MOSS_VEGETATION = create("pale_moss_vegetation")
    val DUSKY_MOSS_PATCH_BONE_MEAL = create("pale_moss_patch_bone_meal")

    val BONE_MOSS_VEGETATION = create("bone_moss_vegetation")
    val BONE_MOSS_PATCH_BONE_MEAL = create("bone_moss_patch_bone_meal")

    private fun create(id: String): RegistryKey<ConfiguredFeature<*, *>> = RegistryKeys.CONFIGURED_FEATURE.key(id(id))
}