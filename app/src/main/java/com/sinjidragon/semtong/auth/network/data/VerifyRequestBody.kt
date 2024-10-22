package com.sinjidragon.semtong.auth.network.data

data class VerifyRequestBody (
    val mail :String,
    val verifyCode : String
)