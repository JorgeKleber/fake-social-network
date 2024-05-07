package com.example.fake_social_network.data.repository.remote


import com.example.core.models.CoffeeImage
import com.example.core.models.DogImage
import com.example.core.models.Post
import com.example.core.models.Root
import com.example.fake_social_network.data.services.coffeeImageAPI.CoffeeImageServiceFactory
import com.example.fake_social_network.data.services.dogsImageAPI.DogsImageAPIFactory
import com.example.fake_social_network.data.services.handomUserAPI.HandomUserService
import com.example.fake_social_network.data.services.handomUserAPI.HandomUserServiceFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteServiceImpl() : RemoteService {

    private val handoUserService = HandomUserServiceFactory.createHandomUserService()
    private val coffeeImgService = CoffeeImageServiceFactory.createCoffeeImageAPIService()
    private val dogImgService = DogsImageAPIFactory.createDogsImageAPIService()

    override fun getUserList(): Call<Root> {
        return handoUserService.getUserList()
    }

    override fun getDogImage(): Call<DogImage> {
        return dogImgService.getDogImage()
    }

    override fun getCoffeeImage(): Call<CoffeeImage> {
       return coffeeImgService.getCoffeeImage()
    }

    companion object{
        fun createRemoteService() : RemoteServiceImpl{
            return RemoteServiceImpl()
        }
    }
}

