package net.diyigemt.miraiblock.block

import net.mamoe.mirai.event.Event

class LogicSentenceWhile(
  name: String,
  arg: List<Expression>,
  sentenceBlock: SentenceBlock
): LogicSentence(name) {
  override suspend fun <T : Event> invoke(event: T): Any {
    TODO("Not yet implemented")
  }
}