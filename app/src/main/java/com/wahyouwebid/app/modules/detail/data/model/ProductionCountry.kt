package com.wahyouwebid.app.modules.detail.data.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.google.gson.annotations.Expose

@Keep
data class ProductionCountry(
    @SerializedName("iso_3166_1")
    @Expose
    val iso31661: String?,
    @SerializedName("name")
    @Expose
    val name: String?
)