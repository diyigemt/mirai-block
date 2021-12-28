package net.diyigemt.miraiblock.block.operator

import net.diyigemt.miraiblock.block.Block
import net.diyigemt.miraiblock.block.BlockReturnType
import net.diyigemt.miraiblock.block.BlockType
import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.events.BotEvent

open class OperatorBlock(
  name: String,
  type: BlockType? = BlockType.OPERATOR,
  version: String? = "",
  description: String? = "",
  protected var subType: OperatorBlockType? = OperatorBlockType.NULL,
) : Block<Event>(
  name, type, BlockReturnType.BOOLEAN, version, description
)

enum class OperatorBlockType {
  NULL,
  EQUAL
}
