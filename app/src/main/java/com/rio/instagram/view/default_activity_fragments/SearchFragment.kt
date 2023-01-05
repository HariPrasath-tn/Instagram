package com.rio.instagram.view.default_activity_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.rio.instagram.R
import com.rio.instagram.databinding.FragmentSearchBinding
import com.rio.instagram.view.default_activity_fragments.adapters.SearchViewRecyclerViewAdapter
import com.rio.instagram.view.default_activity_fragments.search_fragment_utils.setViewForDefault
import com.rio.instagram.view.default_activity_fragments.search_fragment_utils.setViewForOnClicked
import com.rio.instagram.view_model.FSearchFragmentViewModelFactory
import com.rio.instagram.view_model.SearchFragmentViewModel

class SearchFragment : Fragment(), SearchViewRecyclerViewAdapter.SearchViewInteraction {
    private lateinit var binding:FragmentSearchBinding
    private lateinit var searchFragmentViewModel: SearchFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)
        searchFragmentViewModel = ViewModelProvider(requireActivity(), FSearchFragmentViewModelFactory(requireActivity().application))[SearchFragmentViewModel::class.java]
        binding.searchFragmentDefaultLayout.constraintLayout.setOnClickListener {
            setViewForOnClicked(binding.searchFragmentDefaultLayout.searchFragmentDefaultLinearLayout, binding.searchFragmentOnClickedView)
        }
        setViewForDefault(binding.searchFragmentDefaultLayout.searchFragmentDefaultLinearLayout, binding.searchFragmentOnClickedView)
        return binding.root
    }

    fun initRecyclerViewForDefaultLayout(){
        val adapter = SearchViewRecyclerViewAdapter(this@SearchFragment)
        searchFragmentViewModel.postData.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
        binding.searchFragmentDefaultLayout.searchFragmentRecyclerView.layoutManager = GridLayoutManager(requireActivity(), 3)
        binding.searchFragmentDefaultLayout.searchFragmentRecyclerView.adapter = adapter
        searchFragmentViewModel.loadListOfAdapterSearchClass()
    }


}