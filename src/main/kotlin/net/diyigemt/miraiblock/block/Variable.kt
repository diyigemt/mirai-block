package net.diyigemt.miraiblock.block

import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.events.BotEvent
import kotlin.reflect.KClass

class Variable(
  valueType: String,
  var value: Any,
) {
  val valueType: KClass<out Event> = when (valueType) {
    "BotEvent" -> BotEvent::class
    else -> Event::class
  }
}