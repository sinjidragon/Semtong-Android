package com.sinjidragon.semtong.auth.network.api

import android.content.Context
import com.sinjidragon.semtong.network.RetrofitClient
import com.sinjidragon.semtong.auth.network.parseErrorResponse
import com.sinjidragon.semtong.auth.network.user.getAccToken
import com.sinjidragon.semtong.auth.network.user.saveAccToken
import com.sinjidragon.semtong.auth.network.user.saveRefToken
import com.sinjidragon.semtong.auth.network.user.saveRole
import com.sinjidragon.semtong.group.network.api.create
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

suspend fun deleteUser(context: Context): String {
    return withContext(Dispatchers.IO) {
        try {
            val accessToken= "Bearer " + getAccToken(context)
            val authService = RetrofitClient.authService
            authService.deleteUser(accessToken)
            saveRole(context,null)
            saveAccToken(context,null)
            saveRefToken(context,null)
            "success"
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            when (e.code()) {
                401 -> {
                    refresh(context)
                    create(context)
                    ""
                }
                else -> {
                    val errorResponse = errorBody?.let { parseErrorResponse(it) }
                    errorResponse?.message ?: "알 수 없는 오류가 발생했습니다."
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            "서버 연결 에러입니다."
        }
    }
}