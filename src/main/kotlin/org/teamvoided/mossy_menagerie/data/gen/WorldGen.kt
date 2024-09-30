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
import net.minecraft.util.math.Direction
import net.minecraft.util.math.VerticalSurfaceType
import net.minecraft.util.math.int_provider.ConstantIntProvider
import net.minecraft.util.math.int_provider.UniformIntProvider
import net.minecraft.world.gen.blockpredicate.BlockPredicate
import net.minecraft.world.gen.decorator.*
import net.minecraft.world.gen.feature.*
import net.minecraft.world.gen.feature.util.ConfiguredFeatureUtil
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil
import net.minecraft.world.gen.stateprovider.BlockStateProvider
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider
import org.teamvoided.mossy_menagerie.init.MossyFeatures.MOSSY_VEGETATION_PATCH
import java.util.concurrent.CompletableFuture
import org.teamvoided.mossy_menagerie.data.world.gen.MossyConfiguredFeatures as Mcf
import org.teamvoided.mossy_menagerie.data.world.gen.MossyPlacedFeatures as Mpf
import org.teamvoided.mossy_menagerie.init.MossyBlocks as Mb

class DynRegProvider(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>) :
    FabricDynamicRegistryProvider(o, r) {
    override fun getName(): String = "dwarf_forged/worldgen"
    override fun configure(reg: HolderLookup.Provider, entries: Entries) {
        entries.addAll(reg.getLookupOrThrow(RegistryKeys.CONFIGURED_FEATURE))
        entries.addAll(reg.getLookupOrThrow(RegistryKeys.PLACED_FEATURE))
    }
}

fun bootstrapConfiguredFeatures(c: BootstrapContext<ConfiguredFeature<*, *>>) {
    c.makeMossy(
        Mcf.FIRE_MOSS_VEGETATION,
        Mcf.FIRE_MOSS_PATCH,
        Mcf.FIRE_MOSS_PATCH_BONE_MEAL,
        Mb.FIRE_MOSS, Mb.FIRE_MOSS_CARPET
    )
    c.makeMossy(
        Mcf.RUSTY_MOSS_VEGETATION,
        Mcf.RUSTY_MOSS_PATCH,
        Mcf.RUSTY_MOSS_PATCH_BONE_MEAL,
        Mb.RUSTY_MOSS, Mb.RUSTY_MOSS_CARPET
    )
    c.makeMossy(
        Mcf.RICH_MOSS_VEGETATION,
        Mcf.RICH_MOSS_PATCH,
        Mcf.RICH_MOSS_PATCH_BONE_MEAL,
        Mb.RICH_MOSS, Mb.RICH_MOSS_CARPET
    )
    c.makeMossy(
        Mcf.DARK_MOSS_VEGETATION,
        Mcf.DARK_MOSS_PATCH,
        Mcf.DARK_MOSS_PATCH_BONE_MEAL,
        Mb.DARK_MOSS, Mb.DARK_MOSS_CARPET
    )
    c.makeMossy(
        Mcf.BRIGHT_MOSS_VEGETATION,
        Mcf.BRIGHT_MOSS_PATCH,
        Mcf.BRIGHT_MOSS_PATCH_BONE_MEAL,
        Mb.BRIGHT_MOSS, Mb.BRIGHT_MOSS_CARPET
    )
    c.makeMossy(
        Mcf.MARITIME_MOSS_VEGETATION,
        Mcf.MARITIME_MOSS_PATCH,
        Mcf.MARITIME_MOSS_PATCH_BONE_MEAL,
        Mb.MARITIME_MOSS, Mb.MARITIME_MOSS_CARPET
    )
    c.makeMossy(
        Mcf.FROST_MOSS_VEGETATION,
        Mcf.FROST_MOSS_PATCH,
        Mcf.FROST_MOSS_PATCH_BONE_MEAL,
        Mb.FROST_MOSS, Mb.FROST_MOSS_CARPET
    )
    c.makeMossy(
        Mcf.AZURE_MOSS_VEGETATION,
        Mcf.AZURE_MOSS_PATCH,
        Mcf.AZURE_MOSS_PATCH_BONE_MEAL,
        Mb.AZURE_MOSS, Mb.AZURE_MOSS_CARPET
    )
    c.makeMossy(
        Mcf.ARCANE_MOSS_VEGETATION,
        Mcf.ARCANE_MOSS_PATCH,
        Mcf.ARCANE_MOSS_PATCH_BONE_MEAL,
        Mb.ARCANE_MOSS, Mb.ARCANE_MOSS_CARPET
    )
    c.makeMossy(
        Mcf.TWISTED_MOSS_VEGETATION,
        Mcf.TWISTED_MOSS_PATCH,
        Mcf.TWISTED_MOSS_PATCH_BONE_MEAL,
        Mb.TWISTED_MOSS, Mb.TWISTED_MOSS_CARPET
    )
    c.makeMossy(
        Mcf.ROSY_MOSS_VEGETATION,
        Mcf.ROSY_MOSS_PATCH,
        Mcf.ROSY_MOSS_PATCH_BONE_MEAL,
        Mb.ROSY_MOSS, Mb.ROSY_MOSS_CARPET
    )
    c.makeMossy(
        Mcf.WOODED_MOSS_VEGETATION,
        Mcf.WOODED_MOSS_PATCH,
        Mcf.WOODED_MOSS_PATCH_BONE_MEAL,
        Mb.WOODED_MOSS, Mb.WOODED_MOSS_CARPET
    )
    c.makeMossy(
        Mcf.ASHEN_MOSS_VEGETATION,
        Mcf.ASHEN_MOSS_PATCH,
        Mcf.ASHEN_MOSS_PATCH_BONE_MEAL,
        Mb.ASHEN_MOSS, Mb.ASHEN_MOSS_CARPET
    )
    c.makeMossy(
        Mcf.CHROME_MOSS_VEGETATION,
        Mcf.CHROME_MOSS_PATCH,
        Mcf.CHROME_MOSS_PATCH_BONE_MEAL,
        Mb.CHROME_MOSS, Mb.CHROME_MOSS_CARPET
    )
    c.makeMossy(
        Mcf.DUSKY_MOSS_VEGETATION,
        Mcf.DUSKY_MOSS_PATCH,
        Mcf.DUSKY_MOSS_PATCH_BONE_MEAL,
        Mb.DUSKY_MOSS, Mb.DUSKY_MOSS_CARPET
    )
    c.makeMossy(
        Mcf.BONE_MOSS_VEGETATION,
        Mcf.BONE_MOSS_PATCH,
        Mcf.BONE_MOSS_PATCH_BONE_MEAL,
        Mb.BONE_MOSS, Mb.BONE_MOSS_CARPET
    )
}

fun bootstrapPlacedFeatures(c: BootstrapContext<PlacedFeature>) {
    val cfgFeat = c.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE)
    PlacedFeatureUtil.register(
        c,
        Mpf.FIRE_MOSS_PATCH,
        cfgFeat.getHolderOrThrow(Mcf.FIRE_MOSS_PATCH),
        CountPlacementModifier.create(10),
        InSquarePlacementModifier.getInstance(),
        PlacedFeatureUtil.BOTTOM_TO_MAX_TERRAIN_HEIGHT_RANGE,
        EnvironmentScanPlacementModifier.create(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.IS_AIR, 12),
        RandomOffsetPlacementModifier.vertical(ConstantIntProvider.create(1)),
        BiomePlacementModifier.getInstance()
    )
}

fun BootstrapContext<ConfiguredFeature<*, *>>.makeMossy(
    vegetation: RegistryKey<ConfiguredFeature<*, *>>,
    worldGen: RegistryKey<ConfiguredFeature<*, *>>,
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
        worldGen,
        MOSSY_VEGETATION_PATCH,
        VegetationPatchFeatureConfig(
            BlockTags.MOSS_REPLACEABLE,
            BlockStateProvider.of(moss),
            PlacedFeatureUtil.placedInline(cfgFeat.getHolderOrThrow(vegetation)),
            VerticalSurfaceType.FLOOR,
            ConstantIntProvider.create(1), 0.0f, 5, 0.8f, UniformIntProvider.create(4, 7), 0.3f
        )
    )
    ConfiguredFeatureUtil.register(
        this,
        boneMeal,
        MOSSY_VEGETATION_PATCH,
        VegetationPatchFeatureConfig(
            BlockTags.MOSS_REPLACEABLE,
            BlockStateProvider.of(moss),
            PlacedFeatureUtil.placedInline(cfgFeat.getHolderOrThrow(vegetation)),
            VerticalSurfaceType.FLOOR,
            ConstantIntProvider.create(1), 0.0f, 5, 0.6f, UniformIntProvider.create(1, 2), 0.75f
        )
    )
}