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
    //TODO ������з�֧�ĸ�ֵ����
    if (kType.isInstance(t)) value = t
    when (kType) {
      Int::class -> value = when(t::class) {
        Long::class -> (t as Long).toInt()
        Double::class -> (t as Double).toInt()
        String::class -> {
          try {
            (t as String).toInt()
          } catch (e: Exception) {
            throw TypeCastException("$name: ����ת��ʧ��,�޷���{String:${t}}��ֵ��{${kType}}")
          }
        }
        else -> throw TypeCastException("$name: ����ת��ʧ��,�޷���{${t::class}}��ֵ��{${kType}}")
      }
      else -> {
        println("��ֵ��")
      }
    }
  }
  fun setValue(t: Variable) {
    setValue(t.getValue())
  }

  override fun invoke(vararg args: Variable) = throw RuntimeException("$name: ���Ե��ñ�����invoke����!")
}