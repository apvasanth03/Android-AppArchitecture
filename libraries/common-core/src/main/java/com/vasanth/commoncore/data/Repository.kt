package com.vasanth.commoncore.data

/**
 * Repository - Base interface for all `Repositories`
 */
interface Repository {

    suspend fun clearStore()
}