package org.amshove.kluent.tests.assertions.numerical

import org.amshove.kluent.shouldBeGreaterThan
import org.jetbrains.spek.api.Spek
import kotlin.test.assertFails

class ShouldBeGreaterThanTests : Spek({
    given("the should be greater than method") {
        on("checking a greater value") {
            it("should pass") {
                5.shouldBeGreaterThan(2)
            }
        }
        on("checking an equal value") {
            it("should fail") {
                assertFails({ 5.shouldBeGreaterThan(5) })
            }
        }
        on("checking a lesser value") {
            it("should fail") {
                assertFails({ 2.shouldBeGreaterThan(5) })
            }
        }
    }
})
