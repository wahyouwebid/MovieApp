package com.wahyouwebid.app.modules.detail.data.model


import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
data class ProductionCompany(
    @SerializedName("id")
    @Expose
    val id: Int?,
    @SerializedName("logo_path")
    @Expose
    val logoPath: String?,
    @SerializedName("name")
    @Expose
    val name: String?,
    @SerializedName("origin_country")
    @Expose
    val originCountry: String?
)