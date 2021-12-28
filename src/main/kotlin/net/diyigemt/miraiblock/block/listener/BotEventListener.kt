package net.diyigemt.miraiblock.block.listener

import net.mamoe.mirai.event.events.BotEvent
import net.mamoe.mirai.event.events.MessageEvent
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
class BotEventListener(
  name: String,
  event: String) : ListenerBlock<BotEvent>(name, event) {
  override val event: KClass<out BotEvent> by lazy {
    when (event) {
      "BotEvent" -> BotEvent::class
      "MessageEvent" -> MessageEvent::class
      else -> BotEvent::class
    }
  }
}