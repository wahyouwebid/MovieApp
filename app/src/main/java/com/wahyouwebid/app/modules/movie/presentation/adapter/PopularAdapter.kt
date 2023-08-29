package com.wahyouwebid.app.modules.movie.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wahyouwebid.app.BuildConfig
import com.wahyouwebid.app.common.utils.loadImage
import com.wahyouwebid.app.databinding.AdapterPopularBinding
import com.wahyouwebid.app.modules.movie.domain.model.MovieItem

class PopularAdapter(
    private val action: (MovieItem) -> Unit
) : RecyclerView.Adapter<PopularAdapter.ViewHolder>() {

    private var data = ArrayList<MovieItem>()

    fun setData(itemList: List<MovieItem>) {
        data.clear()
        data.addAll(itemList)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.view) {
            val item = data[position]
            ivThumbnail.loadImage(BuildConfig.imageUrl + item.backdropPath.toString())
            root.setOnClickListener {
                action.invoke(item)
            }
        }
    }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        AdapterPopularBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    class ViewHolder(val view: AdapterPopularBinding) : RecyclerView.ViewHolder(view.root)

}