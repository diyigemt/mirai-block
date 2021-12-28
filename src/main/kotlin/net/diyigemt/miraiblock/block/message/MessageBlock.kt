package net.diyigemt.miraiblock.block.message

import net.diyigemt.miraiblock.block.Block
import net.diyigemt.miraiblock.block.BlockReturnType
import net.diyigemt.miraiblock.block.BlockType
import net.mamoe.mirai.event.events.MessageEvent

abstract class MessageBlock<E: Any>(
  name: String,
  type: BlockType? = BlockType.MESSAGE,
  version: String? = "",
  description: String? = "",
) : Block<MessageEvent, E>(
  name, type, BlockReturnType.ANY, version, description
)
