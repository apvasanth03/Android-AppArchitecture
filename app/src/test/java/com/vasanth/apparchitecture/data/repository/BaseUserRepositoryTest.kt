package com.vasanth.apparchitecture.data.repository

import com.vasanth.apparchitecture.core.dsl.Given
import com.vasanth.apparchitecture.core.dsl.Then
import com.vasanth.apparchitecture.core.dsl.When
import com.vasanth.apparchitecture.core.dsl.gherkin
import com.vasanth.apparchitecture.core.rule.MainCoroutineRule
import com.vasanth.apparchitecture.data.datasource.local.UserLocalDataSource
import com.vasanth.apparchitecture.data.datasource.remote.UserRemoteDataSource
import com.vasanth.apparchitecture.data.model.User
import com.vasanth.apparchitecture.testfixture.data.UserFixture.generateUsers
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
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class BaseUserRepositoryTest {
    // region Variable Declaration
    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Mock
    lateinit var mockUserLocalDataSource: UserLocalDataSource

    @Mock
    lateinit var mockUserRemoteDataSource: UserRemoteDataSource

    private lateinit var userRepository: BaseUserRepository
    // endregion

    // region Setup
    @Before
    fun setUp() {
        userRepository = BaseUserRepository(
            userLocalDataSource = mockUserLocalDataSource,
            userRemoteDataSource = mockUserRemoteDataSource
        )
    }
    // endregion

    // region Test - ClearStore
    @Test
    fun `Test - clearStore`() = gherkin {
        runTest {
            When("ClearStore invoked") {
                userRepository.clearStore()
            }

            Then("Should invoke - userLocalDataSource.clearStore") {
                verify(mockUserLocalDataSource).clearStore()
            }
        }


    }
    // endregion

    // region Test - GetUsers
    @Test
    fun `Test - getUsers`() = gherkin {
        runTest {
            val users: List<User>
            Given("UserRemoteDataSource - return users") {
                users = generateUsers()
                whenever(mockUserRemoteDataSource.getUsers(any()))
                    .thenReturn(users)
            }

            val result: List<User>
            When("GetUsers invoked") {
                result = userRepository.getUsers(1)
            }
            Then("Should return - Users") {
                assertThat(result, equalTo(users))
            }
        }
    }
    // endregion
}