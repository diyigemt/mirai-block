package net.diyigemt.miraiblock.block

import net.mamoe.mirai.event.Event

interface BlockInvoker<T: Event, E: Any> {
  suspend fun invoke(event: T): E
}