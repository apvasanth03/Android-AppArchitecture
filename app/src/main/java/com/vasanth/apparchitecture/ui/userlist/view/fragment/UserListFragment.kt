package com.vasanth.apparchitecture.ui.userlist.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.vasanth.apparchitecture.ui.userlist.view.components.UserListScreen
import com.vasanth.apparchitecture.ui.userlist.viewmodel.UserListViewModel
import com.vasanth.apparchitecture.ui.userlist.viewmodel.model.UserListSideEffect
import com.vasanth.commoncore.ui.view.BaseComponentFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserListFragment : BaseComponentFragment() {

    private val viewModel: UserListViewModel by viewModels()

    // region Fragment Methods
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setUpViewModelBindings()

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    @Composable
    override fun CreateContent() {
        UserListScreen()
    }
    // endregion

    // region Helper Methods.
    private fun setUpViewModelBindings() {
        observeSideEffect()
    }

    // region ViewModel SideEffect
    private fun observeSideEffect() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.sideEffect.collect {
                    handleSideEffect(it)
                }
            }
        }
    }

    private fun handleSideEffect(it: UserListSideEffect) {
        when (it) {
            is UserListSideEffect.NavigateToUserDetailScreen -> {
                navigateToUserDetailScreen(it)
            }
        }
    }

    private fun navigateToUserDetailScreen(
        sideEffect: UserListSideEffect.NavigateToUserDetailScreen
    ) {
        // Not yet Implemented
    }
    // endregion
    // endregion
}