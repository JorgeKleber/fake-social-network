package com.example.fake_social_network.data.repository.remote


import com.example.core.models.Root
import com.example.fake_social_network.data.services.handomUserAPI.HandomUserService
import com.example.fake_social_network.data.services.handomUserAPI.HandomUserServiceFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteServiceImpl() : RemoteService {

    private val handoUserService = HandomUserServiceFactory.createHandomUserService()

    override fun getUserList(): Call<Root> {
        return handoUserService.getUserList()
    }

    companion object{
        fun createRemoteService() : RemoteServiceImpl{
            return RemoteServiceImpl()
        }
    }
}

