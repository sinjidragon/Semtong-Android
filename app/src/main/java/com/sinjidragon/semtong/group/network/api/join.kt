package com.sinjidragon.semtong.group.network.api

import android.content.Context
import android.util.Log
import com.sinjidragon.semtong.auth.network.api.refresh
import com.sinjidragon.semtong.auth.network.parseErrorResponse
import com.sinjidragon.semtong.auth.network.token.getAccToken
import com.sinjidragon.semtong.auth.network.token.getRefToken
import com.sinjidragon.semtong.group.network.RetrofitClient
import com.sinjidragon.semtong.group.network.data.JoinRequestBody
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

suspend fun join(context: Context, groupCode: String): Any {
    return withContext(Dispatchers.IO) {
        try {
            val accessToken= "Bearer " + getAccToken(context)
            val groupService = RetrofitClient.groupService
            val joinRequest = JoinRequestBody(groupCode)
            val response = groupService.join(accessToken,joinRequest)
            response
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            when (e.code()) {
                401 -> {
                    val refreshToken = getRefToken(context)
                    refreshToken?.let { refresh(context, it) }
                    create(context)
                }
                else -> {
                    val errorResponse = errorBody?.let { parseErrorResponse(it) }
                    errorResponse?.error ?: "알 수 없는 오류가 발생했습니다."
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            "서버 연결 에러입니다."
        }
    }
}
