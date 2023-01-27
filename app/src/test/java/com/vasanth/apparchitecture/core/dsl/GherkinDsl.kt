package com.vasanth.apparchitecture.core.dsl

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@DslMarker
annotation class GherkinDsl

@GherkinDsl
object Gherkin

@GherkinDsl
object GherkinClass

@GherkinDsl
@OptIn(ExperimentalContracts::class)
fun gherkin(test: Gherkin.() -> Unit) {
    contract {
        callsInPlace(test, InvocationKind.EXACTLY_ONCE)
    }

    Gherkin.test()
}

@GherkinDsl
@OptIn(ExperimentalContracts::class)
@Suppress("FunctionName", "unused")
inline fun Gherkin.Given(description: String, block: GherkinClass.() -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    require(description.isNotBlank()) {
        "'Given' description should not be blank - a meaningful description should be provided."
    }

    GherkinClass.block()
}

@GherkinDsl
@OptIn(ExperimentalContracts::class)
@Suppress("FunctionName", "unused")
inline fun Gherkin.When(description: String, block: GherkinClass.() -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    require(description.isNotBlank()) {
        "'When' description should not be blank - a meaningful description should be provided."
    }

    GherkinClass.block()
}

@GherkinDsl
@OptIn(ExperimentalContracts::class)
@Suppress("FunctionName", "unused")
inline fun Gherkin.Then(description: String, block: GherkinClass.() -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    require(description.isNotBlank()) {
        "'Then' description should not be blank - a meaningful description should be provided."
    }

    GherkinClass.block()
}

@GherkinDsl
@OptIn(ExperimentalContracts::class)
@Suppress("FunctionName", "unused")
inline fun Gherkin.And(description: String, block: GherkinClass.() -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    require(description.isNotBlank()) {
        "'And' description should not be blank - a meaningful description should be provided."
    }

    GherkinClass.block()
}

