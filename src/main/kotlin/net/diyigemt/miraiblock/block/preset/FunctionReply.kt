package net.diyigemt.miraiblock.block.preset

import net.diyigemt.miraiblock.block.DeclaredFunction
import net.diyigemt.miraiblock.block.SentenceBlock
import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.events.MessageEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class FunctionReply(
  name: String,
  val arg: String,
): DeclaredFunction(name, "UInt", SentenceBlock("${name}sentence")) {
  private val logger: Logger = LoggerFactory.getLogger(FunctionReply::class.java)
  override suspend fun <T : Event> invoke(event: T) {
    when(event) {
      is MessageEvent -> {
        event.subject.sendMessage(arg)
      }
      else -> {
        logger.warn("${name}尝试使用非MessageEvent进行快速消息回复!")
      }
    }
  }
}