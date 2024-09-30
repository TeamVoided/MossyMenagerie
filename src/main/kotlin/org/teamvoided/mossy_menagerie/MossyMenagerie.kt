package org.teamvoided.mossy_menagerie

import net.minecraft.util.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.teamvoided.mossy_menagerie.init.*
import org.teamvoided.mossy_menagerie.init.misc.MossyBiomeModifiers
import org.teamvoided.mossy_menagerie.init.misc.MossyLootModifiers
import org.teamvoided.mossy_menagerie.init.misc.MossyTrades

@Suppress("unused")
object MossyMenagerie {
    const val MODID = "mossy_menagerie"

    @JvmField
    val log: Logger = LoggerFactory.getLogger(MossyMenagerie::class.simpleName)

    fun init() {
        log.info("Time for moss~")
        MossyItems.init()
        MossyBlocks.init()
        MossyFeatures.init()
        MossyBiomeModifiers.init()
        MossyLootModifiers.init()
        MossyTabs.init()
        MossyTrades.init()
    }

    fun id(path: String): Identifier = Identifier.of(MODID, path)
    fun id(ns: String, path: String): Identifier = Identifier.of(ns, path)
}
