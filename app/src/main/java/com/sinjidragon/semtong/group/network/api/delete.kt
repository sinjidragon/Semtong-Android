package com.sinjidragon.semtong.group.network.api

import android.content.Context
import com.sinjidragon.semtong.auth.network.api.refresh
import com.sinjidragon.semtong.auth.network.parseErrorResponse
import com.sinjidragon.semtong.auth.network.user.getAccToken
import com.sinjidragon.semtong.auth.network.user.saveRole
import com.sinjidragon.semtong.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

suspend fun delete(context: Context): String {
    return withContext(Dispatchers.IO) {
        try {
            val accessToken= "Bearer " + getAccToken(context)
            val authService = RetrofitClient.groupService
            authService.delete(accessToken)
            saveRole(context,null)
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