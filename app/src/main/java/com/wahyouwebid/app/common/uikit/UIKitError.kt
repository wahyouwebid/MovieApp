package com.wahyouwebid.app.common.uikit

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.wahyouwebid.app.databinding.UikitErrorBinding
import com.wahyouwebid.app.databinding.UikitRecyclerviewBinding
import com.wahyouwebid.app.modules.movie.domain.model.MovieItem
import com.wahyouwebid.app.modules.movie.presentation.adapter.NowPlayingAdapter
import com.wahyouwebid.app.modules.movie.presentation.adapter.PopularAdapter
import com.wahyouwebid.app.modules.movie.presentation.adapter.TopRatedAdapter

class UIKitError(
    context: Context,
    attributeSet: AttributeSet? = null,
) : ConstraintLayout(context, attributeSet) {

     private val binding: UikitErrorBinding = UikitErrorBinding.inflate(
        LayoutInflater.from(context), this, true
    )

    fun setError(
        label: String,
        action:() -> Unit
    ) = with(binding){
        tvLabel.text = label
        btnTryAgain.setOnClickListener {
            action.invoke()
        }
    }
}