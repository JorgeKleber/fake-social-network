package com.example.fake_social_network.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.models.Root

class MainViewModel : ViewModel( ) {

    val contactList = MutableLiveData<Root>()
    val errorMessage = MutableLiveData<String>()

    fun getUserList()
    {

    }

}