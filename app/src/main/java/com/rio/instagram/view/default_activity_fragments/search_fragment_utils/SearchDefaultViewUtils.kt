package com.rio.instagram.view.default_activity_fragments.search_fragment_utils

import android.view.View
import com.rio.instagram.view.default_activity_fragments.SearchFragment

fun SearchFragment.setViewForDefault(defaultView: View, onClickedView:View){
    initRecyclerViewForDefaultLayout()
    onClickedView.visibility = View.GONE
    defaultView.visibility = View.VISIBLE
}