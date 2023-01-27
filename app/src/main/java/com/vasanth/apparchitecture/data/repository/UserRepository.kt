package com.vasanth.apparchitecture.data.repository

import com.vasanth.apparchitecture.data.model.User
import com.vasanth.commoncore.data.Repository

interface UserRepository : Repository {

    suspend fun getUsers(page: Int): List<User>
}