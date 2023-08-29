package com.wahyouwebid.app.common.utils

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.wahyouwebid.app.R
import java.text.SimpleDateFormat
import java.util.Locale

fun ImageView.loadImage(imageUrl: String?) {
    Glide.with(this.context)
        .load(imageUrl)
        .placeholder(R.drawable.bg_placeholder)
        .into(this)
}

inline fun <reified T : Parcelable> Bundle.parcelable(key: String): T? = when {
    Build.VERSION.SDK_INT >= 33 -> getParcelable(key, T::class.java)
    else -> @Suppress("DEPRECATION") getParcelable(key) as? T
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun String.dateFormat(
    sourcePattern: String = "yyyy-MM-dd",
    targetPattern: String = "dd MMM yyyy",
): String {
    val locale = Locale("in", "ID")
    val date = SimpleDateFormat(sourcePattern, locale).parse(this)!!
    return SimpleDateFormat(targetPattern, Locale.getDefault()).format(date)
}
