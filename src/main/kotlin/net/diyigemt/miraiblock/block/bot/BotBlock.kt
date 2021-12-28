package net.diyigemt.miraiblock.block.bot

import net.diyigemt.miraiblock.block.Block
import net.diyigemt.miraiblock.block.BlockReturnType
import net.diyigemt.miraiblock.block.BlockType
import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.events.BotEvent

open class BotBlock(
  name: String,
  type: BlockType? = BlockType.OPERATOR,
  version: String? = "",
  description: String? = "",
  protected var subType: BotBlockType? = BotBlockType.NULL,
) : Block<BotEvent>(
  name, type, BlockReturnType.ANY, version, description
)

enum class BotBlockType {
  NULL,
  REPLY
}