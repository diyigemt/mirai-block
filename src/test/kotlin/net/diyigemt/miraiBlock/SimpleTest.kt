package net.diyigemt.miraiBlock

import net.diyigemt.miraiblock.block.Variable
import org.junit.jupiter.api.Test
import kotlin.reflect.full.isSuperclassOf

class SimpleTest {
  @Test
  fun testCast() {
    val a: B = B(1)
    val b: C = C(1)
    println(A::class.isSuperclassOf(B::class))
    println(Int::class.isInstance(1))
  }

  @Test
  fun testVariable() {
    val variable = Variable("black", "Int", 1)
    variable.setValue(A(1))
    println(variable.getValue())
  }
}

open class A(val init: Int)
class B(init: Int): A(init)
class C(init: Int): A(init)