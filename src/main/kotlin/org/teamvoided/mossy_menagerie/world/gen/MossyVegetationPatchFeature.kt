package org.teamvoided.mossy_menagerie.world.gen

import com.mojang.serialization.Codec
import net.minecraft.block.BlockState
import net.minecraft.util.math.BlockPos
import net.minecraft.util.random.RandomGenerator
import net.minecraft.world.StructureWorldAccess
import net.minecraft.world.WorldAccess
import net.minecraft.world.gen.feature.VegetationPatchFeature
import net.minecraft.world.gen.feature.util.FeatureContext
import org.teamvoided.mossy_menagerie.data.MossyBlockTags
import java.util.function.Predicate
import net.minecraft.world.gen.feature.VegetationPatchFeatureConfig as VpfCfg

class MossyVegetationPatchFeature(codec: Codec<VpfCfg>) : VegetationPatchFeature(codec) {

    override fun placeGroundAndGetPositions(
        world: StructureWorldAccess, config: VpfCfg, random: RandomGenerator,
        pos: BlockPos, replaceable: Predicate<BlockState>, radiusX: Int, radiusZ: Int
    ): MutableSet<BlockPos> {
        val mPos = pos.mutableCopy()
        val mPos2 = mPos.mutableCopy()
        val dir = config.surface.direction
        val oppositeDir = dir.opposite
        val vegetationPos = hashSetOf<BlockPos>()
        for (i in -radiusX..radiusX) {
            val xEdge = i == -radiusX || i == radiusX
            for (j in -radiusZ..radiusZ) {
                val zEdge = j == -radiusZ || j == radiusZ
                val onBorder = xEdge || zEdge
                val corner = xEdge && zEdge
                val notCorner = onBorder && !corner
                if (!corner && (!notCorner || config.extraEdgeColumnChance != 0.0f && !(random.nextFloat() > config.extraEdgeColumnChance))) {
                    mPos[pos, i, 0] = j

                    var vertRange = 0
                    while (world.canPlace(mPos) && vertRange < config.verticalRange) {
                        mPos.move(dir)
                        vertRange++
                    }

                    vertRange = 0
                    while (!world.canPlace(mPos) && vertRange < config.verticalRange) {
                        mPos.move(oppositeDir)
                        vertRange++
                    }

                    mPos2.set(mPos, dir)
                    val blockState = world.getBlockState(mPos2)
                    if (world.canPlace(mPos) && blockState.isSideSolidFullSquare(world, mPos2, oppositeDir)) {
                        val depth = getDepth(config, random)
                        val blockPos = mPos2.toImmutable()
                        if (placeGround(world, config, replaceable, random, mPos2, depth)) {
                            vegetationPos.add(blockPos)
                        }
                    }
                }
            }
        }
        return vegetationPos
    }

    @Suppress("NOTHING_TO_INLINE")
    private inline fun getDepth(config: VpfCfg, random: RandomGenerator) = config.depth[random] +
            if (config.extraBottomBlockChance > 0.0f && random.nextFloat() < config.extraBottomBlockChance) 1 else 0


    override fun generateVegetation(
        context: FeatureContext<VpfCfg>, world: StructureWorldAccess, config: VpfCfg,
        random: RandomGenerator, positions: MutableSet<BlockPos>, radiusX: Int, radiusZ: Int
    ) {
        val updatedPos = positions.filter { world.isAir(it.up()) }.toMutableSet()
        super.generateVegetation(context, world, config, random, updatedPos, radiusX, radiusZ)
    }

    companion object {
        fun WorldAccess.canPlace(pos: BlockPos) =
            this.testBlockState(pos) { it.isIn(MossyBlockTags.MOSS_CAN_GROW_UNDER) }
    }
}
