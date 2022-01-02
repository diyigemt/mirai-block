package net.diyigemt.miraiblock.block

open class LogicExpressionA(
  name: String
) : Expression(name) {
  private var argA: LogicExpressionA? = null
  private var argB: LogicExpressionB? = null

  constructor(
    name: String,
    argA: LogicExpressionA,
    argB: LogicExpressionB
  ) : this(name) {
    this.argA = argA
    this.argB = argB
  }

  override fun invoke(vararg args: Variable): Boolean {
    //TODO ø’ ±Ã· æ
    if (argA != null && argB != null) {
      return argA!!.invoke(*args) || argB!!.invoke(*args)
    } else {
      return false
    }
  }
}