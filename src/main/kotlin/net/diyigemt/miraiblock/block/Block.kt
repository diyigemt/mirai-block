package net.diyigemt.miraiblock.block

import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.events.BotEvent

abstract class Block<T: Event, E: Any>(
  protected var name: String,
  protected var type: BlockType? = BlockType.NULL,
  protected var returnType: BlockReturnType? = BlockReturnType.UINT,
  protected var version: String? = "",
  protected var description: String? = "",
): BlockInvoker<T, E> {
  protected val blocks: MutableList<Block<T, E>> = mutableListOf<Block<T, E>>()
  fun <U: Block<T, E>> addBlock(b: U) = blocks.add(b)
  override fun invoke(event: T, vararg args: String): E = when (blocks.size) {
    0 -> -1
    else -> {
      blocks.forEach { it.invoke(event, *args) }
      0
    }
  }
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