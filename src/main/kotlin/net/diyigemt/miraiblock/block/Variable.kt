package net.diyigemt.miraiblock.block

import java.lang.Exception
import kotlin.reflect.KClass
import kotlin.reflect.cast

class Variable(
  name: String,
  type: String,
  private var value: Any
): Factor(name) {
  private val kType: KClass<*> = when(type) {
    "Int" -> Int::class
    else -> String::class
  }
  fun getValue() = kType.cast(value)
  fun setValue(t: Any) {
    //TODO 完成所有分支的赋值方法
    if (kType.isInstance(t)) value = t
    when (kType) {
      Int::class -> value = when(t::class) {
        Long::class -> (t as Long).toInt()
        Double::class -> (t as Double).toInt()
        String::class -> {
          try {
            (t as String).toInt()
          } catch (e: Exception) {
            throw TypeCastException("$name: 类型转换失败,无法将{String:${t}}赋值给{${kType}}")
          }
        }
        else -> throw TypeCastException("$name: 类型转换失败,无法将{${t::class}}赋值给{${kType}}")
      }
      else -> {
        println("赋值中")
      }
    }
  }
  fun setValue(t: Variable) {
    setValue(t.getValue())
  }

  override fun invoke(vararg args: Variable) = throw RuntimeException("$name: 尝试调用变量的invoke函数!")
}