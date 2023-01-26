package com.vasanth.apparchitecture.data.datasource.remote

import com.vasanth.apparchitecture.data.datasource.remote.mapper.toDataModel
import com.vasanth.apparchitecture.data.datasource.remote.service.UserService
import com.vasanth.apparchitecture.data.model.User
import com.vasanth.commoncore.data.RemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRemoteDataSource @Inject constructor(
    private val userService: UserService
) : RemoteDataSource {

    suspend fun getUsers(page: Int): List<User> {
        val response = userService.getUsers(page = page)
        val users = response.data.map {
            it.toDataModel()
        }
        return users
    }
}