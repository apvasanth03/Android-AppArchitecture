package com.vasanth.apparchitecture.data.model


data class UserListResponse(
    val page: Int,
    val perPage: Int,
    val total: Int,
    val totalPages: Int,
    val data: List<User>
)
