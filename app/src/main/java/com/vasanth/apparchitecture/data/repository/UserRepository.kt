package com.vasanth.apparchitecture.data.repository

import com.vasanth.apparchitecture.data.datasource.local.UserLocalDataSource
import com.vasanth.apparchitecture.data.datasource.remote.UserRemoteDataSource
import com.vasanth.apparchitecture.data.model.UserListResponse
import com.vasanth.commoncore.data.Repository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val userLocalDataSource: UserLocalDataSource,
    private val userRemoteDataSource: UserRemoteDataSource
) : Repository {

    // Repository Methods
    override suspend fun clearStore() {
        userLocalDataSource.clearStore()
    }

    // Public API's
    suspend fun getUsers(page: Int): UserListResponse {
        val response = userRemoteDataSource.getUsers(page = page)
        return response
    }
}