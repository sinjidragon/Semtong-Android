package com.sinjidragon.semtong.auth.network.token

import android.content.Context
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

fun getRefToken(context: Context): String? {
    return runBlocking {
        val preferences = context.dataStore.data.first()
        preferences[REF_TOKEN]
    }
}
fun getAccToken(context: Context): String? {
    return runBlocking {
        val preferences = context.dataStore.data.first()
        preferences[ACC_TOKEN]
    }
}
fun getRole(context: Context): String? {
    return runBlocking {
        val preferences = context.dataStore.data.first()
        preferences[ROLES]
    }
}