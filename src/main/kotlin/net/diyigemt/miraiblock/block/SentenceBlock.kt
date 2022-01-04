package net.diyigemt.miraiblock.block

import net.mamoe.mirai.event.Event

class SentenceBlock(
  name: String,
  val dec: List<Variable>? = null,
  val sentences: List<Sentence>? = null
): Sentence(name), Invokable {
  override suspend fun <T : Event> invoke(event: T) {
    if (sentences.isNullOrEmpty()) return
    sentences.forEach {
      it.invoke(event)
    }
    when(val last = sentences.last()) {
      is Expression -> {
        when(last) {
          is AssignExpression -> Unit
        }
      }
    }
  }
}