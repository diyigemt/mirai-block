package net.diyigemt.miraiblock.block.operator

import net.mamoe.mirai.event.Event

class OperatorBlockEqual(
  name: String,
) : OperatorBlock<Boolean>(name) {
  override suspend fun invoke(event: Event): Boolean = when {
    args.size != 2 -> false
    else -> {
      args[0] == args[1]
    }
  }
}