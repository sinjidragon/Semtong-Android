package com.sinjidragon.semtong.auth.network

import com.sinjidragon.semtong.auth.network.data.LoginRequestBody
import com.sinjidragon.semtong.auth.network.data.LoginResponseBody
import com.sinjidragon.semtong.auth.network.data.RefreshRequestBody
import com.sinjidragon.semtong.auth.network.data.VerifyRequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthService {
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequestBody): LoginResponseBody
    @GET("auth/checkusername")
    suspend fun checkUsername(@Query("username") username: String)
    @POST("auth/sendmail")
    suspend fun sendMail(@Query("email") email: String)
    @POST("/auth/verify")
    suspend fun verify(@Body request: VerifyRequestBody)
    @POST("/auth/refresh")
    suspend fun refresh(@Body request: RefreshRequestBody): LoginResponseBody

}