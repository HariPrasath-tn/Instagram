package com.rio.instagram.view.default_activity_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.rio.instagram.R
import com.rio.instagram.databinding.FragmentNotificationFragmentsBinding

class NotificationFragments : Fragment() {
    private lateinit var binding: FragmentNotificationFragmentsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_notification_fragments, container, false)
        return binding.root
    }
}