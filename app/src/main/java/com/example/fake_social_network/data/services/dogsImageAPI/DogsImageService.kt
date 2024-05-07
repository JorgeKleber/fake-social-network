package com.example.fake_social_network.data.services.dogsImageAPI

import com.example.core.models.DogImage
import retrofit2.Call
import retrofit2.http.GET

interface DogsImageService {
    @GET("woof.json")
    fun getDogImage() : Call<DogImage>

}