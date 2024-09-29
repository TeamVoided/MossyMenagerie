package org.teamvoided.mossy_menagerie.events

import net.fabricmc.fabric.api.`object`.builder.v1.trade.TradeOfferHelper
import net.minecraft.village.TradeOffers
import org.teamvoided.mossy_menagerie.block.MossyBlock
import org.teamvoided.mossy_menagerie.init.MossyBlocks

object AddWanderingTrades {
    fun init() = TradeOfferHelper.registerWanderingTraderOffers(1) { trades ->
        MossyBlocks.BLOCKS.filter { it is MossyBlock }.forEach {
            trades.add(TradeOffers.SellItemFactory(it, 1, 2, 5, 1))
        }
    }

}