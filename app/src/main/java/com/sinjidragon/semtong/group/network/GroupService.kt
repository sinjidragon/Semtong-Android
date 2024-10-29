package com.sinjidragon.semtong.group.network

import com.sinjidragon.semtong.group.network.data.CreateResponseBody
import com.sinjidragon.semtong.group.network.data.JoinRequestBody
import com.sinjidragon.semtong.group.network.data.JoinResponseBody
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface GroupService {
    @POST("group/join")
    suspend fun join(
        @Header("Authorization") token: String,
        @Body request: JoinRequestBody
    ): JoinResponseBody
    @POST("group")
    suspend fun create(
        @Header("Authorization") token: String,
    ): CreateResponseBody
}