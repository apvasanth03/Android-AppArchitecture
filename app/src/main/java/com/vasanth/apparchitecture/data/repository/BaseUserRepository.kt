package com.vasanth.apparchitecture.data.repository

import com.vasanth.apparchitecture.data.datasource.local.UserLocalDataSource
import com.vasanth.apparchitecture.data.datasource.remote.UserRemoteDataSource
import com.vasanth.apparchitecture.data.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BaseUserRepository @Inject constructor(
    private val userLocalDataSource: UserLocalDataSource,
    private val userRemoteDataSource: UserRemoteDataSource
) : UserRepository {
    
    override suspend fun clearStore() {
        userLocalDataSource.clearStore()
    }

    override suspend fun getUsers(page: Int): List<User> {
        val users = userRemoteDataSource.getUsers(page = page)
        return users
    }
}