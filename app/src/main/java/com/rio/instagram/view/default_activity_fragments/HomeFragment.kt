package com.rio.instagram.view.default_activity_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rio.instagram.R
import com.rio.instagram.databinding.FragmentHomeBinding
import com.rio.instagram.view.default_activity_fragments.adapters.HomeFragmentRecyclerViewAdapter
import com.rio.instagram.view_model.FHomeFragmentViewModelFactory
import com.rio.instagram.view_model.HomeFragmentViewModel

class HomeFragment : Fragment(), HomeFragmentRecyclerViewAdapter.Interaction{
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeFragmentViewModel: HomeFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        homeFragmentViewModel = ViewModelProvider(this, FHomeFragmentViewModelFactory(requireActivity().application))[HomeFragmentViewModel::class.java]
        homeFragmentViewModel.loadListOfAdapterPostsClass()
        initRecyclerView()
        return binding.root
    }

    private fun initRecyclerView(){
        val adapter = HomeFragmentRecyclerViewAdapter(this@HomeFragment)
        homeFragmentViewModel.instaData.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        binding.homeFragmentRecyclerView.layoutManager = LinearLayoutManager(requireActivity())
        binding.homeFragmentRecyclerView.adapter = adapter
    }
}