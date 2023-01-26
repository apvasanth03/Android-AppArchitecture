package com.vasanth.apparchitecture.testfixture.data.remote

import com.vasanth.apparchitecture.data.datasource.remote.model.UserApiModel
import io.kotest.property.Arb
import io.kotest.property.arbitrary.bind
import io.kotest.property.arbitrary.next

object UserApiModelFixture {

    fun generateUserApiModel(): UserApiModel {
        val arb = Arb.bind<UserApiModel>()
        return arb.next()
    }
}