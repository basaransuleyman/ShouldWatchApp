package com.example.shouldwatchingma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import com.bumptech.glide.Glide
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class Details : AppCompatActivity() {

    lateinit var  d_tittle : TextView
    lateinit var d_rate : TextView
    lateinit var d_poster : ImageView
    lateinit var popular : TextView
    lateinit var overview : TextView
    lateinit var releaseDate : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        MobileAds.initialize(this@Details)
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        val actionBar = supportActionBar
        actionBar!!.title="Movie Details"
        actionBar.setDisplayHomeAsUpEnabled(true)


        d_tittle = findViewById(R.id.d_tittle)
        d_rate = findViewById(R.id.d_rate)
        d_poster = findViewById(R.id.d_poster)
        popular = findViewById(R.id.popular)
        overview = findViewById(R.id.overview)
        releaseDate = findViewById(R.id.releaseDate)




        val name : String? = intent.getStringExtra("Title")
        val artist : String? = intent.getStringExtra("Vote")
        val pica : String? = intent.getStringExtra("Picture")
        val over : String? = intent.getStringExtra("Overview")
        val pop : String? = intent.getStringExtra("Popularity")
        val rel : String? = intent.getStringExtra("Release")


        val  IMAGE_BASE = "https://image.tmdb.org/t/p/w500"

        d_tittle.text=name
        d_rate.text=artist
        popular.text=pop
        overview.text=over
        releaseDate.text=rel
        Glide.with(d_poster).load(IMAGE_BASE+pica).into(d_poster)



    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }



}