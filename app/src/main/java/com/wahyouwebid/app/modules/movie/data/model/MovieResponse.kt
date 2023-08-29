package com.wahyouwebid.app.modules.movie.data.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.wahyouwebid.app.modules.detail.domain.model.MovieDetailItem

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