package com.example.fake_social_network.ui.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.models.Post
import com.example.core.models.Results
import com.example.fake_social_network.databinding.ActivityMainBinding
import com.example.fake_social_network.ui.viewmodels.MainViewModel
import com.example.fake_social_network.ui.views.adapters.FeedListAdapter
import com.example.fake_social_network.ui.views.adapters.StoryListAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : MainViewModel
    private var storyListData = ArrayList<Results>()
    private var feedListData = ArrayList<Post>()
    private val storyListAdater = StoryListAdapter(storyListData)
    private val feedListAdater = FeedListAdapter(feedListData)


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

        binding.feedList.layoutManager = LinearLayoutManager(this)
        binding.feedList.adapter = feedListAdater
    }

    override fun onResume() {
        super.onResume()

        viewModel.getUserList()
        viewModel.getCoffeeImage()
        viewModel.getDogImage()

        viewModel.contactList.observe(this, Observer{ datalist ->
            storyListData.addAll(datalist.results)
            storyListAdater.notifyDataSetChanged()
        })

        viewModel.dogImage.observe(this, Observer {
            feedListData.addAll(viewModel.getFakeData())
            feedListAdater.notifyDataSetChanged()
        })
    }
}