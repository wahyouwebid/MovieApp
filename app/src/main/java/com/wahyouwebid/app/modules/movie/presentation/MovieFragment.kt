package com.wahyouwebid.app.modules.movie.presentation

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.wahyouwebid.app.R
import com.wahyouwebid.app.base.BaseFragment
import com.wahyouwebid.app.base.BaseResultState
import com.wahyouwebid.app.common.utils.hide
import com.wahyouwebid.app.common.utils.invisible
import com.wahyouwebid.app.common.utils.show
import com.wahyouwebid.app.databinding.FragmentMovieBinding
import com.wahyouwebid.app.modules.movie.domain.model.MovieItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : BaseFragment<FragmentMovieBinding>(FragmentMovieBinding::inflate) {

    private val viewModel: MovieViewModel by viewModels()

    private val navigation: NavController? by lazy {
        activity?.findNavController(R.id.nav_host)
    }

    override fun setupView(savedInstanceState: Bundle?) {

    }

    override fun setupViewModel() {
        viewModel.getNowPlaying()
        viewModel.getPopular()
        viewModel.getTopRated()
    }

    override fun setupObserveViewModel() {
        viewModel.nowPlaying.observe(viewLifecycleOwner) { result ->
            when (result) {
                is BaseResultState.Loading -> setLoadingNowPlaying(true)
                is BaseResultState.Error -> setErrorNowPlaying()
                is BaseResultState.Success -> setDataNowPlaying(result.data)
            }
        }

        viewModel.popular.observe(viewLifecycleOwner) { result ->
            when (result) {
                is BaseResultState.Loading -> setLoadingPopular(true)
                is BaseResultState.Error -> setErrorPopular()
                is BaseResultState.Success -> setDataPopular(result.data)
            }
        }

        viewModel.topRated.observe(viewLifecycleOwner) { result ->
            when (result) {
                is BaseResultState.Loading -> setLoadingTopRated(true)
                is BaseResultState.Error -> setErrorTopRated()
                is BaseResultState.Success -> setDataTopRated(result.data)
            }
        }
    }

    private fun setDataNowPlaying(data: List<MovieItem>) = with(binding) {
        setLoadingNowPlaying(false)
        uikitErrorNowPlaying.hide()
        uikitNowPlaying.setDataNowPlaying(getString(R.string.title_now_playing), data) {
            goToDetail(it)
        }
    }

    private fun setDataPopular(data: List<MovieItem>) = with(binding) {
        setLoadingPopular(false)
        uikitErrorPopular.hide()
        uikitPopular.setDataPopular(getString(R.string.title_popular), data) {
            goToDetail(it)
        }
    }

    private fun setDataTopRated(data: List<MovieItem>) = with(binding) {
        setLoadingTopRated(false)
        uikitErrorTopRated.hide()
        uikitTopRated.setDataTopRated(getString(R.string.title_top_rated), data) {
            goToDetail(it)
        }
    }

    private fun setLoadingNowPlaying(isLoading: Boolean) = with(binding) {
        if (isLoading) {
            shimmerNowPlaying.show()
            uikitNowPlaying.hide()
            uikitErrorNowPlaying.hide()
        } else {
            shimmerNowPlaying.hide()
            uikitNowPlaying.show()
        }
    }

    private fun setLoadingPopular(isLoading: Boolean) = with(binding) {
        if (isLoading) {
            shimmerPopular.show()
            uikitPopular.hide()
            uikitErrorPopular.hide()
        } else {
            shimmerPopular.hide()
            uikitPopular.show()
        }
    }

    private fun setLoadingTopRated(isLoading: Boolean) = with(binding) {
        if (isLoading) {
            shimmerTopRated.show()
            uikitTopRated.hide()
            uikitErrorTopRated.hide()
        } else {
            shimmerTopRated.hide()
            uikitTopRated.show()
        }
    }

    private fun goToDetail(data: MovieItem) {
        navigation?.navigate(
            R.id.action_movieFragment_to_movieDetailFragment,
            bundleOf("data" to data)
        )
    }

    private fun setErrorNowPlaying() = with(binding){
        uikitErrorNowPlaying.show()
        shimmerNowPlaying.hide()
        uikitNowPlaying.hide()
        uikitErrorNowPlaying.setError(getString(R.string.title_now_playing)) {
            viewModel.getNowPlaying()
        }
    }

    private fun setErrorPopular() = with(binding){
        uikitErrorPopular.show()
        shimmerPopular.hide()
        uikitPopular.hide()
        uikitErrorPopular.setError(getString(R.string.title_popular)) {
            viewModel.getPopular()
        }
    }

    private fun setErrorTopRated() = with(binding){
        uikitErrorTopRated.show()
        shimmerTopRated.hide()
        uikitTopRated.hide()
        uikitErrorTopRated.setError(getString(R.string.title_top_rated)) {
            viewModel.getTopRated()
        }
    }
}