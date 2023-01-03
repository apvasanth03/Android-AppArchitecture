package com.vasanth.apparchitecture.ui.userlist.viewmodel.model

sealed interface UserListUIState {

    object Loading : UserListUIState

    data class Data(
        val users: List<UserUIModel>
    ) : UserListUIState

    object Error : UserListUIState
}
