package net.diyigemt.miraiblock.block

import net.mamoe.mirai.event.Event

class LogicSentenceIF(
  name: String,
  private val arg: Expression,
  private val sentenceBlock: SentenceBlock
): LogicSentence(name) {
  override suspend fun <T : Event> invoke(event: T) {
    val result: Boolean = when(arg) {
      is AssignExpression -> {
        arg.invoke(event)
        arg.variable.getValue() as Boolean
      }
      else -> false
    }
    if (result) {
      sentenceBlock.invoke(event)
    }
  }
}