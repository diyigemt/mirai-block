package net.diyigemt.miraiblock.block.control

import net.diyigemt.miraiblock.block.Block
import net.diyigemt.miraiblock.block.BlockReturnType
import net.diyigemt.miraiblock.block.BlockType
import net.mamoe.mirai.event.Event

open class ControlBlock(
  name: String,
  type: BlockType? = BlockType.OPERATOR,
  version: String? = "",
  description: String? = "",
  protected var subType: ControlBlockType? = ControlBlockType.NULL,
) : Block<Event>(
  name, type, BlockReturnType.ANY, version, description
)

enum class ControlBlockType {
  NULL,
  IF
}