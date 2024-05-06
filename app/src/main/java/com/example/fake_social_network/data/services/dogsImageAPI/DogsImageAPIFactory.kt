package com.example.fake_social_network.data.services.dogsImageAPI

import com.example.fake_social_network.data.services.handomUserAPI.HandomUserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DogsImageAPIFactory {

    private const val BASE_URL = "https://random.dog/"

    fun createDogsImageAPIService() : DogsImageService
    {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api: DogsImageService = retrofit.create(DogsImageService::class.java)
        return api
    }


}