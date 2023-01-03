package com.vasanth.apparchitecture.domain.usecase

import com.vasanth.apparchitecture.data.model.UserListResponse
import com.vasanth.apparchitecture.data.repository.UserRepository
import com.vasanth.commoncore.di.qualifier.IoDispatcher
import com.vasanth.commoncore.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetUserListUseCase @Inject constructor(
    private val userRepository: UserRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<GetUserListUseCase.Param, UserListResponse>(dispatcher) {

    data class Param(
        val page: Int
    )

    override suspend fun execute(parameters: Param): UserListResponse {
        val response = userRepository.getUsers(page = parameters.page)
        return response
    }
}