package com.example.fake_social_network.ui.views

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateHandle
import com.example.core.models.Post
import com.example.core.models.Results
import com.example.fake_social_network.R
import com.example.fake_social_network.databinding.FragmentHomeBinding
import com.example.fake_social_network.ui.viewmodels.HomeViewModel
import com.example.fake_social_network.ui.views.adapters.FeedListAdapter
import com.example.fake_social_network.ui.views.adapters.StoryListAdapter
import androidx.recyclerview.widget.LinearLayoutManager

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var storyListData = ArrayList<Results>()
    private var feedListData = ArrayList<Post>()
    private val storyListAdater = StoryListAdapter(storyListData)
    private val feedListAdater = FeedListAdapter(feedListData)

    companion object {
        fun newInstance() = HomeFragment()
    }

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        var linearLayoutManager = LinearLayoutManager(this.context,
            LinearLayoutManager.HORIZONTAL,
            false)

        var linearLayoutManager2 = LinearLayoutManager(this.context,
            LinearLayoutManager.VERTICAL,
            false)

        binding.storyList.layoutManager = linearLayoutManager
        binding.storyList.adapter = storyListAdater

        binding.feedList.layoutManager = linearLayoutManager2
        binding.feedList.adapter = feedListAdater

        return  view
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