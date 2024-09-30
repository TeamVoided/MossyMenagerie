package org.teamvoided.mossy_menagerie.init

import net.minecraft.registry.Registries
import net.minecraft.world.gen.feature.Feature
import net.minecraft.world.gen.feature.FeatureConfig
import org.teamvoided.mossy_menagerie.utils.register
import org.teamvoided.mossy_menagerie.world.gen.MossyVegetationPatchFeature
import net.minecraft.world.gen.feature.VegetationPatchFeatureConfig as VpfCfg

object MossyFeatures {
    fun init() = Unit
    val MOSSY_VEGETATION_PATCH = register("mossy_vegetation_patch", MossyVegetationPatchFeature(VpfCfg.CODEC))

    private fun <C : FeatureConfig, T : Feature<C>> register(name: String, item: T): Feature<C> =
        Registries.FEATURE.register(name, item) as T
}