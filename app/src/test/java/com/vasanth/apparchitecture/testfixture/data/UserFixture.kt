package com.vasanth.apparchitecture.testfixture.data

import com.vasanth.apparchitecture.data.model.User
import io.kotest.property.Arb
import io.kotest.property.arbitrary.bind
import io.kotest.property.arbitrary.next

object UserFixture {

    fun generateUser(): User {
        val arb = Arb.bind<User>()
        return arb.next()
    }

    fun generateUsers(): List<User> {
        val arb = Arb.bind<List<User>>()
        return arb.next()
    }
}