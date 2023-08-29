package com.wahyouwebid.app.modules.movie.data.model


import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
data class MovieResponse(
    @SerializedName("page")
    @Expose
    val page: Int?,
    @SerializedName("results")
    @Expose
    val results: List<Result>,
    @SerializedName("total_pages")
    @Expose
    val totalPages: Int?,
    @SerializedName("total_results")
    @Expose
    val totalResults: Int?
)