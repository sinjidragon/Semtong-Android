package com.sinjidragon.semtong.auth.network.api

import android.util.Log
import com.sinjidragon.semtong.auth.network.parseErrorResponse
import com.sinjidragon.semtong.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

suspend fun checkUsername(username: String): String {
    return withContext(Dispatchers.IO) {
        try {
            val authService = RetrofitClient.authService
            authService.checkUsername(username)
            "success"
        } catch (e: HttpException) {
            val errorResponse = e.response()?.errorBody()?.string()?.let { parseErrorResponse(it) }
            Log.d("checkUsername", errorResponse?.error ?: "다시 시도해주세요.")
            errorResponse?.error ?: "다시 시도해주세요."
        } catch (e: Exception) {
            e.printStackTrace()
            "서버 연결 에러입니다."
        }
    }
}