package net.diyigemt.miraiblock.block

import net.mamoe.mirai.event.Event

class LogicSentenceReturn(
  name: String,
  arg: Expression
): LogicSentence(name) {
  override suspend fun <T : Event> invoke(event: T): Any {
    TODO("Not yet implemented")
  }
}