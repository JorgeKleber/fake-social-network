package com.example.fake_social_network.data.repository.remote


import com.example.core.models.Root
import retrofit2.Call

interface RemoteService {
    fun getUserList() : Call<Root>
}