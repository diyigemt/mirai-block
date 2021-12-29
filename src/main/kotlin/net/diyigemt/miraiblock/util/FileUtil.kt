package net.diyigemt.miraiblock.util

import net.diyigemt.miraiblock.constant.CONFIG_FOLDER_NAME
import net.diyigemt.miraiblock.constant.PATH_SEPARATOR
import net.diyigemt.miraiblock.constant.CONFIG_FILE_BOT_FIELD_NAME
import net.diyigemt.miraiblock.constant.CONFIG_FILE_NAME
import java.io.File
import kotlin.io.path.Path

class FileUtil {
  companion object {
    private val ROOT_PATH: String = Path("").toAbsolutePath().toString()
    private val CONFIG_ROOT_FOLDER_PATH = "$ROOT_PATH$PATH_SEPARATOR$CONFIG_FOLDER_NAME"
    private val BOT_DEVICE_FOLDER_PATH = "$CONFIG_ROOT_FOLDER_PATH$PATH_SEPARATOR$CONFIG_FILE_BOT_FIELD_NAME"
    init {
      File(CONFIG_ROOT_FOLDER_PATH).mkdirs()
      File(BOT_DEVICE_FOLDER_PATH).mkdirs()
    }
    fun getConfigFile(): File = File(CONFIG_ROOT_FOLDER_PATH + PATH_SEPARATOR + CONFIG_FILE_NAME)
    fun getBotDeviceFilePath(account: Long, deviceFileName: String): String {
      val s = "$BOT_DEVICE_FOLDER_PATH$PATH_SEPARATOR$account"
      val botDeviceFile = File(s)
      if (!botDeviceFile.exists()) botDeviceFile.mkdir()
      return "$s$PATH_SEPARATOR$deviceFileName"
    }
  }
}