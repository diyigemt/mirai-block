package net.diyigemt.miraiblock.block

interface Invokeable {
  fun invoke(vararg args: Variable): Any
}