package net.diyigemt.miraiblock.block

import net.mamoe.mirai.event.Event

sealed interface BlockInvoker<in T: Event, out E: Any> {
  fun invoke(event: T, vararg args: String): E
}