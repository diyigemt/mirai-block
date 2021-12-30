package net.diyigemt.miraiblock.block

class BuildingBlock(
  val name: String,
  val version: String?,
  val dependent: MutableList<String>?,
  val author: MutableList<String>?,
  val functions: MutableList<SelfFunction>?,
  val variables: MutableList<Variable>?,
  val listener: MutableList<Listener>?,
) {
}