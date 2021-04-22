package com.example.shouldwatchingma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shouldwatchin.Request.MovieWarApiInterface
import com.example.shouldwatchingma.Adapters.MovieHomeAdapterMain
import com.example.shouldwatchingma.Models.Movie
import com.example.shouldwatchingma.Models.MovieResponse
import com.example.shouldwatchingma.Utils.Credintials
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        MobileAds.initialize(this@MainActivity)
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        val actionBar = supportActionBar
        actionBar!!.title = ""
        actionBar.hide()

        val homeFragment = HomeFragment()
        val moodFragment = MoodFragment()
        val shouldFragment = ShouldFragment()

        makeCurrentFragment(homeFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener  {
            when (it.itemId) {
                R.id.homeFragment -> makeCurrentFragment(homeFragment)
                R.id.moodFragment -> makeCurrentFragment(moodFragment)
                R.id.shouldFragment -> makeCurrentFragment(shouldFragment)
            }
            true
        }

    }


    private fun makeCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper,fragment)
            commit()
        }


}