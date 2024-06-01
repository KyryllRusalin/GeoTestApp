package com.kyryll.geotestapp.data.remote

import androidx.compose.runtime.InternalComposeTracingApi
import com.kyryll.geotestapp.data.remote.requests.ApiPostPositionsRequest
import com.kyryll.geotestapp.data.remote.responses.ApiPostPositionsResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface MockApi {
    @POST("/positions")
    suspend fun postPositions(
        @Body positions: ApiPostPositionsRequest
    ): Response<ApiPostPositionsResponse>
}