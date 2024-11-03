package com.sinjidragon.semtong.auth.network.api

import android.util.Log
import com.sinjidragon.semtong.network.RetrofitClient
import com.sinjidragon.semtong.auth.network.data.SignupRequestBody
import com.sinjidragon.semtong.auth.network.parseErrorResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

suspend fun signup(username: String, password: String, email:String): String {
    return withContext(Dispatchers.IO) {
        try {
            val authService = RetrofitClient.authService
            val signupRequest = SignupRequestBody(username, password, email)
            authService.signup(signupRequest)
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