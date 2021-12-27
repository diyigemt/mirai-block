package net.diyigemt.miraiblock.entity.config

import com.squareup.moshi.JsonClass
import net.mamoe.mirai.utils.BotConfiguration

@JsonClass(generateAdapter = true)
data class ConfigBotConfiguration (
  var protocol: BotConfiguration.MiraiProtocol,
  var device: String,
  var network: Boolean
)
