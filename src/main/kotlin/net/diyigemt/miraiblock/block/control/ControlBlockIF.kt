package net.diyigemt.miraiblock.block.control

import net.mamoe.mirai.event.Event


class ControlBlockIF(
  name: String,
) : ControlBlock<Boolean>(name) {
  override suspend fun invoke(event: Event): Boolean = when(blocks.size) {
    in 0..1 -> false
    else -> {
      if (blocks[0].invoke(event)) {
        blocks.removeAt(0)
        blocks.forEach { it.invoke(event) }
      }
      true
    }
  }
}