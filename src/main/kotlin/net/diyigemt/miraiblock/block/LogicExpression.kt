package net.diyigemt.miraiblock.block

import net.mamoe.mirai.event.Event
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class LogicExpression(
  name: String,
  private val argA: Expression,
  private val argB: Expression,
  private val type: LogicType
): Expression(name) {
  private val log: Logger = LoggerFactory.getLogger("LogicExpression-$name")
  override suspend fun <T : Event> invoke(event: T): Boolean {
    //TODO �ֲ�ͬ�ı��ʽ���бȽ�
    if (argA !is LogicExpression || argB !is LogicExpression) {
      log.warn("$name: ������,���Խ�{${argA::class}}��{${argB::class}}���бȽ�")
      return false
    }
    return when(type) {
      LogicType.NOT_ABOVE -> argA.invoke(event) <= argB.invoke(event)
      LogicType.NOT_LESS -> argA.invoke(event) >= argB.invoke(event)
      LogicType.ABOVE -> argA.invoke(event) > argB.invoke(event)
      LogicType.LESS -> argA.invoke(event) < argB.invoke(event)
      LogicType.NOT_EQUAL -> argA.invoke(event) != argB.invoke(event)
      LogicType.EQUAL -> argA.invoke(event) == argB.invoke(event)
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