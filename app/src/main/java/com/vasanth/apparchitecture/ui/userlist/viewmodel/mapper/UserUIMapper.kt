package com.vasanth.apparchitecture.ui.userlist.viewmodel.mapper

import com.vasanth.apparchitecture.data.model.User
import com.vasanth.apparchitecture.ui.userlist.viewmodel.model.UserUIModel
import com.vasanth.commoncore.di.qualifier.DefaultDispatcher
import com.vasanth.commoncore.ui.mapper.Mapper
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class UserUIMapper @Inject constructor(
    @DefaultDispatcher dispatcher: CoroutineDispatcher
) : Mapper<User, UserUIModel>(dispatcher = dispatcher) {

    override suspend fun map(input: User): UserUIModel {
        return with(input) {
            val uiModel = UserUIModel(
                id = id,
                name = "$firstName $lastName",
                email = email,
                avatar = avatar
            )
            uiModel
        }
    }
}