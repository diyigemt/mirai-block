package net.diyigemt.miraiblock.block

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class LogicExpression(
  name: String,
  private val argA: Expression,
  private val argB: Expression,
  private val type: LogicType
): Expression(name) {
  private val log: Logger = LoggerFactory.getLogger("LogicExpression-$name")
  override fun invoke(vararg args: Variable): Boolean {
    //TODO 分不同的表达式进行比较
    if (argA !is LogicExpression || argB !is LogicExpression) {
      log.warn("$name: 语句错误,尝试将{${argA::class}}与{${argB::class}}进行比较")
      return false
    }
    return when(type) {
      LogicType.NOT_ABOVE -> argA.invoke(*args) <= argB.invoke(*args)
      LogicType.NOT_LESS -> argA.invoke(*args) >= argB.invoke(*args)
      LogicType.ABOVE -> argA.invoke(*args) > argB.invoke(*args)
      LogicType.LESS -> argA.invoke(*args) < argB.invoke(*args)
      LogicType.NOT_EQUAL -> argA.invoke(*args) != argB.invoke(*args)
      LogicType.EQUAL -> argA.invoke(*args) == argB.invoke(*args)
    }
  }
}

enum class LogicType {
  NOT_ABOVE,
  NOT_LESS,
  ABOVE,
  LESS,
  NOT_EQUAL,
  EQUAL
}