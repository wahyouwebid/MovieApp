package com.wahyouwebid.app.modules.detail.domain.model

data class MovieDetailItem(
    val id: Int?,
    val title: String?,
    val backdropPath: String?,
    val genres: List<Genres>,
    val overview: String?,
    val posterPath: String?,
    val releaseDate: String?,
    val voteAverage: Double?,
    val voteCount: Int?,
    val status: String?,
) {
    class Genres(
        val id: Int?,
        val name: String?
    )
}
