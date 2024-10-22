package com.sinjidragon.semtong.auth.network.api

import android.content.Context
import android.util.Log
import com.sinjidragon.semtong.auth.network.RetrofitClient
import com.sinjidragon.semtong.auth.network.data.LoginRequestBody
import com.sinjidragon.semtong.auth.network.data.LoginResponseBody
import com.sinjidragon.semtong.auth.network.parseErrorResponse
import com.sinjidragon.semtong.auth.network.token.saveAccToken
import com.sinjidragon.semtong.auth.network.token.saveRefToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

suspend fun login(context: Context, username: String, password: String): String {
    return withContext(Dispatchers.IO) {
        try {
            val authService = RetrofitClient.authPostService
            val loginRequest = LoginRequestBody(username, password)
            val response = authService.login(loginRequest)
            saveAccToken(context, response.accessToken)
            saveRefToken(context, response.refreshToken)
            "success"
        } catch (e: HttpException) {
            Log.d("login", "HttpException: ${e.response()?.toString()}")
            val errorBody = e.response()?.errorBody()?.string()
            Log.d("login", "Error body: $errorBody")
            val errorResponse = errorBody?.let { parseErrorResponse(it) }
            errorResponse?.error ?: "알 수 없는 오류가 발생했습니다."
        } catch (e: Exception) {
            e.printStackTrace()
            "서버 연결 에러입니다."
        }
    }
}
