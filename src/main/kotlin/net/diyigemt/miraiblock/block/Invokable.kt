package net.diyigemt.miraiblock.block

import net.mamoe.mirai.event.Event

interface Invokable {
  suspend fun <T: Event> invoke(event: T): Any
}