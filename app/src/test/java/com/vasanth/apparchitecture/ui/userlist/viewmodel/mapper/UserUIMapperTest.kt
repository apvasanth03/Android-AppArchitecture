package com.vasanth.apparchitecture.ui.userlist.viewmodel.mapper

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.appmattus.kotlinfixture.kotlinFixture
import com.vasanth.apparchitecture.data.model.User
import com.vasanth.apparchitecture.rule.MainCoroutineRule
import com.vasanth.apparchitecture.ui.userlist.viewmodel.model.UserUIModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
class UserUIMapperTest {

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    lateinit var mapper: UserUIMapper

    private val kFixture = kotlinFixture()

    @Before
    fun setUp() {
        mapper = UserUIMapper(
            dispatcher = mainCoroutineRule.testDispatcher
        )
    }

    @Test
    fun `GIVEN User - WHEN Mapped - SHOULD return expected Output`() = runTest {
        // Given
        val user = kFixture<User>()

        // When
        val result = mapper.invoke(user)

        // Then
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