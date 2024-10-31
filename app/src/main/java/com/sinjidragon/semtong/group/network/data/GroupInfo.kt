package com.sinjidragon.semtong.group.network.data

data class GroupInfo (
    val groupName : String,
    val groupCode : String,
    val members : List<Member>
)