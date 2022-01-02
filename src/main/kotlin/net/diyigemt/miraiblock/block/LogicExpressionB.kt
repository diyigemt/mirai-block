package net.diyigemt.miraiblock.block

open class LogicExpressionB(
  name: String
) : Expression(name) {
  private var argA: LogicExpressionB? = null
  private var argB: SimpleExpression? = null
  constructor(
    name: String,
    argA: LogicExpressionB,
    argB: SimpleExpression
  ) : this(name) {
    this.argA = argA
    this.argB = argB
  }
  override fun invoke(vararg args: Variable): Boolean {
    //TODO ø’ ±Ã· æ
    if (argA != null && argB != null) {
      return argA!!.invoke(*args) && argB!!.invoke(*args)
    } else {
      return false
    }
  }
}