package com.sinjidragon.semtong.group.network.api

import android.content.Context
import com.sinjidragon.semtong.auth.network.api.refresh
import com.sinjidragon.semtong.auth.network.parseErrorResponse
import com.sinjidragon.semtong.auth.network.user.getAccToken
import com.sinjidragon.semtong.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

data class UserInfo(
    val userid : Int
)

suspend fun deleteMember(context: Context, userId : Int): String {
    return withContext(Dispatchers.IO) {
        try {
            val accessToken= "Bearer " + getAccToken(context)
            val groupService = RetrofitClient.groupService
            val deleteUserRequest = UserInfo(userId)
            groupService.deleteMember(accessToken,deleteUserRequest)
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
                    errorResponse?.error ?: "알 수 없는 오류가 발생했습니다."
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            "서버 연결 에러입니다."
        }
    }
}