package com.sinjidragon.semtong.auth.network.api

import android.content.Context
import com.sinjidragon.semtong.auth.network.RetrofitClient
import com.sinjidragon.semtong.auth.network.data.LoginRequestBody
import com.sinjidragon.semtong.auth.network.parseErrorResponse
import com.sinjidragon.semtong.auth.network.user.saveAccToken
import com.sinjidragon.semtong.auth.network.user.saveRefToken
import com.sinjidragon.semtong.auth.network.user.saveUserId
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

suspend fun login(context: Context, username: String, password: String): String {
    return withContext(Dispatchers.IO) {
        try {
            val authService = RetrofitClient.authService
            val loginRequest = LoginRequestBody(username, password)
            val response = authService.login(loginRequest)
            saveAccToken(context, response.accessToken)
            saveRefToken(context, response.refreshToken)
            saveUserId(context, username)
            "success"
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            val errorResponse = errorBody?.let { parseErrorResponse(it) }
            errorResponse?.error ?: "알 수 없는 오류가 발생했습니다."
        } catch (e: Exception) {
            e.printStackTrace()
            "서버 연결 에러입니다."
        }
    }
}
