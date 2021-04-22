package com.example.shouldwatchingma

import android.app.ActionBar
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shouldwatchin.Request.*
import com.example.shouldwatchingma.Adapters.MovieMoodAdapterMain
import com.example.shouldwatchingma.Models.Movie
import com.example.shouldwatchingma.Models.MovieResponse
import com.example.shouldwatchingma.Request.MovieActionApiInterface
import com.example.shouldwatchingma.Utils.Credintials
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_mood.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MoodFragment : Fragment() {

    private var mInterstitialAd: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {





        val root = inflater.inflate(R.layout.fragment_mood, container, false)
        val rc_Mood : RecyclerView = root.findViewById(R.id.rc_Mood)

        val btn_Documentary : Button = root.findViewById(R.id.btn_Documentary)
        val btn_Laugh : Button = root.findViewById(R.id.btn_Laugh)
        val btn_Love : Button = root.findViewById(R.id.btn_Love)
        val btn_Action : Button = root.findViewById(R.id.btn_Action)
        val btn_Afraid : Button = root.findViewById(R.id.btn_Afraid)
        val btn_Anime : Button = root.findViewById(R.id.btn_Anime)
        val btn_Drama : Button = root.findViewById(R.id.btn_Drama)
        val btn_War : Button = root.findViewById(R.id.btn_War)
        val t_documentary : TextView = root.findViewById(R.id.t_documentary)
        val t_action : TextView = root.findViewById(R.id.t_action)
        val t_anime : TextView = root.findViewById(R.id.t_anime)
        val t_drama : TextView = root.findViewById(R.id.t_drama)
        val t_horror : TextView = root.findViewById(R.id.t_horror)
        val t_laugh : TextView = root.findViewById(R.id.t_laugh)
        val t_love : TextView = root.findViewById(R.id.t_love)
        val t_war : TextView = root.findViewById(R.id.t_war)
        val t_mood : TextView = root.findViewById(R.id.t_mood)



            btn_Documentary.setOnClickListener {
            btn_Documentary.visibility=View.GONE
            btn_Laugh.visibility=View.GONE
            btn_Love.visibility=View.GONE
            btn_Action.visibility=View.GONE
            btn_Afraid.visibility=View.GONE
            btn_Anime.visibility=View.GONE
            btn_Drama.visibility=View.GONE
            btn_War.visibility=View.GONE
                t_documentary.visibility=View.GONE
                t_action.visibility=View.GONE
                t_anime.visibility=View.GONE
                t_drama.visibility=View.GONE
                t_horror.visibility=View.GONE
                t_laugh.visibility=View.GONE
                t_love.visibility=View.GONE
                t_war.visibility=View.GONE
                t_mood.visibility=View.GONE

            rc_Mood.layoutManager =
                LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false    )
            rc_Mood.setHasFixedSize(true)
            getMovieDataDocument { movies: List<Movie> ->
                rc_Mood.adapter = MovieMoodAdapterMain(movies)
            }
        }

        btn_Laugh.setOnClickListener{
            btn_Documentary.visibility=View.GONE
            btn_Laugh.visibility=View.GONE
            btn_Love.visibility=View.GONE
            btn_Action.visibility=View.GONE
            btn_Afraid.visibility=View.GONE
            btn_Anime.visibility=View.GONE
            btn_Drama.visibility=View.GONE
            btn_War.visibility=View.GONE
            t_documentary.visibility=View.GONE
            t_action.visibility=View.GONE
            t_anime.visibility=View.GONE
            t_drama.visibility=View.GONE
            t_horror.visibility=View.GONE
            t_laugh.visibility=View.GONE
            t_love.visibility=View.GONE
            t_war.visibility=View.GONE
            t_mood.visibility=View.GONE

            rc_Mood.layoutManager =
                LinearLayoutManager(activity , LinearLayoutManager.VERTICAL , false)
            rc_Mood.setHasFixedSize(true)
            getMovieDataLaugh { movies: List<Movie> ->
                rc_Mood.adapter = MovieMoodAdapterMain(movies)
            }

        }

        btn_Love.setOnClickListener{
            btn_Documentary.visibility=View.GONE
            btn_Laugh.visibility=View.GONE
            btn_Love.visibility=View.GONE
            btn_Action.visibility=View.GONE
            btn_Afraid.visibility=View.GONE
            btn_Anime.visibility=View.GONE
            btn_Drama.visibility=View.GONE
            btn_War.visibility=View.GONE
            t_documentary.visibility=View.GONE
            t_action.visibility=View.GONE
            t_anime.visibility=View.GONE
            t_drama.visibility=View.GONE
            t_horror.visibility=View.GONE
            t_laugh.visibility=View.GONE
            t_love.visibility=View.GONE
            t_war.visibility=View.GONE
            t_mood.visibility=View.GONE

            rc_Mood.layoutManager =
                LinearLayoutManager(activity , LinearLayoutManager.VERTICAL , false)
            rc_Mood.setHasFixedSize(true)
            getMovieDataLove { movies: List<Movie> ->
                rc_Mood.adapter = MovieMoodAdapterMain(movies)
            }
        }

        btn_Action.setOnClickListener{
            btn_Documentary.visibility=View.GONE
            btn_Laugh.visibility=View.GONE
            btn_Love.visibility=View.GONE
            btn_Action.visibility=View.GONE
            btn_Afraid.visibility=View.GONE
            btn_Anime.visibility=View.GONE
            btn_Drama.visibility=View.GONE
            btn_War.visibility=View.GONE
            t_documentary.visibility=View.GONE
            t_action.visibility=View.GONE
            t_anime.visibility=View.GONE
            t_drama.visibility=View.GONE
            t_horror.visibility=View.GONE
            t_laugh.visibility=View.GONE
            t_love.visibility=View.GONE
            t_war.visibility=View.GONE
            t_mood.visibility=View.GONE

            rc_Mood.layoutManager =
                LinearLayoutManager(activity , LinearLayoutManager.VERTICAL , false)
            rc_Mood.setHasFixedSize(true)
            getMovieDataAction { movies: List<Movie> ->
                rc_Mood.adapter = MovieMoodAdapterMain(movies)
            }
        }

        btn_Afraid.setOnClickListener{
            btn_Documentary.visibility=View.GONE
            btn_Laugh.visibility=View.GONE
            btn_Love.visibility=View.GONE
            btn_Action.visibility=View.GONE
            btn_Afraid.visibility=View.GONE
            btn_Anime.visibility=View.GONE
            btn_Drama.visibility=View.GONE
            btn_War.visibility=View.GONE
            t_documentary.visibility=View.GONE
            t_action.visibility=View.GONE
            t_anime.visibility=View.GONE
            t_drama.visibility=View.GONE
            t_horror.visibility=View.GONE
            t_laugh.visibility=View.GONE
            t_love.visibility=View.GONE
            t_war.visibility=View.GONE
            t_mood.visibility=View.GONE

            rc_Mood.layoutManager =
                LinearLayoutManager(activity , LinearLayoutManager.VERTICAL , false)
            rc_Mood.setHasFixedSize(true)
            getMovieDataAfraid { movies: List<Movie> ->
                rc_Mood.adapter = MovieMoodAdapterMain(movies)
            }
        }

        btn_Anime.setOnClickListener{
            btn_Documentary.visibility=View.GONE
            btn_Laugh.visibility=View.GONE
            btn_Love.visibility=View.GONE
            btn_Action.visibility=View.GONE
            btn_Afraid.visibility=View.GONE
            btn_Anime.visibility=View.GONE
            btn_Drama.visibility=View.GONE
            btn_War.visibility=View.GONE
            t_documentary.visibility=View.GONE
            t_action.visibility=View.GONE
            t_anime.visibility=View.GONE
            t_drama.visibility=View.GONE
            t_horror.visibility=View.GONE
            t_laugh.visibility=View.GONE
            t_love.visibility=View.GONE
            t_war.visibility=View.GONE
            t_mood.visibility=View.GONE

            rc_Mood.layoutManager =
                LinearLayoutManager(activity , LinearLayoutManager.VERTICAL , false)
            rc_Mood.setHasFixedSize(true)
            getMovieDataAnime { movies: List<Movie> ->
                rc_Mood.adapter = MovieMoodAdapterMain(movies)
            }
        }

        btn_Drama.setOnClickListener{
            btn_Documentary.visibility=View.GONE
            btn_Laugh.visibility=View.GONE
            btn_Love.visibility=View.GONE
            btn_Action.visibility=View.GONE
            btn_Afraid.visibility=View.GONE
            btn_Anime.visibility=View.GONE
            btn_Drama.visibility=View.GONE
            btn_War.visibility=View.GONE
            t_documentary.visibility=View.GONE
            t_action.visibility=View.GONE
            t_anime.visibility=View.GONE
            t_drama.visibility=View.GONE
            t_horror.visibility=View.GONE
            t_laugh.visibility=View.GONE
            t_love.visibility=View.GONE
            t_war.visibility=View.GONE
            t_mood.visibility=View.GONE

            rc_Mood.layoutManager =
                LinearLayoutManager(activity , LinearLayoutManager.VERTICAL , false)
            rc_Mood.setHasFixedSize(true)
            getMovieDataDrama { movies: List<Movie> ->
                rc_Mood.adapter = MovieMoodAdapterMain(movies)
            }
        }

        btn_War.setOnClickListener{
            btn_Documentary.visibility=View.GONE
            btn_Laugh.visibility=View.GONE
            btn_Love.visibility=View.GONE
            btn_Action.visibility=View.GONE
            btn_Afraid.visibility=View.GONE
            btn_Anime.visibility=View.GONE
            btn_Drama.visibility=View.GONE
            btn_War.visibility=View.GONE
            t_documentary.visibility=View.GONE
            t_action.visibility=View.GONE
            t_anime.visibility=View.GONE
            t_drama.visibility=View.GONE
            t_horror.visibility=View.GONE
            t_laugh.visibility=View.GONE
            t_love.visibility=View.GONE
            t_war.visibility=View.GONE
            t_mood.visibility=View.GONE

            rc_Mood.layoutManager =
                LinearLayoutManager(activity , LinearLayoutManager.VERTICAL , false)
            rc_Mood.setHasFixedSize(true)
            getMovieDataWar { movies: List<Movie> ->
                rc_Mood.adapter = MovieMoodAdapterMain(movies)
            }
        }
        return root
    }



    private fun getMovieDataWar(callback: (List<Movie>) -> Unit){
        val apiService = Credintials.getInstance().create(MovieWarApiInterface::class.java)
        apiService.getMovieListWar().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }
        })
    }


    private fun getMovieDataDrama(callback: (List<Movie>) -> Unit){
        val apiService = Credintials.getInstance().create(MovieDramaApiInterface::class.java)
        apiService.getMovieListDrama().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }
        })
    }


    private fun getMovieDataAnime(callback: (List<Movie>) -> Unit){
        val apiService = Credintials.getInstance().create(MovieAnimeApiInterface::class.java)
        apiService.getMovieListAnime().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }
        })
    }



    private fun getMovieDataAfraid(callback: (List<Movie>) -> Unit){
        val apiService = Credintials.getInstance().create(MovieAfraidApiInterface::class.java)
        apiService.getMovieListAfraid().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }
        })
    }


    private fun getMovieDataAction(callback: (List<Movie>) -> Unit){
        val apiService = Credintials.getInstance().create(MovieActionApiInterface::class.java)
        apiService.getMovieListAction().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }
        })
    }


    private fun getMovieDataLove(callback: (List<Movie>) -> Unit){
        val apiService = Credintials.getInstance().create(MovieLoveApiInterface::class.java)
        apiService.getMovieListLove().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }
        })
    }


    private fun getMovieDataLaugh(callback: (List<Movie>) -> Unit){
        val apiService = Credintials.getInstance().create(MovieLaughApiInterface::class.java)
        apiService.getMovieLisLaugh().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }
        })
    }

    private fun getMovieDataDocument(callback: (List<Movie>) -> Unit){
        val apiService = Credintials.getInstance().create(MovieDocumentaryApiInterface::class.java)
        apiService.getMovieListDocumentary().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }
        })
    }



    }

