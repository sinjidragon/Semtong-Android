package com.sinjidragon.semtong.auth.network.api

import android.util.Log
import com.sinjidragon.semtong.network.RetrofitClient
import com.sinjidragon.semtong.auth.network.data.VerifyRequestBody
import com.sinjidragon.semtong.auth.network.parseErrorResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

suspend fun verify(email: String, code: String): String {
    return withContext(Dispatchers.IO) {
        try {
            val authService = RetrofitClient.authService
            val verifyRequest = VerifyRequestBody(email, code)
            authService.verify(verifyRequest)
            "success"
        } catch (e: HttpException) {
            val errorResponse = e.response()?.errorBody()?.string()?.let { parseErrorResponse(it) }
            Log.d("verify", errorResponse?.message ?: "다시 시도해주세요.")
            errorResponse?.message ?: "다시 시도해주세요."
        } catch (e: Exception) {
            e.printStackTrace()
            "서버 연결 에러입니다."
        }
    }
}

