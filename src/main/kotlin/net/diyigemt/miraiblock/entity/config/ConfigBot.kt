package net.diyigemt.miraiblock.entity.config

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ConfigBot (
  var account: Long,
  var password: ConfigBotPassword,
  var configuration: ConfigBotConfiguration
)
