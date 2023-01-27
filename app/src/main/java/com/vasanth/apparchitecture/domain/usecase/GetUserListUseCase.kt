package com.vasanth.apparchitecture.domain.usecase

import com.vasanth.apparchitecture.data.model.User
import com.vasanth.apparchitecture.data.repository.UserRepository
import com.vasanth.commoncore.di.qualifier.IoDispatcher
import com.vasanth.commoncore.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetUserListUseCase @Inject constructor(
    private val userRepository: UserRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<GetUserListUseCase.Param, List<User>>(dispatcher) {

    data class Param(
        val page: Int
    )

    override suspend fun execute(parameters: Param): List<User> {
        val users = userRepository.getUsers(page = parameters.page)
        return users
    }
}