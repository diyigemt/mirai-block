package net.diyigemt.miraiblock.block

import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.events.BotEvent

abstract class Block<T: Event>(
  protected var name: String,
  protected var type: BlockType? = BlockType.NULL,
  protected var returnType: BlockReturnType? = BlockReturnType.UINT,
  protected var version: String? = "",
  protected var description: String? = "",
): BlockInvoker<Event> {
  protected val blocks: MutableList<Block<T>> = mutableListOf<Block<T>>()
  fun <E: Block<T>> addBlock(b: E) = blocks.add(b)

}

enum class BlockType {
  NULL,
  OPERATOR,
  BOT,
  MESSAGE,
  CONTROL
}

enum class BlockReturnType {
  UINT,
  ANY,
  BOOLEAN,
  LONG
}