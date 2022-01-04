package net.diyigemt.miraiblock.block

import net.mamoe.mirai.event.Event
import kotlin.reflect.KClass

open class DeclaredFunction(
  name: String,
  type: String,
  val sentenceBlock: SentenceBlock,
  val args: List<Expression>? = null
): Factor(name), Invokable {
  private val kType: KClass<*> = when(type) {
    "Int" -> Int::class
    else -> String::class
  }
  override suspend fun <T : Event> invoke(event: T) {
    //TODO 完成函数调用逻辑
  }
}