package net.diyigemt.miraiblock.block

import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.events.MessageEvent
import kotlin.reflect.KClass

class Listener(
  name: String,
  type: String,
  private val sentenceBlock: SentenceBlock
): Block(name) {
  val kType: KClass<out Event> = when(type) {
    "MessageEvent" -> MessageEvent::class
    else -> Event::class
  }

  suspend fun <T: Event> action(event: T) {
    sentenceBlock.invoke(event)
  }
}