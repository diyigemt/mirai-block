package net.diyigemt.miraiblock.block.listener

import net.diyigemt.miraiblock.block.Block
import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.events.BotEvent
import kotlin.reflect.KClass

open class ListenerBlock<T: Event>(
  name: String,
  event: String,
  ) : Block<T, Any>(name) {
  open val event: KClass<out Event> by lazy {
    when (event) {
      "BotEvent" -> BotEvent::class
      else -> Event::class
    }
  }
  override suspend fun invoke(event: T): Any = when (blocks.size) {
    0 -> Unit
    else -> {
      blocks.forEach { it.invoke(event) }
    }
  }
}