package net.diyigemt.miraiblock.block.bot

import net.diyigemt.miraiblock.block.Block
import net.diyigemt.miraiblock.block.BlockReturnType
import net.diyigemt.miraiblock.block.BlockType
import net.mamoe.mirai.event.Event

open class BotBlock(
  name: String,
  type: BlockType? = BlockType.OPERATOR,
  version: String? = "",
  description: String? = "",
  protected var subType: BotBlockType? = BotBlockType.NULL,
) : Block(
  name, type, BlockReturnType.ANY, version, description
) {
  override fun <T : Event> invoke(event: T, vararg args: String) = when(blocks.size) {
    0 -> false
    else -> blocks[0].invoke(event, *args)
  }
}

enum class BotBlockType {
  NULL,
  REPLY
}