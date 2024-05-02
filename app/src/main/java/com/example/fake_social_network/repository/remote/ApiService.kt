package com.example.fake_social_network.repository.remote

import com.example.fake_social_network.services.handomUserAPI.IHandomUserApi

class ApiService (private val handomUserService : IHandomUserApi) {
    fun getUserData() = handomUserService.getUserList()

}