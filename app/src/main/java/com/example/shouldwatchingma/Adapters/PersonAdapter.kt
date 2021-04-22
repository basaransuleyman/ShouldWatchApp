package com.example.shouldwatchingma.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shouldwatchingma.R


class PersonAdapter(val personImages:Array<String>) : RecyclerView.Adapter<PersonAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val personImage : ImageView = itemView.findViewById(R.id.myPerson)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.person_movies,parent,false )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.personImage).load(personImages[position]).into(holder.personImage)

    }

    override fun getItemCount(): Int {
        return personImages.size
    }
}

