package org.teamvoided.mossy_menagerie.data.gen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.registry.BootstrapContext
import net.minecraft.registry.HolderLookup
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.BlockTags
import net.minecraft.util.collection.DataPool
import net.minecraft.util.math.VerticalSurfaceType
import net.minecraft.util.math.int_provider.ConstantIntProvider
import net.minecraft.util.math.int_provider.UniformIntProvider
import net.minecraft.world.gen.feature.ConfiguredFeature
import net.minecraft.world.gen.feature.Feature
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig
import net.minecraft.world.gen.feature.VegetationPatchFeatureConfig
import net.minecraft.world.gen.feature.util.ConfiguredFeatureUtil
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil
import net.minecraft.world.gen.stateprovider.BlockStateProvider
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider
import org.teamvoided.mossy_menagerie.init.MossyBlocks.ARCANE_MOSS
import org.teamvoided.mossy_menagerie.init.MossyBlocks.ARCANE_MOSS_CARPET
import org.teamvoided.mossy_menagerie.init.MossyBlocks.ASHEN_MOSS
import org.teamvoided.mossy_menagerie.init.MossyBlocks.ASHEN_MOSS_CARPET
import org.teamvoided.mossy_menagerie.init.MossyBlocks.AZURE_MOSS
import org.teamvoided.mossy_menagerie.init.MossyBlocks.AZURE_MOSS_CARPET
import org.teamvoided.mossy_menagerie.init.MossyBlocks.BONE_MOSS
import org.teamvoided.mossy_menagerie.init.MossyBlocks.BONE_MOSS_CARPET
import org.teamvoided.mossy_menagerie.init.MossyBlocks.BRIGHT_MOSS
import org.teamvoided.mossy_menagerie.init.MossyBlocks.BRIGHT_MOSS_CARPET
import org.teamvoided.mossy_menagerie.init.MossyBlocks.CHROME_MOSS
import org.teamvoided.mossy_menagerie.init.MossyBlocks.CHROME_MOSS_CARPET
import org.teamvoided.mossy_menagerie.init.MossyBlocks.DARK_MOSS
import org.teamvoided.mossy_menagerie.init.MossyBlocks.DARK_MOSS_CARPET
import org.teamvoided.mossy_menagerie.init.MossyBlocks.DUSKY_MOSS
import org.teamvoided.mossy_menagerie.init.MossyBlocks.DUSKY_MOSS_CARPET
import org.teamvoided.mossy_menagerie.init.MossyBlocks.FIRE_MOSS
import org.teamvoided.mossy_menagerie.init.MossyBlocks.FIRE_MOSS_CARPET
import org.teamvoided.mossy_menagerie.init.MossyBlocks.FROST_MOSS
import org.teamvoided.mossy_menagerie.init.MossyBlocks.FROST_MOSS_CARPET
import org.teamvoided.mossy_menagerie.init.MossyBlocks.MARITIME_MOSS
import org.teamvoided.mossy_menagerie.init.MossyBlocks.MARITIME_MOSS_CARPET
import org.teamvoided.mossy_menagerie.init.MossyBlocks.RICH_MOSS
import org.teamvoided.mossy_menagerie.init.MossyBlocks.RICH_MOSS_CARPET
import org.teamvoided.mossy_menagerie.init.MossyBlocks.ROSY_MOSS
import org.teamvoided.mossy_menagerie.init.MossyBlocks.ROSY_MOSS_CARPET
import org.teamvoided.mossy_menagerie.init.MossyBlocks.RUSTY_MOSS
import org.teamvoided.mossy_menagerie.init.MossyBlocks.RUSTY_MOSS_CARPET
import org.teamvoided.mossy_menagerie.init.MossyBlocks.TWISTED_MOSS
import org.teamvoided.mossy_menagerie.init.MossyBlocks.TWISTED_MOSS_CARPET
import org.teamvoided.mossy_menagerie.init.MossyBlocks.WOODED_MOSS
import org.teamvoided.mossy_menagerie.init.MossyBlocks.WOODED_MOSS_CARPET
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.ARCANE_MOSS_PATCH_BONE_MEAL
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.ARCANE_MOSS_VEGETATION
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.ASHEN_MOSS_PATCH_BONE_MEAL
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.ASHEN_MOSS_VEGETATION
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.AZURE_MOSS_PATCH_BONE_MEAL
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.AZURE_MOSS_VEGETATION
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.BONE_MOSS_PATCH_BONE_MEAL
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.BONE_MOSS_VEGETATION
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.BRIGHT_MOSS_PATCH_BONE_MEAL
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.BRIGHT_MOSS_VEGETATION
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.CHROME_MOSS_PATCH_BONE_MEAL
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.CHROME_MOSS_VEGETATION
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.DARK_MOSS_PATCH_BONE_MEAL
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.DARK_MOSS_VEGETATION
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.FIRE_MOSS_PATCH_BONE_MEAL
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.FIRE_MOSS_VEGETATION
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.FROST_MOSS_PATCH_BONE_MEAL
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.FROST_MOSS_VEGETATION
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.MARITIME_MOSS_PATCH_BONE_MEAL
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.MARITIME_MOSS_VEGETATION
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.DUSKY_MOSS_PATCH_BONE_MEAL
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.DUSKY_MOSS_VEGETATION
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.RICH_MOSS_PATCH_BONE_MEAL
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.RICH_MOSS_VEGETATION
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.ROSY_MOSS_PATCH_BONE_MEAL
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.ROSY_MOSS_VEGETATION
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.RUSTY_MOSS_PATCH_BONE_MEAL
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.RUSTY_MOSS_VEGETATION
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.TWISTED_MOSS_PATCH_BONE_MEAL
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.TWISTED_MOSS_VEGETATION
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.WOODED_MOSS_PATCH_BONE_MEAL
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures.WOODED_MOSS_VEGETATION
import java.util.concurrent.CompletableFuture

class DynRegProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) :
    FabricDynamicRegistryProvider(o, r) {
    override fun getName(): String = "dwarf_forged/worldgen"
    override fun configure(reg: HolderLookup.Provider, entries: Entries) {
        entries.addAll(reg.getLookupOrThrow(RegistryKeys.CONFIGURED_FEATURE))
        entries.addAll(reg.getLookupOrThrow(RegistryKeys.PLACED_FEATURE))
    }
}

fun bootstrapConfiguredFeatures(context: BootstrapContext<ConfiguredFeature<*, *>>) {
    context.makeMossy(FIRE_MOSS_VEGETATION, FIRE_MOSS_PATCH_BONE_MEAL, FIRE_MOSS, FIRE_MOSS_CARPET)
    context.makeMossy(RUSTY_MOSS_VEGETATION, RUSTY_MOSS_PATCH_BONE_MEAL, RUSTY_MOSS, RUSTY_MOSS_CARPET)
    context.makeMossy(RICH_MOSS_VEGETATION, RICH_MOSS_PATCH_BONE_MEAL, RICH_MOSS, RICH_MOSS_CARPET)
    context.makeMossy(DARK_MOSS_VEGETATION, DARK_MOSS_PATCH_BONE_MEAL, DARK_MOSS, DARK_MOSS_CARPET)
    context.makeMossy(BRIGHT_MOSS_VEGETATION, BRIGHT_MOSS_PATCH_BONE_MEAL, BRIGHT_MOSS, BRIGHT_MOSS_CARPET)
    context.makeMossy(MARITIME_MOSS_VEGETATION, MARITIME_MOSS_PATCH_BONE_MEAL, MARITIME_MOSS, MARITIME_MOSS_CARPET)
    context.makeMossy(FROST_MOSS_VEGETATION, FROST_MOSS_PATCH_BONE_MEAL, FROST_MOSS, FROST_MOSS_CARPET)
    context.makeMossy(AZURE_MOSS_VEGETATION, AZURE_MOSS_PATCH_BONE_MEAL, AZURE_MOSS, AZURE_MOSS_CARPET)
    context.makeMossy(ARCANE_MOSS_VEGETATION, ARCANE_MOSS_PATCH_BONE_MEAL, ARCANE_MOSS, ARCANE_MOSS_CARPET)
    context.makeMossy(TWISTED_MOSS_VEGETATION, TWISTED_MOSS_PATCH_BONE_MEAL, TWISTED_MOSS, TWISTED_MOSS_CARPET)
    context.makeMossy(ROSY_MOSS_VEGETATION, ROSY_MOSS_PATCH_BONE_MEAL, ROSY_MOSS, ROSY_MOSS_CARPET)
    context.makeMossy(WOODED_MOSS_VEGETATION, WOODED_MOSS_PATCH_BONE_MEAL, WOODED_MOSS, WOODED_MOSS_CARPET)
    context.makeMossy(ASHEN_MOSS_VEGETATION, ASHEN_MOSS_PATCH_BONE_MEAL, ASHEN_MOSS, ASHEN_MOSS_CARPET)
    context.makeMossy(CHROME_MOSS_VEGETATION, CHROME_MOSS_PATCH_BONE_MEAL, CHROME_MOSS, CHROME_MOSS_CARPET)
    context.makeMossy(DUSKY_MOSS_VEGETATION, DUSKY_MOSS_PATCH_BONE_MEAL, DUSKY_MOSS, DUSKY_MOSS_CARPET)
    context.makeMossy(BONE_MOSS_VEGETATION, BONE_MOSS_PATCH_BONE_MEAL, BONE_MOSS, BONE_MOSS_CARPET)
}

fun BootstrapContext<ConfiguredFeature<*, *>>.makeMossy(
    vegetation: RegistryKey<ConfiguredFeature<*, *>>,
    boneMeal: RegistryKey<ConfiguredFeature<*, *>>,
    moss: Block,
    mossCarpet: Block,
) {
    val cfgFeat = this.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE)
    ConfiguredFeatureUtil.register(
        this,
        vegetation,
        Feature.SIMPLE_BLOCK,
        SimpleBlockFeatureConfig(
            WeightedBlockStateProvider(
                DataPool.builder<BlockState>()
//                    .addWeighted(Blocks.FLOWERING_AZALEA.defaultState, 4)
//                    .addWeighted(Blocks.AZALEA.defaultState, 7)
                    .addWeighted(mossCarpet.defaultState, 25)
                    .addWeighted(Blocks.SHORT_GRASS.defaultState, 50)
                    .addWeighted(Blocks.TALL_GRASS.defaultState, 10)
            )
        )
    )
    ConfiguredFeatureUtil.register(
        this,
        boneMeal,
        Feature.VEGETATION_PATCH,
        VegetationPatchFeatureConfig(
            BlockTags.MOSS_REPLACEABLE,
            BlockStateProvider.of(moss),
            PlacedFeatureUtil.placedInline(cfgFeat.getHolderOrThrow(vegetation)),
            VerticalSurfaceType.FLOOR,
            ConstantIntProvider.create(1), 0.0f, 5, 0.6f, UniformIntProvider.create(1, 2), 0.75f
        )
    )
}