package org.teamvoided.mossy_menagerie.utils

import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemConvertible
import net.minecraft.registry.Holder
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.tag.TagKey
import net.minecraft.text.MutableText
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import org.apache.commons.lang3.text.WordUtils
import org.teamvoided.mossy_menagerie.MossyMenagerie.id

fun <T, R : Registry<T>> RegistryKey<R>.tag(id: Identifier): TagKey<T> = TagKey.of(this, id)
fun <T, R : Registry<T>> RegistryKey<R>.key(id: Identifier): RegistryKey<T> = RegistryKey.of(this, id)

fun <T> Registry<T>.register(id: String, entry: T): T = Registry.register(this, id(id), entry)
fun <T> Registry<T>.registerHolder(id: String, entry: T): Holder<T> = Registry.registerHolder(this, id(id), entry)
fun <T> Registry<T>.register(id: Identifier, entry: T): T = Registry.register(this, id, entry)
fun <T> Registry<T>.registerHolder(id: Identifier, entry: T): Holder<T> = Registry.registerHolder(this, id, entry)


fun Item.toId() = Registries.ITEM.getId(this)
val Item.id get() = this.toId()

fun Block.toId() = Registries.BLOCK.getId(this)
val Block.id get() = this.toId()

fun ItemConvertible.toId() = this.asItem().toId()
val ItemConvertible.id get() = this.toId()


fun Item() = Item(Item.Settings())
fun BlockItem(block: Block) = BlockItem(block, Item.Settings())

fun <T : Any> MutableCollection<T>.addAndGet(entry: T): T {
    this.add(entry)
    return entry
}

fun Identifier.lang(): String = WordUtils.capitalize(this.path.replace("_", " ").replace("/", " "))

fun String.text(): MutableText = Text.translatable(this)
