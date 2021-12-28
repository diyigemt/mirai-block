package net.diyigemt.miraiblock.block.operator

import net.mamoe.mirai.event.Event

class OperatorBlockEqual(
  name: String,
  subType: OperatorBlockType? = OperatorBlockType.EQUAL,
) : OperatorBlock(name, subType = subType) {
  override fun invoke(event: Event, vararg args: String): Any = when {
    args.size != 2 -> false
    else -> {
      args[0] == args[1]
    }
  }
}