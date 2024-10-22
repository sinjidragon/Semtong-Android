package com.sinjidragon.semtong.auth.network.api

import android.content.Context
import android.util.Log
import com.sinjidragon.semtong.auth.network.RetrofitClient
import com.sinjidragon.semtong.auth.network.data.LoginRequestBody
import com.sinjidragon.semtong.auth.network.data.RefreshRequestBody
import com.sinjidragon.semtong.auth.network.parseErrorResponse
import com.sinjidragon.semtong.auth.network.token.saveAccToken
import com.sinjidragon.semtong.auth.network.token.saveRefToken
import com.sinjidragon.semtong.auth.network.token.saveRole
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

suspend fun refresh (){

}
suspend fun refresh(context: Context, refreshToken: String): String? {
    return withContext(Dispatchers.IO) {
        try {
            val authService = RetrofitClient.authService
            val refreshRequest = RefreshRequestBody(refreshToken)
            val response = authService.refresh(refreshRequest)
            saveAccToken(context, response.accessToken)
            saveRefToken(context, response.refreshToken)
            saveRole(context,response.userRole)
            "success"
        } catch (e: HttpException) {
            Log.d("refresh", "HttpException: ${e.response()?.toString()}")
            val errorBody = e.response()?.errorBody()?.string()
            Log.d("refresh", "Error body: $errorBody")
            val errorResponse = errorBody?.let { parseErrorResponse(it) }
            errorResponse?.error ?: "알 수 없는 오류가 발생했습니다."
        } catch (e: Exception) {
            e.printStackTrace()
            "서버 연결 에러입니다."
        }
    }
}