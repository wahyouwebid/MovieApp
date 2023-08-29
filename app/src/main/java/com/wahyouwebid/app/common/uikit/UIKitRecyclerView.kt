package com.wahyouwebid.app.common.uikit

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.wahyouwebid.app.databinding.UikitRecyclerviewBinding
import com.wahyouwebid.app.modules.movie.domain.model.MovieItem
import com.wahyouwebid.app.modules.movie.presentation.adapter.NowPlayingAdapter
import com.wahyouwebid.app.modules.movie.presentation.adapter.PopularAdapter
import com.wahyouwebid.app.modules.movie.presentation.adapter.TopRatedAdapter

class UIKitRecyclerView(
    context: Context,
    attributeSet: AttributeSet? = null,
) : ConstraintLayout(context, attributeSet) {

     private val binding: UikitRecyclerviewBinding = UikitRecyclerviewBinding.inflate(
        LayoutInflater.from(context), this, true
    )

    fun setDataNowPlaying(
        label: String?,
        data: List<MovieItem>,
        action: (MovieItem) -> Unit
    ) = with(binding){
        val nowPlayingAdapter = NowPlayingAdapter { action.invoke(it) }
        tvLabel.text = label
        rvData.setHasFixedSize(false)
        rvData.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvData.adapter = nowPlayingAdapter
        nowPlayingAdapter.setData(data)
        nowPlayingAdapter.notifyItemRangeChanged(0, nowPlayingAdapter.itemCount)
    }

    fun setDataPopular(
        label: String?,
        data: List<MovieItem>,
        action: (MovieItem) -> Unit
    ) = with(binding){
        val popularAdapter = PopularAdapter { action.invoke(it) }
        tvLabel.text = label
        rvData.setHasFixedSize(false)
        rvData.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvData.adapter = popularAdapter
        popularAdapter.setData(data)
        popularAdapter.notifyItemRangeChanged(0, popularAdapter.itemCount)
    }

    fun setDataTopRated(
        label: String?,
        data: List<MovieItem>,
        action: (MovieItem) -> Unit
    ) = with(binding){
        val topRatedAdapter = TopRatedAdapter { action.invoke(it) }
        tvLabel.text = label
        rvData.setHasFixedSize(false)
        rvData.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvData.adapter = topRatedAdapter
        topRatedAdapter.setData(data)
        topRatedAdapter.notifyItemRangeChanged(0, topRatedAdapter.itemCount)
    }

}