package com.example.fake_social_network.ui.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.models.Results
import com.example.fake_social_network.databinding.ActivityMainBinding
import com.example.fake_social_network.ui.viewmodels.MainViewModel
import com.example.fake_social_network.ui.views.adapters.StoryListAdapter
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : MainViewModel
    private var listData = ArrayList<Results>()
    private val storyListAdater = StoryListAdapter(listData)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()

        var linearLayoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,
            false)
        binding.storyList.layoutManager = linearLayoutManager

        binding.storyList.adapter = storyListAdater

    }

    override fun onResume() {
        super.onResume()

        viewModel.getUserList()
        viewModel.getCoffeeImage()
        viewModel.getDogImage()

        viewModel.contactList.observe(this, Observer{ datalist ->
            listData.addAll(datalist.results)
            storyListAdater.notifyDataSetChanged()
        })
    }
}