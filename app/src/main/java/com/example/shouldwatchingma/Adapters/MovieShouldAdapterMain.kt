package com.example.shouldwatchingma.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shouldwatchingma.Details
import com.example.shouldwatchingma.Models.Movie
import com.example.shouldwatchingma.R



class MovieShouldAdapterMain (private val movies:List<Movie>) : RecyclerView.Adapter<ShouldHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShouldHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.should_movies,parent,false )
        return ShouldHolder(view)
    }

    override fun onBindViewHolder(holder: ShouldHolder, position: Int) {
        var currentItem  = movies[position]
        val  IMAGE_BASE = "https://image.tmdb.org/t/p/w500"

        holder.htittleView.text=currentItem.title
        holder.hvoteView.text=currentItem.vote.toString()
        holder.overviewView.text=currentItem.overview
        holder.popularityView.text=currentItem.popularity.toString()
        holder.releaseView.text=currentItem.release.toString()
        Glide.with(holder.hposterView).load(IMAGE_BASE+currentItem.poster).into(holder.hposterView)


        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, Details::class.java)
            intent.putExtra("Title", currentItem.title)
            intent.putExtra("Vote",currentItem.vote.toString())
            intent.putExtra("Overview", currentItem.overview)
            intent.putExtra("Popularity", currentItem.popularity.toString())
            intent.putExtra("Release", currentItem.release.toString())
            intent.putExtra("Picture", currentItem.poster)
            holder.itemView.context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {

        return movies.size
    }
}

class ShouldHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val htittleView : TextView = itemView.findViewById(R.id.h_title)
    val hvoteView : TextView = itemView.findViewById(R.id.h_voteAverage)
    val hposterView : ImageView = itemView.findViewById(R.id.h_posterPath)
    val overviewView : TextView =  itemView.findViewById(R.id.over)
    val popularityView : TextView = itemView.findViewById(R.id.pop)
    val releaseView : TextView = itemView.findViewById(R.id.rel)


}