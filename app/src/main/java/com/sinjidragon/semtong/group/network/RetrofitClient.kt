package com.sinjidragon.semtong.group.network

import com.sinjidragon.semtong.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var retrofit: Retrofit? = null


    fun getClient(baseUrl: String): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }

    val groupService: GroupService by lazy {
        val url = BuildConfig.BASE_URL
        getClient(url).create(GroupService::class.java)
    }
}