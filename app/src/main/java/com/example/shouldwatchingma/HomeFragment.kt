package com.example.shouldwatchingma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shouldwatchin.Request.MoviePopularApiInterface
import com.example.shouldwatchin.Request.MovieSoonApiInterface
import com.example.shouldwatchingma.Adapters.MovieHomeAdapterMain
import com.example.shouldwatchingma.Adapters.PersonAdapter
import com.example.shouldwatchingma.Models.Movie
import com.example.shouldwatchingma.Models.MovieResponse
import com.example.shouldwatchingma.Request.MoviePersonApiInterface
import com.example.shouldwatchingma.Request.MovieTopRatedApiInterface
import com.example.shouldwatchingma.Utils.Credintials
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

import com.google.android.gms.ads.interstitial.InterstitialAd
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response




class HomeFragment : Fragment() {




    override fun onCreateView(

            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val rc_View: RecyclerView = root.findViewById(R.id.rc_View)
        val rc_Popular: RecyclerView = root.findViewById(R.id.rc_Popular)
        val rc_Person : RecyclerView = root.findViewById(R.id.rc_Person)


        val personImages : Array<String> = resources.getStringArray(R.array.personImages)
        val adapters = PersonAdapter(personImages)
        rc_Person.layoutManager=LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        rc_Person.setHasFixedSize(true)
        rc_Person.adapter=adapters



        rc_View.layoutManager =
                LinearLayoutManager(activity , LinearLayoutManager.HORIZONTAL , false)
        rc_View.setHasFixedSize(true)
        getMovieDataTop { movies: List<Movie> ->
            rc_View.adapter = MovieHomeAdapterMain(movies)
        }

        rc_Popular.layoutManager =
                LinearLayoutManager(activity , LinearLayoutManager.HORIZONTAL , false)
        rc_Popular.setHasFixedSize(true)
        getMovieDataPopular { movies: List<Movie> ->
            rc_Popular.adapter = MovieHomeAdapterMain(movies)
        }

        return root

    }




    private fun getMovieDataPopular(callback: (List<Movie>) -> Unit){
        val apiService = Credintials.getInstance().create(MoviePopularApiInterface::class.java)
        apiService.getMovieListPopular().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }
        })
    }

    private fun getMovieDataTop(callback: (List<Movie>) -> Unit){
        val apiService = Credintials.getInstance().create(MovieTopRatedApiInterface::class.java)
        apiService.getMovieListTop().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }
        })
    }

}