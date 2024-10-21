package com.sinjidragon.semtong.auth.network.data

data class LoginResponseBody (
    val accessToken : String,
    val refreshToken : String,
    val tokenType : String
)