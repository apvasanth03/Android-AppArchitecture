package com.vasanth.apparchitecture.data.datasource.remote.mapper

import com.vasanth.apparchitecture.core.dsl.Given
import com.vasanth.apparchitecture.core.dsl.Then
import com.vasanth.apparchitecture.core.dsl.When
import com.vasanth.apparchitecture.core.dsl.gherkin
import com.vasanth.apparchitecture.data.datasource.remote.model.UserApiModel
import com.vasanth.apparchitecture.data.model.User
import com.vasanth.apparchitecture.testfixture.data.remote.UserApiModelFixture.generateUserApiModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

@ExperimentalCoroutinesApi
class UserApiModelMapperTest {

    // region Test - ToDataModel
    @Test
    fun `Test - Mapper`() = gherkin {
        val userApiModel: UserApiModel
        Given("UserApiModel") {
            userApiModel = generateUserApiModel()
        }

        val result: User
        When("Mapped to DataModel") {
            result = userApiModel.toDataModel()
        }

        Then("Should return expected result") {
            val expectedResult = with(userApiModel) {
                User(
                    id = id,
                    email = email,
                    firstName = firstName,
                    lastName = lastName,
                    avatar = avatar
                )
            }

            assertThat(result, equalTo(expectedResult))
        }
    }
    // endregion
}