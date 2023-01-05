package com.rio.instagram.model.data_model

data class User(
    val comments: List<Comment>,
    val followers: List<String>,
    val following: List<String>,
    val messages: List<Message>,
    val posts: List<Post>,
    val profile: Profile,
    val tags: List<String>
)