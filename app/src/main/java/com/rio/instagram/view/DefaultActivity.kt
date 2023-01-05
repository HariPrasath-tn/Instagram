package com.rio.instagram.view

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.replace
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.google.android.material.tabs.TabLayout
import com.rio.instagram.R
import com.rio.instagram.databinding.ActivityDefaultBinding
import com.rio.instagram.view.default_activity_fragments.*

class DefaultActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDefaultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_default)

        val navController= Navigation.findNavController(this, R.id.fragmentContainer)
        setupWithNavController(binding.bottomavigator,navController)
    }
}


//        binding.bottomavigator.setOnItemSelectedListener {
//            when(it.itemId){
//                R.id.homeFragment -> initiate(HomeFragment())
//                R.id.searchFragment -> initiate(SearchFragment())
//                R.id.reelsFragment -> initiate(ReelsFragment())
//                R.id.notificationFragments -> initiate(NotificationFragments())
//                R.id.profileFragment -> initiate(ProfileFragment())
//                else ->{}
//            }
//            true
//        }


//    private fun initiate(fragment: Fragment){
//        var fragmentManager = supportFragmentManager
//        var fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.defaultActivityFrameLayout, fragment)
//        fragmentTransaction.commit()
//    }