package com.wahyouwebid.app.modules.movie.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class MovieItem(
    val id: Int?,
    val title: String?,
    val backdropPath: String?,
    val posterPath: String?,
    val voteAverage: Double?,
): Parcelable