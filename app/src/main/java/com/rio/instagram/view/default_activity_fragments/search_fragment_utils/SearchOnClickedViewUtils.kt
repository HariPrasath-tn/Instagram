package com.rio.instagram.view.default_activity_fragments.search_fragment_utils

import android.view.View
import com.rio.instagram.view.default_activity_fragments.SearchFragment

fun SearchFragment.onBackClicked(defaultView: View, onClickedView:View){
    defaultView.visibility = View.VISIBLE
    onClickedView.visibility = View.GONE
}

fun SearchFragment.setViewForOnClicked(defaultView: View, onClickedView:View){
    onClickedView.visibility = View.VISIBLE
    defaultView.visibility = View.GONE
}