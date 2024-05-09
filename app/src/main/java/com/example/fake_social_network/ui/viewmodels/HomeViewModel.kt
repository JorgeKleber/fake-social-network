package com.example.fake_social_network.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.models.CoffeeImage
import com.example.core.models.Post
import com.example.core.models.Root
import com.example.fake_social_network.data.repository.remote.RemoteServiceImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    val contactList = MutableLiveData<Root>()
    val errorMessage = MutableLiveData<String>()

    private val remoteService = RemoteServiceImpl.createRemoteService()
    var coffeeImage = MutableLiveData<CoffeeImage>()
    var dogImage = MutableLiveData<List<String>>()

    var fakePosts = ArrayList<Post>()

    fun getUserList() {

        remoteService.getUserList().enqueue(object : Callback<Root> {
            override fun onResponse(call: Call<Root>, response: Response<Root>) {
                contactList.postValue(response.body())

            }

            override fun onFailure(call: Call<Root>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }

    fun getDogImage(){
        remoteService.getDogImage().enqueue(object : Callback<List<String>> {
            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                dogImage.postValue(response.body())

                val testeContact = contactList.value

            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }

    fun getCoffeeImage(){
        remoteService.getCoffeeImage().enqueue(object : Callback<CoffeeImage> {
            override fun onResponse(call: Call<CoffeeImage>, response: Response<CoffeeImage>) {
                coffeeImage.postValue(response.body())
            }

            override fun onFailure(call: Call<CoffeeImage>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }

    fun getFakeData() : ArrayList<Post>{

        for (i in 1..10)
        {
            var user_name_full = contactList.value!!.results[i].name!!.first + " " +
                    contactList.value!!.results[i].name!!.last

            fakePosts.add(
                Post(
                post_id = contactList.value!!.results[i].id?.value.toString(),
                post_user_image = contactList.value!!.results[i].picture?.medium.toString(),
                post_user_name = user_name_full,
                post_user_country = contactList.value!!.results[i].location!!.country.toString(),
                post_image = dogImage.value!![i],
                post_subtitle = "",
            ))
        }
        return fakePosts
    }
}