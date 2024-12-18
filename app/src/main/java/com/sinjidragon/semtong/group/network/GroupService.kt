package com.sinjidragon.semtong.group.network

import com.sinjidragon.semtong.group.network.api.UserInfo
import com.sinjidragon.semtong.group.network.data.CreateResponseBody
import com.sinjidragon.semtong.group.network.data.GroupInfo
import com.sinjidragon.semtong.group.network.data.JoinRequestBody
import com.sinjidragon.semtong.group.network.data.JoinResponseBody
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
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
    @GET("group/members")
    suspend fun getGroupInfo(
        @Header("Authorization") token: String,
    ): GroupInfo
    @POST("group/member")
    suspend fun deleteMember(
        @Header("Authorization") token: String,
        @Body request: UserInfo
    )
    @POST("group/leave")
    suspend fun leaveGroup(
        @Header("Authorization") token: String,
    )
    @DELETE("group")
    suspend fun delete(
        @Header("Authorization") token: String,
    )
}