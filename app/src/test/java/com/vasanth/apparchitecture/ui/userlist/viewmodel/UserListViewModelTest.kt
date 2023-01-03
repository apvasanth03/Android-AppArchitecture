package com.vasanth.apparchitecture.ui.userlist.viewmodel

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.appmattus.kotlinfixture.kotlinFixture
import com.vasanth.apparchitecture.data.model.UserListResponse
import com.vasanth.apparchitecture.domain.usecase.GetUserListUseCase
import com.vasanth.apparchitecture.rule.MainCoroutineRule
import com.vasanth.apparchitecture.ui.userlist.viewmodel.mapper.UserUIMapper
import com.vasanth.apparchitecture.ui.userlist.viewmodel.model.UserListUIState
import com.vasanth.apparchitecture.ui.userlist.viewmodel.model.UserUIModel
import com.vasanth.commoncore.domain.model.Result
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
class UserListViewModelTest {

    // region VARIABLE DECLARATION
    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Mock
    lateinit var getUserListUseCase: GetUserListUseCase

    @Mock
    lateinit var userUIMapper: UserUIMapper

    private lateinit var viewModel: UserListViewModel
    private val kFixture = kotlinFixture()
    // endregion

    // region Setup
    private fun createViewModel() {
        viewModel = UserListViewModel(
            getUserListUseCase = getUserListUseCase,
            userUIMapper = userUIMapper
        )
    }

    // endregion

    @Test
    fun `Given UseCase returns Success result - When ViewModel is initialized - Then should emit success event`() =
        runTest {
            // Given
            val response = kFixture<UserListResponse>()
            whenever(getUserListUseCase.invoke(any())).thenReturn(Result.Success(response))

            val userUIModel = kFixture<UserUIModel>()
            whenever(userUIMapper.invoke(any())).thenReturn(userUIModel)

            // When
            createViewModel()
            val result = viewModel.uiState.value

            // Then
            val users = List(size = response.data.size) {
                userUIModel
            }
            val expectedResult = UserListUIState.Data(users = users)
            assertThat(
                result,
                equalTo(expectedResult)
            )
        }

    @Test
    fun `Given UseCase returns Error result - When ViewModel is initialized - Then should emit error event`() =
        runTest {
            // Given
            val exception = Exception()
            whenever(getUserListUseCase.invoke(any())).thenReturn(Result.Error(exception))

            // When
            createViewModel()
            val result = viewModel.uiState.value

            // Then
            val expectedResult = UserListUIState.Error
            assertThat(
                result,
                equalTo(expectedResult)
            )
        }
}