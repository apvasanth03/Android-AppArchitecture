package com.vasanth.apparchitecture.ui.userlist.viewmodel.model

sealed interface UserListEvent {

    data class ItemClicked(
        val user: UserUIModel
    ) : UserListEvent
}