package com.rio.instagram.model.data_model

data class Comment(
    val comment_id: String,
    val date: String,
    val likes: List<String>,
    val sub_comments_id: String,
    val username: String
)