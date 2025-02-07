package com.chesire.pushie.datasource.pwpush

import com.chesire.pushie.common.ApiError
import com.chesire.pushie.datasource.pwpush.remote.PushedModel
import com.chesire.pushie.datasource.pwpush.remote.PusherApi
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.onSuccess

/**
 * Repository to interact with the [PusherApi] remote data source, and to interact with any local
 * data sources that store urls.
 */
class PWPushRepository(private val passwordAPI: PusherApi) {

    /**
     * Sends the [password] up to the API.
     */
    suspend fun sendPassword(
        password: String,
        expiryDays: Int,
        expiryViews: Int
    ): Result<PushedModel, ApiError> {
        return passwordAPI
            .sendPassword(password, expiryDays, expiryViews)
            .onSuccess {
                // TODO: store in local db. Use a flow from there to return these urls
            }
    }
}
