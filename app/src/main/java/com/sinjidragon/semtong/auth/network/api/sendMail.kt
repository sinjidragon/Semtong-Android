package com.sinjidragon.semtong.auth.network.api

import android.util.Log
import com.sinjidragon.semtong.auth.network.RetrofitClient
import com.sinjidragon.semtong.auth.network.parseErrorResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

suspend fun sendMail(email: String): String {
    return withContext(Dispatchers.IO) {
        try {
            val authService = RetrofitClient.authService
            authService.sendMail(email)
            "success"
        } catch (e: HttpException) {
            Log.d("sendMail", "HttpException: ${e.response()?.toString()}")
            val errorBody = e.response()?.errorBody()?.string()
            Log.d("sendMail", "Error body: $errorBody")
            val errorResponse = errorBody?.let { parseErrorResponse(it) }
            errorResponse?.error ?: "알 수 없는 오류가 발생했습니다."
        } catch (e: Exception) {
            e.printStackTrace()
            "서버 연결 에러입니다."
        }
    }
}

