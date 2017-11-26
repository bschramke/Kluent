package org.amshove.kluent.tests.assertions

import org.amshove.kluent.shouldBeIn
import org.amshove.kluent.tests.helpclasses.Person
import org.jetbrains.spek.api.Spek
import kotlin.test.assertFails

class ShouldBeInTests : Spek({
    given("the shouldBeIn method") {
        on("checking object in Array") {
            val person = Person("Jon", "Doe")
            val array = arrayOf(Person("Jon", "Doe"), Person("Foo", "Bar"))
            it("should pass") {
                person shouldBeIn array
            }
        }
        on("checking object not in Array") {
            val person = Person("Jon", "Doe")
            val array = arrayOf(Person("Foo", "Bar"), Person("Foo", "Bar"))
            it("should fail") {
                assertFails { person shouldBeIn array }
            }
        }
        on("checking object in Iterable") {
            val person = Person("Jon", "Doe")
            val iterable = listOf(Person("Jon", "Doe"), Person("Foo", "Bar"))
            it("should pass") {
                person shouldBeIn iterable
            }
        }
        on("checking object not in Iterable") {
            val person = Person("Jon", "Doe")
            val array = listOf(Person("Foo", "Bar"), Person("Foo", "Bar"))
            it("should fail") {
                assertFails { person shouldBeIn array }
            }
        }
    }
})
