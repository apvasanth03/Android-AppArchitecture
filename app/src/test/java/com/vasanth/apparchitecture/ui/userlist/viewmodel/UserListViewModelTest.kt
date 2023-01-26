package com.vasanth.apparchitecture.ui.userlist.viewmodel

import com.vasanth.apparchitecture.core.dsl.*
import com.vasanth.apparchitecture.core.rule.MainCoroutineRule
import com.vasanth.apparchitecture.data.model.User
import com.vasanth.apparchitecture.domain.usecase.GetUserListUseCase
import com.vasanth.apparchitecture.testfixture.data.UserFixture.generateUsers
import com.vasanth.apparchitecture.testfixture.ui.UserUIModelFixture.generateUserUIModel
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
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class UserListViewModelTest {

    // region Variable Declaration
    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Mock
    lateinit var mockGetUserListUseCase: GetUserListUseCase

    @Mock
    lateinit var mockUserUIMapper: UserUIMapper

    private lateinit var viewModel: UserListViewModel
    // endregion

    // region Setup
    private fun createViewModel() {
        viewModel = UserListViewModel(
            getUserListUseCase = mockGetUserListUseCase,
            userUIMapper = mockUserUIMapper
        )
    }
    // endregion

    // region Test - loadUsers
    @Test
    fun `Test - LoadUsers - Success case`() = gherkin {
        runTest {
            val users: List<User>
            val userUIModel: UserUIModel
            Given("UseCase - returns Success result") {
                users = generateUsers()
                whenever(mockGetUserListUseCase.invoke(any()))
                    .thenReturn(Result.Success(users))
            }
            And("Mapper - return UIModel") {
                userUIModel = generateUserUIModel()
                whenever(mockUserUIMapper.invoke(any()))
                    .thenReturn(userUIModel)
            }

            val result: UserListUIState
            When("ViewModel - is initialized") {
                createViewModel()
                result = viewModel.uiStateStream.value
            }

            Then("should - emit success event") {
                val userUIModels = List(size = users.size) {
                    userUIModel
                }
                val expectedResult = UserListUIState.Data(users = userUIModels)
                assertThat(
                    result,
                    equalTo(expectedResult)
                )
            }
        }
    }

    @Test
    fun `Test - LoadUsers - Error case`() = gherkin {
        runTest {
            val exception: Exception
            Given("UseCase - returns Error result") {
                exception = RuntimeException()
                whenever(mockGetUserListUseCase.invoke(any()))
                    .thenReturn(Result.Error(exception))
            }

            val result: UserListUIState
            When("ViewModel - is initialized") {
                createViewModel()
                result = viewModel.uiStateStream.value
            }

            Then("should - emit success event") {
                val expectedResult = UserListUIState.Error
                assertThat(
                    result,
                    equalTo(expectedResult)
                )
            }
        }
    }
    // endregion
}