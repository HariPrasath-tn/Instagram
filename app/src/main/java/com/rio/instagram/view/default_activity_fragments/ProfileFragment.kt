package com.rio.instagram.view.default_activity_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.tabs.TabLayoutMediator
import com.rio.instagram.R
import com.rio.instagram.databinding.FragmentProfileBinding
import com.rio.instagram.view.default_activity_fragments.profile_fragments.ProfilePostsFragment
import com.rio.instagram.view.default_activity_fragments.profile_fragments.ProfileReelsFragment
import com.rio.instagram.view.default_activity_fragments.profile_fragments.ProfileTagsFragments

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            setFragment(profileBottomViewNavigator.selectedItemId)
            profileBottomViewNavigator.setOnItemSelectedListener {
                setFragment(it.itemId)
                true
            }
        }

    }

    private fun setFragment(itemId:Int){
        var fragment = when(itemId){
            R.id.profilePostsFragment -> ProfilePostsFragment()
            R.id.profileReelsFragment -> ProfileReelsFragment()
            else -> ProfileTagsFragments()
        }
        var transactionManager = requireActivity().supportFragmentManager.beginTransaction()
        transactionManager.replace(binding.profileFragmentViewContainer.id, fragment)
        transactionManager.commit()
    }
}