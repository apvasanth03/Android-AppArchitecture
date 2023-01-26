package com.vasanth.apparchitecture.ui.userlist.view.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vasanth.apparchitecture.ui.userlist.view.components.data.UserListData
import com.vasanth.apparchitecture.ui.userlist.view.components.error.UserListError
import com.vasanth.apparchitecture.ui.userlist.view.components.loading.UserListLoading
import com.vasanth.apparchitecture.ui.userlist.view.components.sampledata.UserListSampleData
import com.vasanth.apparchitecture.ui.userlist.viewmodel.model.UserListUIEvent
import com.vasanth.apparchitecture.ui.userlist.viewmodel.model.UserListUIState
import com.vasanth.commoncore.ui.view.theme.AndroidAppArchitectureTheme

@Composable
fun UserListScreenContent(
    state: UserListUIState,
    handleEvent: (event: UserListUIEvent) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        when (state) {
            UserListUIState.Loading -> {
                UserListLoading()
            }

            is UserListUIState.Data -> {
                UserListData(
                    users = state.users,
                    onItemClicked = { user ->
                        handleEvent(UserListUIEvent.ItemClicked(user = user))
                    }
                )
            }

            UserListUIState.Error -> {
                UserListError()
            }
        }
    }
}

// region PREVIEW
@Preview(name = "Light")
@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewUserListScreenContent() {
    AndroidAppArchitectureTheme {
        UserListScreenContent(
            state = UserListSampleData.createDataUIState(),
            handleEvent = { }
        )
    }
}
// endregion