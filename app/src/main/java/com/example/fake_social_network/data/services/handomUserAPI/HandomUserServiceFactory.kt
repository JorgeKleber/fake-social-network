package com.example.fake_social_network.data.services.handomUserAPI

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HandomUserServiceFactory {

    private const val BASE_URL = "https://randomuser.me/api/"

    fun createHandomUserService() : HandomUserService
    {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api: HandomUserService = retrofit.create(HandomUserService::class.java)
        return api
    }
}