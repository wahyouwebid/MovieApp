package com.wahyouwebid.app.modules.detail.data.model


import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
data class Genre(
    @SerializedName("id")
    @Expose
    val id: Int?,
    @SerializedName("name")
    @Expose
    val name: String?
)