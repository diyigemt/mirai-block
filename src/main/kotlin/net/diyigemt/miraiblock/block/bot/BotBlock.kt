package net.diyigemt.miraiblock.block.bot

import net.diyigemt.miraiblock.block.Block
import net.diyigemt.miraiblock.block.BlockReturnType
import net.diyigemt.miraiblock.block.BlockType
import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.events.BotEvent

abstract class BotBlock<E: Any>(
  name: String,
  type: BlockType? = BlockType.BOT,
  version: String? = "",
  description: String? = "",
) : Block<BotEvent, E>(
  name, type, BlockReturnType.ANY, version, description
)
