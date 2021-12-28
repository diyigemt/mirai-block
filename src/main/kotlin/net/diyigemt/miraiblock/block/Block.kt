package net.diyigemt.miraiblock.block

import net.mamoe.mirai.event.Event

abstract class Block<T: Event, E: Any>(
  protected var name: String,
  protected var type: BlockType? = BlockType.NULL,
  protected var returnType: BlockReturnType? = BlockReturnType.UINT,
  protected var version: String? = "",
  protected var description: String? = "",
): BlockInvoker<T, E> {
  protected val blocks: MutableList<Block<T, E>> = mutableListOf<Block<T, E>>()
  var args: MutableList<String> = mutableListOf()
  fun addBlock(b: Block<T, E>) = blocks.add(b)
  fun addArg(index: Int, arg: String) = args.add(index, arg)
  fun addArg(arg: String) = args.add(arg)
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