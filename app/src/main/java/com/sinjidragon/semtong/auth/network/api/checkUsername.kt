package com.sinjidragon.semtong.auth.network.api

import com.sinjidragon.semtong.auth.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun checkUsername(username: String): String? {
    return withContext(Dispatchers.IO) {
        try {
            val authService = RetrofitClient.authPostService
            authService.checkUsername(username)
            "success"
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}