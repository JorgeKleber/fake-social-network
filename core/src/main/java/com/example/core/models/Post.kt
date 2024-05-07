package com.example.core.models

data class Post(
    var post_id : String,
    var post_user_image : String,
    var post_user_name : String,
    var post_user_country: String,
    var post_image : String? = null,
    var post_subtitle : String
)
