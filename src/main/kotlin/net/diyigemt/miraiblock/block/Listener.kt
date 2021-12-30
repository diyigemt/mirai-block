package net.diyigemt.miraiblock.block

import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.events.BotEvent
import kotlin.reflect.KClass

class Listener (
  eventType: String,
  val variables: MutableList<Variable>,
  val sentences: MutableList<Sentence>?,
) {
  val eventType: KClass<out Event> = when (eventType) {
    "BotEvent" -> BotEvent::class
    else -> Event::class
  }
}