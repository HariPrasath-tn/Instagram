package com.rio.instagram.view.default_activity_fragments.adapters.adapter_data_classes

data class AdapterPostsClass(
    val comments_count: Int,
    val comments_ids: List<String>,
    val date: String,
    val image: List<String>,
    val liked_person: List<String>,
    val message: String,
    val post_id: String,
    val shared: Int,
    val tagged_persons: List<String>,
    val views: Int,
    val dp: String,
    val username: String
)
