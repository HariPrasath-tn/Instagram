package com.rio.instagram.view_model

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.rio.instagram.model.JsonUtils
import com.rio.instagram.model.data_model.InstaDataModel
import com.rio.instagram.view.default_activity_fragments.adapters.adapter_data_classes.AdapterPostsClass
import com.rio.instagram.view.default_activity_fragments.adapters.adapter_data_classes.AdapterSearchDataClass

class SearchFragmentViewModel(private val application:Application): ViewModel() {
    val postData = MutableLiveData<List<AdapterSearchDataClass>>()
    private val jsonUtils = JsonUtils.getJsonUtilsInstance(application)
    private var jsonObject: InstaDataModel =
        Gson().fromJson(jsonUtils.getJsonData("sample.json").toString(), InstaDataModel::class.java)

    fun loadListOfAdapterSearchClass(){
        var postsList:List<AdapterSearchDataClass> = listOf()
        for(user in jsonObject.users){
            postsList += user.posts.map {
                AdapterSearchDataClass(
                    post_id = it.post_id,
                    image = it.image[0]
                )
            }
        }
        postData.value = postsList
    }
}