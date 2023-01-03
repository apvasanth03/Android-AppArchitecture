package com.vasanth.apparchitecture.ui.userlist.view.components.sampledata

import com.vasanth.apparchitecture.ui.userlist.viewmodel.model.UserListUIState
import com.vasanth.apparchitecture.ui.userlist.viewmodel.model.UserUIModel

object UserListSampleData {

    fun createUserUIModel(id: Long): UserUIModel {
        val user = UserUIModel(
            id = id,
            name = "Vasanth",
            email = "test@email.com",
            avatar = "https://picsum.photos/200/300"
        )
        return user
    }

    fun createUserUIModels(): List<UserUIModel> {
        val users = List(5) { index ->
            createUserUIModel(id = index.toLong())
        }
        return users
    }

    fun createDataUIState(): UserListUIState.Data {
        val state = UserListUIState.Data(
            users = createUserUIModels()
        )

        return state
    }
}