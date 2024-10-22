package com.sinjidragon.semtong.auth.network.data

data class SignupRequestBody (
    val username : String,
    val password : String,
    val email : String
)