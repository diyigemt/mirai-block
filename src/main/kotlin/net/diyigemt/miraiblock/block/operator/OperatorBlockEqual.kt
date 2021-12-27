package net.diyigemt.miraiblock.block.operator

class OperatorBlockEqual(
  name: String,
  subType: OperatorBlockType? = OperatorBlockType.EQUAL,
) : OperatorBlock(name, subType = subType) {
  override fun invoke(vararg args: String) = when {
    args.size != 2 -> false
    args[0] == args[1] -> true
    else -> false
  }
}