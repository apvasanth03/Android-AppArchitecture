package com.vasanth.apparchitecture.testfixture.common

import io.kotest.property.Arb
import io.kotest.property.arbitrary.*


object BasicTypeFixture {

    fun generateInt(): Int {
        val arb = Arb.int()
        return arb.next()
    }

    fun generateLong(): Long {
        val arb = Arb.long()
        return arb.next()
    }

    fun generateBoolean(): Boolean {
        val arb = Arb.boolean()
        return arb.next()
    }

    fun generateDouble(): Double {
        val arb = Arb.double()
        return arb.next()
    }

    fun generateFloat(): Float {
        val arb = Arb.float()
        return arb.next()
    }

    fun generateString(): String {
        val arb = Arb.string()
        return arb.next()
    }
}