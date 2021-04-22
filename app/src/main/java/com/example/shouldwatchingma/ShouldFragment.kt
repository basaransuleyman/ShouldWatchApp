package com.example.shouldwatchingma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shouldwatchin.Request.MovieDayApiInterface
import com.example.shouldwatchin.Request.MovieNowPlayingApiInterface
import com.example.shouldwatchin.Request.MoviePopularApiInterface
import com.example.shouldwatchin.Request.MovieSoonApiInterface
import com.example.shouldwatchingma.Adapters.MovieHomeAdapterMain
import com.example.shouldwatchingma.Adapters.MovieShouldAdapterMain
import com.example.shouldwatchingma.Models.Movie
import com.example.shouldwatchingma.Models.MovieResponse
import com.example.shouldwatchingma.Request.MovieTopRatedApiInterface
import com.example.shouldwatchingma.Utils.Credintials
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.fragment_should2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ShouldFragment : Fragment() {



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {



        val root = inflater.inflate(R.layout.fragment_should2, container, false)
        val rc_Day: RecyclerView = root.findViewById(R.id.rc_Day)

        rc_Day.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)
        rc_Day.setHasFixedSize(true)
        getMovieDataDay { movies : List<Movie> ->
            rc_Day.adapter = MovieShouldAdapterMain(movies)
        }

        return root

    }




    private fun getMovieDataDay(callback: (List<Movie>) -> Unit){
        val apiService = Credintials.getInstance().create(MovieNowPlayingApiInterface::class.java)
        apiService.getMovieListNowPlaying().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse> , t: Throwable) {
            }
            override fun onResponse(call: Call<MovieResponse> , response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }
        })
    }


}