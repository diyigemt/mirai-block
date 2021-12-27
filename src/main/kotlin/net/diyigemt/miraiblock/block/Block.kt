package net.diyigemt.miraiblock.block

open class Block(
  protected var name: String,
  protected var type: BlockType? = BlockType.NULL,
  protected var returnType: BlockReturnType? = BlockReturnType.UINT,
  protected var version: String? = "",
  protected var description: String? = "",
)

enum class BlockType {
  NULL,
  OPERATOR,
  BOT,
  MESSAGE,
  CONTROL
}

enum class BlockReturnType {
  UINT,
  BOOLEAN
}