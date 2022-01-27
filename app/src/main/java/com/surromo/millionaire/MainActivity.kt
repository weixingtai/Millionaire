package com.surromo.millionaire

import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.surromo.common.base.activity.BaseActivity
import com.surromo.millionaire.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun initView() {
        supportActionBar?.hide()
        val mainBnv: BottomNavigationView = binding.mainBnv
        val navController = findNavController(R.id.main_nhf)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_moment, R.id.nav_friend, R.id.nav_user
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        mainBnv.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.nav_home || destination.id == R.id.nav_moment
                || destination.id == R.id.nav_friend || destination.id == R.id.nav_user
            ) {
                mainBnv.visibility = View.VISIBLE

            } else {
                mainBnv.visibility = View.GONE
            }
        }

    }

    override fun initData() {

    }
}