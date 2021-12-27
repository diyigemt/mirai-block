package net.diyigemt.miraiblock

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import net.diyigemt.miraiblock.entity.config.Config
import net.diyigemt.miraiblock.util.FileUtil
import net.mamoe.mirai.BotFactory

@OptIn(ExperimentalStdlibApi::class)
fun main() {
  val configJson: String = FileUtil.getConfigFile().readText()
  val moshi = Moshi.Builder().build()
  val jsonAdapter = moshi.adapter<Config>()
  val config = jsonAdapter.fromJson(configJson) ?: return
  for (bot in config.bots) {
    val newBot = BotFactory.newBot(bot.account, bot.password.value) {
      val device = bot.configuration.device
      val account = bot.account
      this.fileBasedDeviceInfo(FileUtil.getBotDeviceFilePath(account, device))
      this.protocol = bot.configuration.protocol
      if (!bot.configuration.network) this.noNetworkLog()
    }
    runBlocking {
      launch { newBot.login() }
    }
  }
}