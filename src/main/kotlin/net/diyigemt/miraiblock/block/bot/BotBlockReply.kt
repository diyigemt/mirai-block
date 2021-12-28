package net.diyigemt.miraiblock.block.bot

import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.events.BotEvent

class BotBlockReply(
  name: String,
  subType: BotBlockType? = BotBlockType.REPLY
) : BotBlock(name, subType = subType) {
  override fun invoke(event: BotEvent, vararg args: String): Any = when(args.size) {
    0 -> -1
    else -> {
      val qq = args[0].toLong()
      event.bot.getFriend(qq) ?: -1
    }
  }
}