package net.diyigemt.miraiblock.block

class AssignExpression(
  name: String,
  val variable: Variable,
  val expression: Expression
): Expression(name) {
  override fun invoke(vararg args: Variable) {
    //TODO ��ֵ�ж�
    when(expression) {
      is AssignExpression ->
    }
    variable.setValue()
  }
}