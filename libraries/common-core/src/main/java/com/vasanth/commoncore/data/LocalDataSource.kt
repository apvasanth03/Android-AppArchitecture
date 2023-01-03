package com.vasanth.commoncore.data

/**
 * LocalDataSource - Base interface for all `LocalDataSources`
 */
interface LocalDataSource {

    suspend fun clearStore()
}