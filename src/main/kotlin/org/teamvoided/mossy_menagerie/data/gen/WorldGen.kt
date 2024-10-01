package org.teamvoided.mossy_menagerie.data.gen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
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
import org.teamvoided.mossy_menagerie.data.Moss
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
        Mcf.CRIMSON_MOSS_VEGETATION,
        Mcf.CRIMSON_MOSS_PATCH,
        Mcf.CRIMSON_MOSS_PATCH_BONE_MEAL,
        Mb.CRIMSON_MOSS
    )
    c.makeMossy(
        Mcf.MAGMATIC_MOSS_VEGETATION,
        Mcf.MAGMATIC_MOSS_PATCH,
        Mcf.MAGMATIC_MOSS_PATCH_BONE_MEAL,
        Mb.MAGMATIC_MOSS,
    )
    c.makeMossy(
        Mcf.ROYAL_MOSS_VEGETATION,
        Mcf.ROYAL_MOSS_PATCH,
        Mcf.ROYAL_MOSS_PATCH_BONE_MEAL,
        Mb.ROYAL_MOSS,
    )
    c.makeMossy(
        Mcf.GLOOMING_MOSS_VEGETATION,
        Mcf.GLOOMING_MOSS_PATCH,
        Mcf.GLOOMING_MOSS_PATCH_BONE_MEAL,
        Mb.GLOOMING_MOSS,
    )
    c.makeMossy(
        Mcf.GLOWING_MOSS_VEGETATION,
        Mcf.GLOWING_MOSS_PATCH,
        Mcf.GLOWING_MOSS_PATCH_BONE_MEAL,
        Mb.GLOWING_MOSS,
    )
    c.makeMossy(
        Mcf.MARITIME_MOSS_VEGETATION,
        Mcf.MARITIME_MOSS_PATCH,
        Mcf.MARITIME_MOSS_PATCH_BONE_MEAL,
        Mb.MARITIME_MOSS
    )
    c.makeMossy(
        Mcf.WARPED_MOSS_VEGETATION,
        Mcf.WARPED_MOSS_PATCH,
        Mcf.WARPED_MOSS_PATCH_BONE_MEAL,
        Mb.WARPED_MOSS,
    )
    c.makeMossy(
        Mcf.AZURE_MOSS_VEGETATION,
        Mcf.AZURE_MOSS_PATCH,
        Mcf.AZURE_MOSS_PATCH_BONE_MEAL,
        Mb.AZURE_MOSS,
    )
    c.makeMossy(
        Mcf.ARCANE_MOSS_VEGETATION,
        Mcf.ARCANE_MOSS_PATCH,
        Mcf.ARCANE_MOSS_PATCH_BONE_MEAL,
        Mb.ARCANE_MOSS,
    )
    c.makeMossy(
        Mcf.TWISTED_MOSS_VEGETATION,
        Mcf.TWISTED_MOSS_PATCH,
        Mcf.TWISTED_MOSS_PATCH_BONE_MEAL,
        Mb.TWISTED_MOSS,
    )
    c.makeMossy(
        Mcf.ROSY_MOSS_VEGETATION,
        Mcf.ROSY_MOSS_PATCH,
        Mcf.ROSY_MOSS_PATCH_BONE_MEAL,
        Mb.ROSY_MOSS,
    )
    c.makeMossy(
        Mcf.ANCIENT_MOSS_VEGETATION,
        Mcf.ANCIENT_MOSS_PATCH,
        Mcf.ANCIENT_MOSS_PATCH_BONE_MEAL,
        Mb.ANCIENT_MOSS,
    )
    c.makeMossy(
        Mcf.ASHEN_MOSS_VEGETATION,
        Mcf.ASHEN_MOSS_PATCH,
        Mcf.ASHEN_MOSS_PATCH_BONE_MEAL,
        Mb.ASHEN_MOSS,
    )
    c.makeMossy(
        Mcf.CHROME_MOSS_VEGETATION,
        Mcf.CHROME_MOSS_PATCH,
        Mcf.CHROME_MOSS_PATCH_BONE_MEAL,
        Mb.CHROME_MOSS,
    )
    c.makeMossy(
        Mcf.DUSKY_MOSS_VEGETATION,
        Mcf.DUSKY_MOSS_PATCH,
        Mcf.DUSKY_MOSS_PATCH_BONE_MEAL,
        Mb.DUSKY_MOSS,
    )
    c.makeMossy(
        Mcf.BONE_MOSS_VEGETATION,
        Mcf.BONE_MOSS_PATCH,
        Mcf.BONE_MOSS_PATCH_BONE_MEAL,
        Mb.BONE_MOSS,
    )
}

fun bootstrapPlacedFeatures(c: BootstrapContext<PlacedFeature>) {
    val cfgFeat = c.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE)
    PlacedFeatureUtil.register(
        c,
        Mpf.CRIMSON_MOSS_PATCH,
        cfgFeat.getHolderOrThrow(Mcf.CRIMSON_MOSS_PATCH),
        CountPlacementModifier.create(10),
        InSquarePlacementModifier.getInstance(),
        PlacedFeatureUtil.BOTTOM_TO_MAX_TERRAIN_HEIGHT_RANGE,
        EnvironmentScanPlacementModifier.create(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.IS_AIR, 12),
        RandomOffsetPlacementModifier.vertical(ConstantIntProvider.create(1)),
        BiomePlacementModifier.getInstance()
    )
    PlacedFeatureUtil.register(
        c,
        Mpf.GLOOMING_MOSS_PATCH,
        cfgFeat.getHolderOrThrow(Mcf.GLOOMING_MOSS_PATCH),
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
    moss: Moss
) {
    val cfgFeat = this.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE)
    ConfiguredFeatureUtil.register(
        this,
        vegetation,
        Feature.SIMPLE_BLOCK,
        SimpleBlockFeatureConfig(
            WeightedBlockStateProvider(
                DataPool.builder<BlockState>()
                    .addWeighted(moss.floweringAzalea.defaultState, 4)
                    .addWeighted(moss.azalea.defaultState, 7)
                    .addWeighted(moss.carpet.defaultState, 25)
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
            BlockStateProvider.of(moss.get()),
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
            BlockStateProvider.of(moss.get()),
            PlacedFeatureUtil.placedInline(cfgFeat.getHolderOrThrow(vegetation)),
            VerticalSurfaceType.FLOOR,
            ConstantIntProvider.create(1), 0.0f, 5, 0.6f, UniformIntProvider.create(1, 2), 0.75f
        )
    )
}