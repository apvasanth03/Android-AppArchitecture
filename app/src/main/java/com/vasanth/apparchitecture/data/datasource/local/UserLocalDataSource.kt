package com.vasanth.apparchitecture.data.datasource.local

import com.vasanth.commoncore.data.LocalDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserLocalDataSource @Inject constructor() : LocalDataSource {

    override suspend fun clearStore() {
        // NO-OP
    }
}