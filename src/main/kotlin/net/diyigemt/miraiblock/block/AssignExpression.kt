package net.diyigemt.miraiblock.block

class AssignExpression(
  name: String,
  val variable: Variable,
  val expression: Expression
): Expression(name) {
  override fun invoke(vararg args: Variable) {
    //TODO ¸³ÖµÅÐ¶Ï
    when(expression) {
      is Variable -> variable.setValue(expression)
      is AssignExpression -> variable.setValue(expression.variable)
      is DeclaredFunction -> variable.setValue(expression.invoke(*args))
    }
  }
}