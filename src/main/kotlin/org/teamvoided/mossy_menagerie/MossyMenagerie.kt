package org.teamvoided.mossy_menagerie

import net.minecraft.util.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Suppress("unused")
object MossyMenagerie {
    const val MODID = "mossy_menagerie"

    @JvmField
    val log: Logger = LoggerFactory.getLogger(MossyMenagerie::class.simpleName)

    fun init() {
        log.info("Time for moss~")
    }

    fun id(path: String): Identifier = Identifier.of(MODID, path)
}
