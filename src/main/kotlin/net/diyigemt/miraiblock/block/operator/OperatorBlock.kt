package net.diyigemt.miraiblock.block.operator

import net.diyigemt.miraiblock.block.Block
import net.diyigemt.miraiblock.block.BlockType

abstract class OperatorBlock(
  name: String,
  type: BlockType? = BlockType.OPERATOR,
  version: String? = "",
  description: String? = "",
  protected var subType: OperatorBlockType? = OperatorBlockType.NULL,
  ) : Block(
  name, type, version = version, description = description
) {
  abstract fun invoke(vararg args: String): Any
}

enum class OperatorBlockType {
  NULL,
  EQUAL
}
