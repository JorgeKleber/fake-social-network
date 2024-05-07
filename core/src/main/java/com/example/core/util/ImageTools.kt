package com.example.core.util

import android.widget.ImageView
import com.bumptech.glide.Glide

object ImageTools {
    fun loadImage(link: String, imageView : ImageView){



        Glide.with(imageView.context)
            .load(link)
            .into(imageView)
    }
}