package com.wahyouwebid.app.modules.detail.presentation

import android.graphics.Color
import android.os.Bundle
import android.view.WindowManager
import androidx.core.view.WindowCompat
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.wahyouwebid.app.BuildConfig
import com.wahyouwebid.app.R
import com.wahyouwebid.app.base.BaseFragment
import com.wahyouwebid.app.base.BaseResultState
import com.wahyouwebid.app.common.utils.hideStatusBar
import com.wahyouwebid.app.common.utils.loadImage
import com.wahyouwebid.app.common.utils.parcelable
import com.wahyouwebid.app.databinding.FragmentMovieDetailBinding
import com.wahyouwebid.app.modules.detail.domain.model.MovieDetailItem
import com.wahyouwebid.app.modules.movie.domain.model.MovieItem
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MovieDetailFragment: BaseFragment<FragmentMovieDetailBinding>(FragmentMovieDetailBinding::inflate) {

    private val viewModel: MovieDetailViewModel by viewModels()

    private val navigation: NavController? by lazy {
        activity?.findNavController(R.id.nav_host)
    }

    private val data: MovieItem? by lazy {
        arguments?.parcelable("data")
    }

    override fun setupView(savedInstanceState: Bundle?) = with(binding) {
        ivBack.setOnClickListener {
            navigation?.navigateUp()
        }
    }

    override fun setupViewModel() {
        viewModel.getDetail(data?.id)
    }

    override fun setupObserveViewModel() {
        viewModel.detail.observe(viewLifecycleOwner) { result ->
            when(result) {
                is BaseResultState.Loading -> {}
                is BaseResultState.Error -> {}
                is BaseResultState.Success -> setData(result.data)
            }
        }
    }

    private fun setData(data: MovieDetailItem) = with(binding) {
        ivBackdrop.loadImage(BuildConfig.imageUrl + data.backdropPath)
        ivPoster.loadImage(BuildConfig.imageUrl + data.posterPath)
        tvTitle.text = data.title
        tvReleaseDate.text = data.releaseDate
        tvViewer.text = data.voteCount.toString()
        tvRating.text = data.voteAverage.toString()
        tvStatus.text = data.status
        tvOverview.text = data.overview
    }

}