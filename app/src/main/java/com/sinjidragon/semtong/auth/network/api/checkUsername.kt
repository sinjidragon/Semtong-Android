package com.sinjidragon.semtong.auth.network.api

import com.sinjidragon.semtong.auth.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

suspend fun checkUsername(username: String): String {
    return withContext(Dispatchers.IO) {
        try {
            val authService = RetrofitClient.authPostService
            authService.checkUsername(username)
            "success"
        } catch (e: HttpException) {
            if (e.code() == 400) {
                "invalid username format"
            } else {
                e.printStackTrace()
                "Unknown error"
            }
        } catch (e: Exception) {
            e.printStackTrace()
            "Connect error"
        }
    }
}

