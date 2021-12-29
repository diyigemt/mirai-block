package net.diyigemt.miraiblock.block.control

import net.diyigemt.miraiblock.block.Block
import net.diyigemt.miraiblock.block.BlockReturnType
import net.diyigemt.miraiblock.block.BlockType
import net.mamoe.mirai.event.Event

abstract class ControlBlock<E: Any>(
  name: String,
  type: BlockType? = BlockType.CONTROL,
  version: String? = "",
  description: String? = "",
) : Block<Event, E>(
  name, type, BlockReturnType.ANY, version, description
)