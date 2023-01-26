package com.vasanth.apparchitecture.testfixture.ui

import com.vasanth.apparchitecture.ui.userlist.viewmodel.model.UserUIModel
import io.kotest.property.Arb
import io.kotest.property.arbitrary.bind
import io.kotest.property.arbitrary.next

object UserUIModelFixture {

    fun generateUserUIModel(): UserUIModel {
        val arb = Arb.bind<UserUIModel>()
        return arb.next()
    }
}