package com.wahyouwebid.app.common.uikit

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.wahyouwebid.app.databinding.UikitShimmerBinding

class UIKitShimmer(
    context: Context,
    attributeSet: AttributeSet? = null,
) : ConstraintLayout(context, attributeSet) {

     private val binding: UikitShimmerBinding = UikitShimmerBinding.inflate(
        LayoutInflater.from(context), this, true
    )

    fun setLoadingNowPlaying(isLoading: Boolean) = with(binding){
        shimmerNowPlaying.isVisible = isLoading
    }

    fun setLoadingPopular(isLoading: Boolean) = with(binding){
        shimmerPopular.isVisible = isLoading
    }

    fun setLoadingTopRated(isLoading: Boolean) = with(binding){
        shimmerTopRated.isVisible = isLoading
    }
}