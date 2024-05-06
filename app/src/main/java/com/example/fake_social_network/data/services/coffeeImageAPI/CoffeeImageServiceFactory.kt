package com.example.fake_social_network.data.services.coffeeImageAPI

import com.example.fake_social_network.data.services.dogsImageAPI.DogsImageService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CoffeeImageServiceFactory {

    private const val BASE_URL = "https://coffee.alexflipnote.dev/"

    fun createCoffeeImageAPIService() : CoffeeImageService
    {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api: CoffeeImageService = retrofit.create(CoffeeImageService::class.java)
        return api
    }

}