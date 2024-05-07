package com.example.fake_social_network.data.services.dogsImageAPI

import com.example.core.models.DogImage
import retrofit2.Call
import retrofit2.http.GET

interface DogsImageService {
    @GET("doggos")
    fun getDogImage() : Call<List<String>>

}