package com.vasanth.commoncore.ui.mapper

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

/**
 * Executes Mapper logic synchronously or asynchronously using Coroutines.
 */
abstract class Mapper<in INPUT, OUTPUT>(protected val dispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(input: INPUT): OUTPUT {
        return withContext(dispatcher) {
            map(input)
        }
    }

    protected abstract suspend fun map(input: INPUT): OUTPUT
}
