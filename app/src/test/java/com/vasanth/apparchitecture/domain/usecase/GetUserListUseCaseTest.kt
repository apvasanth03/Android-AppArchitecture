package com.vasanth.apparchitecture.domain.usecase

import com.vasanth.apparchitecture.core.dsl.Given
import com.vasanth.apparchitecture.core.dsl.Then
import com.vasanth.apparchitecture.core.dsl.When
import com.vasanth.apparchitecture.core.dsl.gherkin
import com.vasanth.apparchitecture.core.rule.MainCoroutineRule
import com.vasanth.apparchitecture.data.model.User
import com.vasanth.apparchitecture.data.repository.UserRepository
import com.vasanth.apparchitecture.testfixture.data.UserFixture.generateUsers
import com.vasanth.commoncore.domain.model.Result
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class GetUserListUseCaseTest {

    // region Variable Declaration
    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Mock
    lateinit var mockUserRepository: UserRepository

    private lateinit var getUserListUseCase: GetUserListUseCase
    // endregion

    // region Setup
    @Before
    fun setUp() {
        getUserListUseCase = GetUserListUseCase(
            userRepository = mockUserRepository,
            dispatcher = mainCoroutineRule.testDispatcher
        )
    }
    // endregion

    // region Test - GetUserList
    @Test
    fun `Test - GetUserListUseCase - Success Case`() = gherkin {
        runTest {
            val users: List<User>
            Given("UserRepository.getUsers -  return success") {
                users = generateUsers()
                whenever(mockUserRepository.getUsers(any()))
                    .thenReturn(users)
            }

            val result: Result<List<User>>
            When("UseCase - Invoked") {
                val param = GetUserListUseCase.Param(page = 1)
                result = getUserListUseCase(param)
            }

            Then("Should return - Success result") {
                val expectedResult = Result.Success(data = users)
                assertThat(result, equalTo(expectedResult))
            }
        }
    }

    @Test
    fun `Test - GetUserListUseCase - Error Case`() = gherkin {
        runTest {
            val exception: Exception
            Given("UserRepository.getUsers -  return error") {
                exception = RuntimeException()
                whenever(mockUserRepository.getUsers(any()))
                    .thenThrow(exception)
            }

            val result: Result<List<User>>
            When("UseCase - Invoked") {
                val param = GetUserListUseCase.Param(page = 1)
                result = getUserListUseCase(param)
            }

            Then("Should return - Error result") {
                val expectedResult = Result.Error(exception = exception)
                assertThat(result, equalTo(expectedResult))
            }
        }
    }
    // endregion
}