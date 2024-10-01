package org.teamvoided.mossy_menagerie.data.world.gen

import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.world.gen.feature.ConfiguredFeature
import org.teamvoided.mossy_menagerie.MossyMenagerie.id
import org.teamvoided.mossy_menagerie.utils.key

object MossyConfiguredFeatures {
    val CRIMSON_MOSS_VEGETATION = create("crimson_moss_vegetation")
    val CRIMSON_MOSS_PATCH = create("crimson_moss_patch")
    val CRIMSON_MOSS_PATCH_BONE_MEAL = create("crimson_moss_patch_bone_meal")

    val MAGMATIC_MOSS_VEGETATION = create("magmatic_moss_vegetation")
    val MAGMATIC_MOSS_PATCH = create("magmatic_moss_patch")
    val MAGMATIC_MOSS_PATCH_BONE_MEAL = create("magmatic_moss_patch_bone_meal")

    val ROYAL_MOSS_VEGETATION = create("royal_moss_vegetation")
    val ROYAL_MOSS_PATCH = create("royal_moss_patch")
    val ROYAL_MOSS_PATCH_BONE_MEAL = create("royal_moss_patch_bone_meal")

    val GLOWING_MOSS_VEGETATION = create("glowing_moss_vegetation")
    val GLOWING_MOSS_PATCH = create("glowing_moss_patch")
    val GLOWING_MOSS_PATCH_BONE_MEAL = create("glowing_moss_patch_bone_meal")

    val GLOOMING_MOSS_VEGETATION = create("glooming_moss_vegetation")
    val GLOOMING_MOSS_PATCH = create("glooming_moss_patch")
    val GLOOMING_MOSS_PATCH_BONE_MEAL = create("glooming_moss_patch_bone_meal")

    val MARITIME_MOSS_VEGETATION = create("maritime_moss_vegetation")
    val MARITIME_MOSS_PATCH = create("maritime_moss_patch")
    val MARITIME_MOSS_PATCH_BONE_MEAL = create("maritime_moss_patch_bone_meal")

    val WARPED_MOSS_VEGETATION = create("warped_moss_vegetation")
    val WARPED_MOSS_PATCH = create("warped_moss_patch")
    val WARPED_MOSS_PATCH_BONE_MEAL = create("warped_moss_patch_bone_meal")

    val AZURE_MOSS_VEGETATION = create("azure_moss_vegetation")
    val AZURE_MOSS_PATCH = create("azure_moss_patch")
    val AZURE_MOSS_PATCH_BONE_MEAL = create("azure_moss_patch_bone_meal")

    val ARCANE_MOSS_VEGETATION = create("arcane_moss_vegetation")
    val ARCANE_MOSS_PATCH = create("arcane_moss_patch")
    val ARCANE_MOSS_PATCH_BONE_MEAL = create("arcane_moss_patch_bone_meal")

    val TWISTED_MOSS_VEGETATION = create("twisted_moss_vegetation")
    val TWISTED_MOSS_PATCH = create("twisted_moss_patch")
    val TWISTED_MOSS_PATCH_BONE_MEAL = create("twisted_moss_patch_bone_meal")

    val ROSY_MOSS_VEGETATION = create("rosy_moss_vegetation")
    val ROSY_MOSS_PATCH = create("rosy_moss_patch")
    val ROSY_MOSS_PATCH_BONE_MEAL = create("rosy_moss_patch_bone_meal")

    val ANCIENT_MOSS_VEGETATION = create("ancient_moss_vegetation")
    val ANCIENT_MOSS_PATCH = create("ancient_moss_patch")
    val ANCIENT_MOSS_PATCH_BONE_MEAL = create("ancient_moss_patch_bone_meal")

    val ASHEN_MOSS_VEGETATION = create("ashen_moss_vegetation")
    val ASHEN_MOSS_PATCH = create("ashen_moss_patch")
    val ASHEN_MOSS_PATCH_BONE_MEAL = create("ashen_moss_patch_bone_meal")

    val CHROME_MOSS_VEGETATION = create("chrome_moss_vegetation")
    val CHROME_MOSS_PATCH = create("chrome_moss_patch")
    val CHROME_MOSS_PATCH_BONE_MEAL = create("chrome_moss_patch_bone_meal")

    val DUSKY_MOSS_VEGETATION = create("pale_moss_vegetation")
    val DUSKY_MOSS_PATCH = create("pale_moss_patch")
    val DUSKY_MOSS_PATCH_BONE_MEAL = create("pale_moss_patch_bone_meal")

    val BONE_MOSS_VEGETATION = create("bone_moss_vegetation")
    val BONE_MOSS_PATCH = create("bone_moss_patch")
    val BONE_MOSS_PATCH_BONE_MEAL = create("bone_moss_patch_bone_meal")

    private fun create(id: String): RegistryKey<ConfiguredFeature<*, *>> = RegistryKeys.CONFIGURED_FEATURE.key(id(id))
}