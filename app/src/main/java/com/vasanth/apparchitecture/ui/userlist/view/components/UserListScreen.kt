package com.vasanth.apparchitecture.ui.userlist.view.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vasanth.apparchitecture.ui.userlist.viewmodel.UserListViewModel
import com.vasanth.commoncore.ui.view.theme.AndroidAppArchitectureTheme

@Composable
fun UserListScreen() {
    val viewModel: UserListViewModel = viewModel()

    AndroidAppArchitectureTheme() {
        val state = viewModel.uiStateStream.collectAsState().value
        UserListScreenContent(
            state = state,
            handleEvent = viewModel::handleEvent
        )
    }
}