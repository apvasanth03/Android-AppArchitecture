package com.vasanth.apparchitecture.data.datasource.remote.service

import com.vasanth.apparchitecture.data.datasource.remote.model.UserListResponseApiModel
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET("api/users")
    suspend fun getUsers(@Query("page") page: Int): UserListResponseApiModel
}