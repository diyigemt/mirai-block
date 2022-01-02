package net.diyigemt.miraiblock.block

class BlockDeclaration(
  name: String,
  val version: String?,
  val author: List<String>,
  val dependent: List<String>?,
  val variables: List<Variable>?,
  val functions: List<DeclaredFunction>?,
  val listeners: List<Listener>?
): Block(name)