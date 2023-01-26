package com.vasanth.apparchitecture.data.datasource.remote.model

import com.google.gson.annotations.SerializedName
import com.vasanth.apparchitecture.data.model.User

/**
 * Network representation of [User]
 */
data class UserApiModel(
    val id: Long,
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    val avatar: String,
)
