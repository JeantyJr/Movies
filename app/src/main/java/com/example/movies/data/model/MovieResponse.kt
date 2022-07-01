package com.example.movies.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class MovieResponse<T>
    (@SerializedName("results") val result: T)

data class MoviesResultResponse(
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("id") val id: Int,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("backdrop_path") val backdropPath: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("vote_average") val voteAverage: String

    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(originalTitle)
        parcel.writeInt(id)
        parcel.writeString(posterPath)
        parcel.writeString(backdropPath)
        parcel.writeString(overview)
        parcel.writeString(releaseDate)
        parcel.writeString(voteAverage)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MoviesResultResponse> {
        override fun createFromParcel(parcel: Parcel): MoviesResultResponse {
            return MoviesResultResponse(parcel)
        }

        override fun newArray(size: Int): Array<MoviesResultResponse?> {
            return arrayOfNulls(size)
        }
    }
}

data class MoviesImagesResponse(
    @SerializedName("file_path") val filePath: String

)