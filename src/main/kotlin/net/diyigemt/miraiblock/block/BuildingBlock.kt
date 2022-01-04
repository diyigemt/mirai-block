package net.diyigemt.miraiblock.block

class BuildingBlock(
  name: String,
  listener: List<Listener>,
  variables: List<Variable>?,
  functions: List<DeclaredFunction>
): Block(name)