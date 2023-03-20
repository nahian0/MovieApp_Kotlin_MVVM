package com.example.movieappnahian

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.movieappnahian.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val navController = Navigation.findNavController(this, R.id.fragmentContainerView)

        appBarConfiguration = AppBarConfiguration(navController.graph,binding.drawerLayout)
        NavigationUI.setupWithNavController(binding.navView,navController)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment


        binding.navView.setNavigationItemSelectedListener { It ->
            when (It.itemId) {
                R.id.homeNavigation -> {
                    if (navController.currentDestination?.id == R.id.homePageFragment){
                        binding.drawerLayout.closeDrawer(binding.navView)
                    }else{
                        binding.drawerLayout.closeDrawer(binding.navView)
                        navHostFragment.findNavController().popBackStack()
                    }

                    true
                }
                R.id.bookmarksNavigation -> {
                    if (navController.currentDestination?.id == R.id.bookmarkFragment){
                        binding.drawerLayout.closeDrawer(binding.navView)
                    }else{
                        binding.drawerLayout.closeDrawer(binding.navView)
                        navHostFragment.findNavController().navigate(R.id.action_homePageFragment_to_bookmarkFragment2)
                    }
                    true
                }
                else -> {
                    false
                }
            }

        }


        binding.root

    }

    fun openDrawer(view: View) {
        binding.drawerLayout.openDrawer(GravityCompat.START)
    }


}