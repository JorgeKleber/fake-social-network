package com.example.fake_social_network.ui.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.models.Post
import com.example.core.models.Results
import com.example.fake_social_network.R
import com.example.fake_social_network.databinding.ActivityMainBinding
import com.example.fake_social_network.ui.viewmodels.MainViewModel
import com.example.fake_social_network.ui.views.adapters.FeedListAdapter
import com.example.fake_social_network.ui.views.adapters.StoryListAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HomeFragment())

        binding.bottonNavigation.setOnItemSelectedListener {

            when(it.itemId){
                R.id.home -> replaceFragment(HomeFragment())
                R.id.videos -> replaceFragment(VideoFragment())
                R.id.new_post -> replaceFragment(NewFragment())
                R.id.chat -> replaceFragment(ChatFragment())
                R.id.explore -> replaceFragment(ExploreFragment())
            }

            true
        }

            viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private fun replaceFragment(fragment: Fragment)
    {
        val fragmentManager = supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()

        fragmentTransition.replace(R.id.frameLayout, fragment)
        fragmentTransition.commit()
    }
}