package com.example.fake_social_network.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.core.models.CoffeeImage
import com.example.core.models.DogImage
import com.example.core.models.Root
import com.example.fake_social_network.data.repository.remote.RemoteService
import com.example.fake_social_network.data.repository.remote.RemoteServiceImpl
import com.example.fake_social_network.data.services.handomUserAPI.HandomUserServiceFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val remoteService = RemoteServiceImpl.createRemoteService()
    val contactList = MutableLiveData<Root>()
    val errorMessage = MutableLiveData<String>()
    var coffeeImage = MutableLiveData<CoffeeImage>()
    var dogImage = MutableLiveData<DogImage>()

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


// Como a viewmodel contem argumento é necessário criar uma factory.
/*    companion object {
        class MainViewModelFactory(private val parameter: RemoteService) : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return if (modelClass.isAssignableFrom(MainViewModel::class.java))
                {
                    MainViewModel(this.parameter) as T
                }
                else{
                    throw java.lang.IllegalArgumentException("ViewModel não encontrada")
                }
            }
        }
    }*/
}