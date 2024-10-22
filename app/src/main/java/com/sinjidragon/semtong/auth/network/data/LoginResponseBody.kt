package com.sinjidragon.semtong.auth.network.data

data class LoginResponseBody (
    val userRole : String,
    val accessToken : String,
    val refreshToken : String,
    val tokenType : String
)