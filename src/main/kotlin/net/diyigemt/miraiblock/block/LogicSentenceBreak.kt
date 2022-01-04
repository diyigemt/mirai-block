package net.diyigemt.miraiblock.block

import net.mamoe.mirai.event.Event

class LogicSentenceBreak(
  name: String,
): LogicSentence(name) {
  override suspend fun <T : Event> invoke(event: T): Any {
    TODO("Not yet implemented")
  }
}