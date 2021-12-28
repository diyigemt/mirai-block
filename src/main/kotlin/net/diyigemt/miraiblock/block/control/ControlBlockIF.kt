package net.diyigemt.miraiblock.block.control

import net.mamoe.mirai.event.Event


class ControlBlockIF(
  name: String,
  subType: ControlBlockType? = ControlBlockType.IF
) : ControlBlock(name, subType = subType) {
  override fun invoke(event: Event, vararg args: String): Any = when {
    blocks.size < 2 -> false
    else -> {
      blocks[0].invoke(event, *args)
    }
  }
}