package net.diyigemt.miraiblock.block.operator

import net.diyigemt.miraiblock.block.Block
import net.diyigemt.miraiblock.block.BlockReturnType
import net.diyigemt.miraiblock.block.BlockType
import net.mamoe.mirai.event.Event

abstract class OperatorBlock<E: Any>(
  name: String,
  type: BlockType? = BlockType.OPERATOR,
  version: String? = "",
  description: String? = "",
) : Block<Event, E>(
  name, type, BlockReturnType.BOOLEAN, version, description
)
