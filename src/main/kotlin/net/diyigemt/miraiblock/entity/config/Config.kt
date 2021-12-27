package net.diyigemt.miraiblock.entity.config

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Config (
  var bots: List<ConfigBot>
)
