package org.teamvoided.mossy_menagerie.block

import net.minecraft.block.Block
import net.minecraft.block.CarpetBlock

class ParentedCarpetBlock(val parent: Block, settings: Settings) : CarpetBlock(settings){
    constructor(parent: Block) : this(parent, Settings.copy(parent))
}