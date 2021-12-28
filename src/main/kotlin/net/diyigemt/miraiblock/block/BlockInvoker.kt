package net.diyigemt.miraiblock.block

import net.mamoe.mirai.event.Event

sealed interface BlockInvoker<T: Event> {
  fun invoke(event: T, vararg args: String): Any
}