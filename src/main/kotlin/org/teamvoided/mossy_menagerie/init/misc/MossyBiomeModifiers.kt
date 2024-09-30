package org.teamvoided.mossy_menagerie.init.misc

import net.fabricmc.fabric.api.biome.v1.*
import net.minecraft.world.gen.GenerationStep
import org.teamvoided.mossy_menagerie.MossyMenagerie.id
import org.teamvoided.mossy_menagerie.data.tags.MossyBiomeTags
import java.util.function.Consumer
import java.util.function.Predicate
import org.teamvoided.mossy_menagerie.data.world.gen.MossyPlacedFeatures as Mpf

object MossyBiomeModifiers {
    fun init() {
        addFeature(
            "fire_moss",
            BiomeSelectors.foundInTheNether()
        ) { it.generationSettings.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Mpf.FIRE_MOSS_PATCH) }
        addFeature(
            "fire_moss",
            BiomeSelectors.tag(MossyBiomeTags.HAS_DARK_MOSS)
        ) { it.generationSettings.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Mpf.FIRE_MOSS_PATCH) }
    }


    fun addFeature(
        name: String, selector: Predicate<BiomeSelectionContext>, modifier: Consumer<BiomeModificationContext>
    ) = BiomeModifications.create(id(name)).add(ModificationPhase.ADDITIONS, selector, modifier)

}
