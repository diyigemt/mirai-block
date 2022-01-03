package net.diyigemt.miraiblock.block

class LogicSentenceIF(
  name: String,
  arg: List<Expression>,
  sentenceBlock: SentenceBlock
): LogicSentence(name) {
  override fun invoke(vararg args: Variable): UInt {
    TODO("Not yet implemented")
  }
}