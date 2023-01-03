package com.vasanth.apparchitecture.data.datasource.remote

import com.vasanth.apparchitecture.data.datasource.remote.service.UserService
import com.vasanth.apparchitecture.data.model.UserListResponse
import com.vasanth.commoncore.data.RemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRemoteDataSource @Inject constructor(
    private val userService: UserService
): RemoteDataSource {

    suspend fun getUsers(page: Int): UserListResponse {
        val response = userService.getUsers(page = page)
        return response
    }
}