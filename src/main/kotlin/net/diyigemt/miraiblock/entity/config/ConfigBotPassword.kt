package net.diyigemt.miraiblock.entity.config

import com.squareup.moshi.JsonClass

data class ConfigBotPassword (
  var kind: ConfigBotPasswordEnum,
  var value: String
)
enum class ConfigBotPasswordEnum {
  PLAIN,
  MD5
}