package com.rio.instagram.view_model

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.rio.instagram.model.JsonUtils
import com.rio.instagram.model.data_model.InstaDataModel
import com.rio.instagram.view.default_activity_fragments.adapters.adapter_data_classes.AdapterPostsClass

class HomeFragmentViewModel(application: Application):ViewModel() {
    val instaData = MutableLiveData<List<AdapterPostsClass>>()
    private val jsonUtils = JsonUtils.getJsonUtilsInstance(application)
    private var jsonObject:InstaDataModel =
        Gson().fromJson(jsonUtils.getJsonData("sample.json").toString(), InstaDataModel::class.java)

    fun loadListOfAdapterPostsClass(){
        var postsList:List<AdapterPostsClass> = listOf()
        for(user in jsonObject.users){
            postsList += user.posts.map {
                    AdapterPostsClass(
                        post_id = it.post_id,
                        comments_count = it.comments_count,
                        comments_ids = it.comments_ids,
                        date = it.date,
                        image = it.image,
                        liked_person = it.liked_person,
                        message = it.message,
                        shared = it.shared,
                        tagged_persons = it.tagged_persons,
                        views = it.views,
                        dp = user.profile.dp,
                        username = user.profile.username
                    )
                }
        }

        instaData.value = postsList.shuffled()
    }
}