package net.diyigemt.miraiblock.block

class SentenceBlock(
  name: String,
  val dec: List<Variable>?,
  val sentences: List<Sentence>?
): Sentence(name), Invokeable {
  override fun invoke(vararg args: Variable) {
    if (sentences.isNullOrEmpty()) return
    sentences.forEach {
      it.invoke(*args)
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