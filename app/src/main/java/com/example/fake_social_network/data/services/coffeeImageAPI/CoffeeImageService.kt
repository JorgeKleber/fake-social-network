package com.example.fake_social_network.data.services.coffeeImageAPI

import com.example.core.models.CoffeeImage
import retrofit2.Call
import retrofit2.http.GET

interface CoffeeImageService {

    @GET("random.json")
    fun getCoffeeImage() : Call<CoffeeImage>
}