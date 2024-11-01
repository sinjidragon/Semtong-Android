package com.sinjidragon.semtong.group.network

import com.sinjidragon.semtong.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var retrofit: Retrofit? = null


    private fun getClient(): Retrofit {
        if (retrofit == null) {
            val url = BuildConfig.BASE_URL
            retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }

    val groupService: GroupService by lazy {
        getClient().create(GroupService::class.java)
    }
}