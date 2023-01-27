package com.vasanth.apparchitecture.data.model

/**
 * External data layer representation of a [User]
 */
data class User(
    val id: Long,
    val email: String,
    val firstName: String,
    val lastName: String,
    val avatar: String,
)
