package org.amshove.kluent.tests.assertions

import org.amshove.kluent.AnyException
import org.amshove.kluent.shouldNotThrow
import org.amshove.kluent.tests.getFailure
import org.jetbrains.spek.api.Spek
import kotlin.test.assertEquals
import kotlin.test.assertFails

class ShouldNotThrowTests : Spek({
    given("the shouldNotThrow method") {
        on("providing a function that does throw an exception") {
            it("should fail") {
                val func = { throw IllegalArgumentException() }
                assertFails({ func shouldNotThrow AnyException })
            }
        }
        on("providing a function that doesn't throw an exception") {
            it("should pass") {
                val func = { Unit }
                func shouldNotThrow AnyException
            }
        }
        on("providing a function that throws Exception A and shouldn't throw B") {
            it("should pass") {
                val func = { throw IllegalArgumentException() }
                func shouldNotThrow ArrayIndexOutOfBoundsException::class
            }
        }
        on("providing a function that throws Exception A") {
            it("should show A as expected, B as actual") {
                val actualException = IllegalArgumentException()
                val expected = Exception::class
                val actual = actualException::class
                val func = { throw actualException }
                val test = { func shouldNotThrow expected }

                val failure = getFailure(test)
                assertEquals(failure.actual, actual.toString())
                assertEquals(failure.expected, expected.toString())
            }
        }

        given("providing a function that returns null") {
            val func = { null }
            it("should not throw exception") {
                func shouldNotThrow AnyException
            }
        }
    }
})

