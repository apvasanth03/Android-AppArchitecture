package com.vasanth.apparchitecture.ui.userlist.viewmodel.mapper

import com.vasanth.apparchitecture.core.dsl.Given
import com.vasanth.apparchitecture.core.dsl.Then
import com.vasanth.apparchitecture.core.dsl.When
import com.vasanth.apparchitecture.core.dsl.gherkin
import com.vasanth.apparchitecture.core.rule.MainCoroutineRule
import com.vasanth.apparchitecture.data.model.User
import com.vasanth.apparchitecture.testfixture.data.UserFixture.generateUser
import com.vasanth.apparchitecture.ui.userlist.viewmodel.model.UserUIModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

@ExperimentalCoroutinesApi
class UserUIMapperTest {

    // region Variable Declaration
    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    lateinit var mapper: UserUIMapper
    // endregion

    // region Setup
    @Before
    fun setUp() {
        mapper = UserUIMapper(
            dispatcher = mainCoroutineRule.testDispatcher
        )
    }
    // endregion

    // region Test - Mapper
    @Test
    fun `Test - Mapper`() = gherkin {
        runTest {
            val user: User
            Given("User") {
                user = generateUser()
            }

            val result: UserUIModel
            When("Mapped") {
                result = mapper.invoke(user)
            }

            Then("Should - return expected Output") {
                val expectedResult = with(user) {
                    UserUIModel(
                        id = id,
                        name = "$firstName $lastName",
                        email = email,
                        avatar = avatar
                    )
                }
                assertThat(
                    result,
                    equalTo(expectedResult)
                )
            }
        }
    }
    // endregion
}