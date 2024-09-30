package org.teamvoided.mossy_menagerie.init.misc

import net.fabricmc.fabric.api.`object`.builder.v1.trade.TradeOfferHelper
import net.minecraft.village.TradeOffers
import org.teamvoided.mossy_menagerie.block.MossyBlock
import org.teamvoided.mossy_menagerie.init.MossyBlocks

object MossyTrades {
    fun init() = initWanderingTrades()
    private fun initWanderingTrades() = TradeOfferHelper.registerWanderingTraderOffers(1) { trades ->
        MossyBlocks.BLOCKS.filterIsInstance<MossyBlock>().forEach {
            trades.add(TradeOffers.SellItemFactory(it, 1, 2, 5, 1))
        }
    }
}