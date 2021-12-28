package net.diyigemt.miraiblock.block.message

import net.mamoe.mirai.event.events.MessageEvent


class MessageBlockReply(
  name: String,
) : MessageBlock<Unit>(name) {
  override suspend fun invoke(event: MessageEvent): Unit = when(blocks.size) {
    in 0..0 -> Unit
    else -> {
      event.subject.sendMessage(args[0])
      Unit
    }
  }
}