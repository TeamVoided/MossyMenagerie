package org.teamvoided.mossy_menagerie.init.misc

import net.fabricmc.fabric.api.loot.v3.LootTableEvents
import net.minecraft.loot.LootPool
import net.minecraft.loot.LootTables
import net.minecraft.loot.condition.RandomChanceLootCondition
import net.minecraft.loot.entry.ItemEntry
import org.teamvoided.mossy_menagerie.init.MossyBlocks

object MossyLootModifiers {
    private val LOOT_TABLES = setOf(
        LootTables.BURIED_TREASURE_CHEST,
        LootTables.BASTION_TREASURE_CHEST,
        LootTables.FISHING_TREASURE_GAMEPLAY,
        LootTables.SHIPWRECK_TREASURE_CHEST
    )
    fun init() = LootTableEvents.MODIFY.register { table, builder, _, _ ->
        if (LOOT_TABLES.contains(table)) {
            builder.pool(
                LootPool.builder().with(
                    ItemEntry.builder(MossyBlocks.RICH_MOSS)
                        .conditionally(RandomChanceLootCondition.method_932(0.75f))
                )
            )
        }
    }
}