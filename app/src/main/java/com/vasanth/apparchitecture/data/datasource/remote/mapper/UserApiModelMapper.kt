package com.vasanth.apparchitecture.data.datasource.remote.mapper

import com.vasanth.apparchitecture.data.datasource.remote.model.UserApiModel
import com.vasanth.apparchitecture.data.model.User

/**
 * Converts the remote (API) model to the external (Data) model for use
 * by layers external to the data layer
 */
fun UserApiModel.toDataModel(): User {
    return with(this) {
        val user = User(
            id = id,
            email = email,
            firstName = firstName,
            lastName = lastName,
            avatar = avatar
        )
        user
    }
}