package com.vasanth.apparchitecture.ui.userlist.viewmodel

import androidx.lifecycle.viewModelScope
import com.vasanth.apparchitecture.data.model.User
import com.vasanth.apparchitecture.domain.usecase.GetUserListUseCase
import com.vasanth.apparchitecture.ui.userlist.viewmodel.mapper.UserUIMapper
import com.vasanth.apparchitecture.ui.userlist.viewmodel.model.UserListUIEvent
import com.vasanth.apparchitecture.ui.userlist.viewmodel.model.UserListSideEffect
import com.vasanth.apparchitecture.ui.userlist.viewmodel.model.UserListUIState
import com.vasanth.apparchitecture.ui.userlist.viewmodel.model.UserUIModel
import com.vasanth.commoncore.domain.model.Result
import com.vasanth.commoncore.ui.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val getUserListUseCase: GetUserListUseCase,
    private val userUIMapper: UserUIMapper
) : BaseViewModel<UserListUIState, UserListUIEvent, UserListSideEffect>() {

    // Properties
    override val initialState: UserListUIState
        get() = UserListUIState.Loading

    // Initialization
    init {
        loadUsers()
    }

    private fun loadUsers() {
        viewModelScope.launch {
            val param = GetUserListUseCase.Param(page = 1)
            val result = getUserListUseCase.invoke(parameters = param)
            when (result) {
                is Result.Success -> {
                    loadUsersSuccess(users = result.data)
                }
                is Result.Error -> {
                    loadUsersFailure()
                }
            }
        }
    }

    private suspend fun loadUsersSuccess(users: List<User>) {
        val uiModels = users.map {
            userUIMapper(input = it)
        }
        _uiStateStream.update { UserListUIState.Data(users = uiModels) }
    }

    private fun loadUsersFailure() {
        _uiStateStream.update { UserListUIState.Error }
    }

    // Handle Event
    override fun handleEvent(event: UserListUIEvent) {
        when (event) {
            is UserListUIEvent.ItemClicked -> {
                onItemClicked(userUIModel = event.user)
            }
        }
    }

    private fun onItemClicked(userUIModel: UserUIModel) {
        sendSideEffect(
            UserListSideEffect.NavigateToUserDetailScreen(userID = userUIModel.id)
        )
    }
}