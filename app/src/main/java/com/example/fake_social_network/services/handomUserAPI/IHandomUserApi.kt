package com.example.fake_social_network.services.handomUserAPI

import com.example.core.models.Id
import com.example.core.models.Results
import com.example.core.models.Root
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface IHandomUserApi {

    @GET("?results=20")
    fun getUserList() : Call<Root>

    companion object{
        private val retrofitService : IHandomUserApi by lazy {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://randomuser.me/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(IHandomUserApi::class.java)
        }

        fun getInstance() : IHandomUserApi{
            return retrofitService
        }
    }


}