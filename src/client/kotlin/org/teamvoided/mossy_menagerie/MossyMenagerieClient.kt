package org.teamvoided.mossy_menagerie

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.client.render.RenderLayer
import org.teamvoided.mossy_menagerie.data.Moss

//import org.teamvoided.mossy_menagerie.MossyMenagerie.log

@Suppress("unused")
object MossyMenagerieClient {
    fun init() {
//        log.info("Hello from Client")
        Moss.ALL_MOSS
            .flatMap {
                listOf(
                    it.azalea,
                    it.floweringAzalea,
                    it.azaleaLeaves,
                    it.floweringAzaleaLeaves,
                    it.pottedAzalea,
                    it.pottedFloweringAzalea
                )
            }
            .forEach {
                BlockRenderLayerMap.INSTANCE.putBlock(it, RenderLayer.getCutout())
            }
    }
}
