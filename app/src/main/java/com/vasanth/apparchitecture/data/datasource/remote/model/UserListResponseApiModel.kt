package com.vasanth.apparchitecture.data.datasource.remote.model

import com.google.gson.annotations.SerializedName


data class UserListResponseApiModel(
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    val data: List<UserApiModel>
)
