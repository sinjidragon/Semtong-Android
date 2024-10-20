package com.sinjidragon.semtong.auth.network

import com.sinjidragon.semtong.auth.network.data.LoginRequestBody
import com.sinjidragon.semtong.auth.network.data.LoginResponseBody
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
}