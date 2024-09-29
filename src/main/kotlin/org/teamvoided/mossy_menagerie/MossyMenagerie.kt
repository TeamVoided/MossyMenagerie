package org.teamvoided.mossy_menagerie

import net.minecraft.util.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.teamvoided.mossy_menagerie.init.MossyBlocks
import org.teamvoided.mossy_menagerie.init.MossyItems
import org.teamvoided.mossy_menagerie.init.MossyTabs

@Suppress("unused")
object MossyMenagerie {
    const val MODID = "mossy_menagerie"

    @JvmField
    val log: Logger = LoggerFactory.getLogger(MossyMenagerie::class.simpleName)

    fun init() {
        log.info("Time for moss~")
        MossyItems.init()
        MossyBlocks.init()
        MossyTabs.init()
    }

    fun id(path: String): Identifier = Identifier.of(MODID, path)
}
