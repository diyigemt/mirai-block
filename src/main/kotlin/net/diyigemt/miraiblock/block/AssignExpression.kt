package net.diyigemt.miraiblock.block

import net.mamoe.mirai.event.Event

class AssignExpression(
  name: String,
  val variable: Variable,
  val expression: Expression
): Expression(name) {
  override suspend fun <T : Event> invoke(event: T) {
    //TODO ¸³ÖµÅÐ¶Ï
    when(expression) {
      is Variable -> variable.setValue(expression)
      is AssignExpression -> variable.setValue(expression.variable)
      is DeclaredFunction -> variable.setValue(expression.invoke(event))
    }
  }
}