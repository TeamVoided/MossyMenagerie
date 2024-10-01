package org.teamvoided.mossy_menagerie.block

import net.minecraft.block.BlockState
import net.minecraft.block.MossBlock
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos
import net.minecraft.util.random.RandomGenerator
import net.minecraft.world.WorldView
import net.minecraft.world.gen.feature.ConfiguredFeature
import org.teamvoided.mossy_menagerie.data.tags.MossyBlockTags

@Suppress("MemberVisibilityCanBePrivate")
class MossyBlock(val mossFeature: RegistryKey<ConfiguredFeature<*, *>>, settings: Settings) : MossBlock(settings) {
    override fun isFertilizable(world: WorldView, pos: BlockPos, state: BlockState): Boolean =
        world.getBlockState(pos.up()).isIn(MossyBlockTags.MOSS_CAN_GROW_UNDER)

    override fun fertilize(world: ServerWorld, random: RandomGenerator, pos: BlockPos, state: BlockState) {
        world.registryManager.getOptional(RegistryKeys.CONFIGURED_FEATURE).flatMap { it.getHolder(mossFeature) }
            .ifPresent { it.value().generate(world, world.chunkManager.chunkGenerator, random, pos.up()) }
    }
        }