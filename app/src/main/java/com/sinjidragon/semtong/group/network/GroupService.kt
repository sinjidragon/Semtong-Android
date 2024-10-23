package com.sinjidragon.semtong.group.network

import com.sinjidragon.semtong.group.network.data.JoinRequestBody
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface GroupService {
    @POST("group/join")
    suspend fun join(
        @Header("Authorization") token: String,
        @Body request: JoinRequestBody
    )
}