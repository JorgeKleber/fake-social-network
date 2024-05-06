package com.example.fake_social_network.ui.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.core.models.Results
import com.example.fake_social_network.R

class StoryListAdapter(
    private var listData : List<Results>
) : RecyclerView.Adapter<StoryListAdapter.StoryViewHolder>() {

    inner class StoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var userImage : ImageView

        init {
            userImage = itemView.findViewById(R.id.user_item_image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {

        var viewHolder = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_image,parent,false)

        return  StoryViewHolder(viewHolder)
    }

    override fun getItemCount(): Int {
        return listData.count()
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {

        val imageSource = listData[position].picture?.medium

        loadImage(imageSource!!, holder.userImage)
    }

    private fun loadImage(link: String, imageView : ImageView){
        Glide.with(imageView.context)
            .load(link)
            .into(imageView)
    }
}


