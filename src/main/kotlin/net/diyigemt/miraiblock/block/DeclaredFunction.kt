package net.diyigemt.miraiblock.block

import kotlin.reflect.KClass

class DeclaredFunction(
  name: String,
  type: String,
  val sentenceBlock: SentenceBlock
): Block(name), Invokeable {
  private val kType: KClass<*> = when(type) {
    "Int" -> Int::class
    else -> String::class
  }
  override fun invoke(vararg args: Variable) {
    //TODO 完成函数调用逻辑
  }
}