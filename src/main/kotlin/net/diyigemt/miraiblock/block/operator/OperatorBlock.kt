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
) : Block(
  name, type, BlockReturnType.BOOLEAN, version, description
) {
  override fun <T : Event> invoke(event: T, vararg args: String): Any = when(blocks.size) {
    0 -> false
    else -> blocks[0].invoke(event, *args)
  }

}

enum class OperatorBlockType {
  NULL,
  EQUAL
}
