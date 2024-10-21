package com.sinjidragon.semtong.auth.network.api

import android.content.Context
import com.sinjidragon.semtong.auth.network.RetrofitClient
import com.sinjidragon.semtong.auth.network.data.LoginRequestBody
import com.sinjidragon.semtong.auth.network.data.LoginResponseBody
import com.sinjidragon.semtong.auth.network.token.saveAccToken
import com.sinjidragon.semtong.auth.network.token.saveRefToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun login(context: Context, username: String, password: String): LoginResponseBody? {
    return withContext(Dispatchers.IO) {
        try {
            val authService = RetrofitClient.authPostService
            val loginRequest = LoginRequestBody(username, password)
            val response = authService.login(loginRequest)
            saveAccToken(context, response.accessToken)
            saveRefToken(context, response.refreshToken)
            response
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}