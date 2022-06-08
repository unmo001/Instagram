package com.example.instagram

import android.graphics.Color.WHITE
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.telephony.ims.ImsMmTelManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowId
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import com.example.instagram.databinding.ActivityMainBinding
import java.security.cert.TrustAnchor

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(WHITE))
        supportActionBar?.setLogo(R.drawable.insta_logo)
        supportActionBar?.setDisplayUseLogoEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_search, R.id.navigation_market,R.id.navigation_profile,R.id.navigation_shortmovie
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_bar,menu)

        return true
    }





}