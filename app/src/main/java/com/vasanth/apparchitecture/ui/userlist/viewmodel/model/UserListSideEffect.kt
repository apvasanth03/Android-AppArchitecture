package com.vasanth.apparchitecture.ui.userlist.viewmodel.model

sealed interface UserListSideEffect {

    data class NavigateToUserDetailScreen(
        val userID: Long
    ) : UserListSideEffect
}