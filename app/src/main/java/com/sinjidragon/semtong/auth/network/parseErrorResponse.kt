package com.sinjidragon.semtong.auth.network

import com.google.gson.Gson
import com.sinjidragon.semtong.auth.network.data.ErrorResponse

fun parseErrorResponse(errorBody: String): ErrorResponse {
    return try {
        Gson().fromJson(errorBody, ErrorResponse::class.java)
    } catch (e: Exception) {
        e.printStackTrace()
        ErrorResponse("파싱 오류", "다시 시도해주세요.")
    }
}