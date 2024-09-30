package org.teamvoided.mossy_menagerie.init.misc

import net.fabricmc.fabric.api.biome.v1.*
import net.minecraft.registry.RegistryKey
import net.minecraft.world.gen.GenerationStep
import net.minecraft.world.gen.feature.PlacedFeature
import org.teamvoided.mossy_menagerie.MossyMenagerie.id
import org.teamvoided.mossy_menagerie.data.tags.MossyBiomeTags
import java.util.function.Consumer
import java.util.function.Predicate
import org.teamvoided.mossy_menagerie.data.world.gen.MossyPlacedFeatures as Mpf

object MossyBiomeModifiers {
    fun init() {
        addVegetalDeco("fire_moss", BiomeSelectors.foundInTheNether(), Mpf.FIRE_MOSS_PATCH)
        addVegetalDeco("fire_moss", BiomeSelectors.tag(MossyBiomeTags.HAS_DARK_MOSS), Mpf.DARK_MOSS_PATCH)
    }

    fun addVegetalDeco(name: String, selector: Predicate<BiomeSelectionContext>, feature: RegistryKey<PlacedFeature>) =
        addFeature(name, selector) {
            it.generationSettings.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, feature)
        }

    fun addFeature(
        name: String, selector: Predicate<BiomeSelectionContext>, modifier: Consumer<BiomeModificationContext>
    ): BiomeModification =
        BiomeModifications.create(id(name)).add(ModificationPhase.ADDITIONS, selector, modifier)

}
