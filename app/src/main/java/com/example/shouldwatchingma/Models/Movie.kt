package com.example.shouldwatchingma.Models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    @SerializedName("title")
    val title: String ?,

    @SerializedName("release_date")
    val release: String ?,

    @SerializedName("poster_path")
    val poster: String ?,

    @SerializedName("popularity")
    val popularity: Number,

    @SerializedName("vote_average")
    val vote: Number,

    @SerializedName("overview")
    val overview: String ?,

    


    ) : Parcelable{
    constructor(): this("","","",0,0,"")
}
