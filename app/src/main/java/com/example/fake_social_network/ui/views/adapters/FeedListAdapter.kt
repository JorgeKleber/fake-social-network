package com.example.fake_social_network.ui.views.adapters

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.core.models.Post
import com.example.core.util.ImageTools
import com.example.fake_social_network.R

class FeedListAdapter(
    private val feedList : ArrayList<Post>
) : RecyclerView.Adapter<FeedListAdapter.FeedViewHolder>() {

    inner class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var user_image : ImageView = itemView.findViewById(R.id.user_image)
        var user_name : TextView = itemView.findViewById(R.id.user_name)
        var user_country : TextView = itemView.findViewById(R.id.user_country)
        var post_image : ImageView = itemView.findViewById(R.id.post_image)
        var post_subtitle : TextView = itemView.findViewById(R.id.post_subtitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_layout, parent, false)

        return FeedViewHolder(view)
    }

    override fun getItemCount(): Int {
        return feedList.count()
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {

        ImageTools.loadImage(feedList[position].post_user_image, holder.user_image)
        ImageTools.loadImage(feedList[position].post_image!!, holder.post_image)
        holder.user_name.text = feedList[position].post_user_name
        holder.user_country.text = feedList[position].post_user_country
        holder.post_subtitle.text = "This is a test subtitle, this is a test subtitle"

    }

}