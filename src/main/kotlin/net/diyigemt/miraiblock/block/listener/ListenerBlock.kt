package net.diyigemt.miraiblock.block.listener

import net.diyigemt.miraiblock.block.Block
import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.events.BotEvent
import kotlin.reflect.KClass

open class ListenerBlock<T>(
  name: String,
  event: String,
  ) : Block(name) {
  open val event: KClass<out Event> by lazy {
    when (event) {
      "BotEvent" -> BotEvent::class
      else -> Event::class
    }
  }
  override fun invoke(event: T, vararg args: String): Any = when (blocks.size) {
    0 -> -1
    else -> {
      blocks.forEach { it.invoke(event, *args) }
      0
    }
  }

}