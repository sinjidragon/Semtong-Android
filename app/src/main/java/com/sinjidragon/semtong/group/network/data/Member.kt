package com.sinjidragon.semtong.group.network.data

data class Member (
    val uid : Int,
    val username : String,
    val password : String,
    val email : String,
    val role : String
)