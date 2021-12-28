package net.diyigemt.miraiblock

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import net.diyigemt.miraiblock.block.Block
import net.diyigemt.miraiblock.block.control.ControlBlockIF
import net.diyigemt.miraiblock.block.listener.BotEventListener
import net.diyigemt.miraiblock.block.message.MessageBlockReply
import net.diyigemt.miraiblock.block.operator.OperatorBlockEqual
import net.diyigemt.miraiblock.entity.config.Config
import net.diyigemt.miraiblock.util.FileUtil
import net.mamoe.mirai.BotFactory
import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.ListeningStatus

@OptIn(ExperimentalStdlibApi::class)
fun main() {
  val configJson: String = FileUtil.getConfigFile().readText()
  val moshi = Moshi.Builder().build()
  val jsonAdapter = moshi.adapter<Config>()
  val config = jsonAdapter.fromJson(configJson) ?: return

  val reply = MessageBlockReply("reply-1")
  reply.addArg("复读测试")
  val equalBlock = OperatorBlockEqual("eq-1")
  equalBlock.addArg("复读")
  val ifBlock = ControlBlockIF("if-1")
  ifBlock.addBlock(equalBlock)
  ifBlock.addBlock(reply as Block<Event, Boolean>)
  val botEventListener = BotEventListener("bot-event-listener-1", "MessageEvent")


  for (bot in config.bots) {
    val newBot = BotFactory.newBot(bot.account, bot.password.value) {
      val device = bot.configuration.device
      val account = bot.account
      this.fileBasedDeviceInfo(FileUtil.getBotDeviceFilePath(account, device))
      this.protocol = bot.configuration.protocol
      if (!bot.configuration.network) this.noNetworkLog()
    }
    runBlocking {
      launch {
        newBot.login()
        newBot.eventChannel.subscribe(botEventListener.event) {
          botEventListener.invoke(this)
          ListeningStatus.LISTENING
        }
      }
    }
  }
}