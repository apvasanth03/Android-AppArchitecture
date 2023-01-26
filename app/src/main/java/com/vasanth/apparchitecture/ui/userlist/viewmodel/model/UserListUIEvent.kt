package com.vasanth.apparchitecture.ui.userlist.viewmodel.model

sealed interface UserListUIEvent {

    data class ItemClicked(
        val user: UserUIModel
    ) : UserListUIEvent
}