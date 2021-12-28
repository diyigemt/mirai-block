package net.diyigemt.miraiblock.block.bot

import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.events.BotEvent

class BotBlockReply(
  name: String,
  subType: BotBlockType? = BotBlockType.REPLY
) : BotBlock(name, subType = subType) {
  override fun <T : Event> invoke(event: T, vararg args: String) = when(args.size) {
    0 -> -1
    else -> when (event) {
      is BotEvent -> {
        val qq = args[0].toLong()
        event.bot.getFriend(qq)
      }
      else -> 1L
    }
  }
}