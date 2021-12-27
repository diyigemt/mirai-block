package net.diyigemt.miraiblock.block.listener

import net.diyigemt.miraiblock.block.Block
import net.mamoe.mirai.event.events.BotEvent

class Listener<T: BotEvent>(
  name: String,
  event: String,
  ) : Block(name) {
  val event: T
  init {
    this.event =
  }
}