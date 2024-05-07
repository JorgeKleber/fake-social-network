package com.example.fake_social_network.data.services.handomUserAPI

import com.example.core.models.Root
import retrofit2.Call
import retrofit2.http.GET

interface HandomUserService {
    @GET("?results=20")
    fun getUserList(): Call<Root>

}